/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgstarwars;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rpgstarwars.CharactersSettings.Monster;
import rpgstarwars.CharactersSettings.Character;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Malomek
 */
public class Combat {
     public Set<Character> heroes;
     public Set<Monster> villains;
     public int turn;
     public int protagonists; //number of fighters
     public int current;  //current monster or hero playing
     public Set<Character> characterready;
     public Set<Character> characterdone;
     public Set<Monster> monsterready;
     public Set<Monster> monsterdone;

    public Combat(Set<Character> heroes, Set<Monster> villains) {
        this.heroes = heroes;
        this.villains = villains;
        this.turn = 0;
        this.characterready=heroes;
        this.monsterready=villains;
        this.characterdone= new HashSet<>();
        this.monsterdone= new HashSet<>();
    }
    
    
    public String nextPlay(){
        Character nextcharacter = this.findNextcharacter();
        Monster nextmonster = this.findNextmonster();
        if(nextcharacter==null){
            this.monsterhasPlayed(nextmonster);
            return nextmonster.play();
        }
        if(nextmonster==null){
            this.characterhasPlayed(nextcharacter);
            return nextcharacter.play();
        }
        
        if(nextcharacter.getStats().getSpeed()>nextmonster.getStats().getSpeed()){
            this.characterhasPlayed(nextcharacter);
            return nextcharacter.play();
        }
        else{
            if(nextcharacter.getStats().getSpeed()<nextmonster.getStats().getSpeed()){
                this.monsterhasPlayed(nextmonster);
                return nextmonster.play();
            }
            else{
                if(Game.dice(2)==1){
                    this.characterhasPlayed(nextcharacter);
                    return nextcharacter.play();
                }
                else{
                    this.monsterhasPlayed(nextmonster);
                    return nextmonster.play();
                }
            }
        }
    }
    
    public String chooseTarget(String playerchoice){
        System.out.println("bibi");
        String[] data = playerchoice.split("&&");
        String result = "";
        String target = data[0];
        if (target=="monsterplay"){
            return this.monsterplay();
        }
        if(target=="*" || Boolean.parseBoolean(data[3])){
            result+=this.findanyMonster().getName();
            return result + "&&" + data[1] + "&&" + data[2] + "&&" +data[3];
        }
        else{
            String Text="Time to pick a target !\n\n";
            int i = 0,choice=0;
            String[] monsternames = new String[villains.size()];
            
            for(Monster monster : villains){
            Text+=Integer.toString(i+1) + ": " + monster.getName();
            monsternames[i]=monster.getName();
            i++;
            }
            
            do
        {
            String playerinput = JOptionPane.showInputDialog(Text);
            choice = Integer.parseInt(playerinput);
        }while(choice<1 && choice>villains.size());
            String playerinput=monsternames[choice-1];
            return playerinput + "&&" + data[1] + "&&" + data[2] + "&&" +data[3];
        }
        
    }
    
    public void action(String action){ //action comes under the forme "target&&effect&&amount&&area" or null if monster played
        if(action==null){return;}
        String[] data = action.split("&&"); 
        String target = data[0];
        String effect = data[1];
        int amount = Integer.parseInt(data[2]);
        Boolean area = Boolean.valueOf(data[3]);
        if(!"heal".equals(effect)){
        for(Monster monster : villains){
            
                if(monster.getName().equals(target)){
                if("damage".equals(effect)){
                    this.inflictdamage(monster, amount, area);
                    return;
                }
                if("control".equals(effect)){
                    this.controlennemi(monster, amount, area);
                    return;
                }
            }
            }
        }
        else{
            for(Character character : heroes){
                if(character.getName().equals(target)){
                    this.healally(character,amount,area);
                    return;
                }
            }
        }   
    }
    
    public String monsterplay(){
        for(Character character : heroes){
            character.takeDamage(5);
        }
        return null;
    }
    
    public void healally(Character target, int amount, Boolean area){
        if(area){
            for(Character character : heroes){
            character.isHealed(amount);
        }    
        }
        else{
            target.isHealed(amount);
        }
    }
    
    public void controlennemi(Monster target, int amount, Boolean area){
        if(area){
            for(Monster monster : villains){
            monster.iscontrolled(amount);
        }    
        }
        else{
            target.iscontrolled(amount);
        }
    }
    
    public void inflictdamage(Monster target, int amount, Boolean area){
        if(area){
            for(Monster monster : villains){
            monster.takeDamage(amount);
        }    
        }
        else{
            target.takeDamage(amount);
        }
        
    }
    
    
    public Character findNextcharacter(){
    Character nextplayer = null;
    int maxspeed = 0;
    if (characterready.size()==0){return null;}
    
    for(Character character : characterready){
           if(maxspeed<character.getStats().getSpeed()){
               maxspeed=character.getStats().getSpeed();
               nextplayer=character;
           } 
           if(maxspeed==character.getStats().getSpeed()){
               if(Game.dice(2)==1){
                   maxspeed=character.getStats().getSpeed();
                   nextplayer=character;
               }
           }
        
        }
    return nextplayer;
    }
    
    public Monster findNextmonster(){
    Monster nextmonster = null;
    int maxspeed = 0;
    if (monsterready.size()==0){return null;}
    
    for(Monster monster : monsterready){
           if(maxspeed<monster.getStats().getSpeed()){
               maxspeed=monster.getStats().getSpeed();
               nextmonster=monster;
           } 
           if(maxspeed==monster.getStats().getSpeed()){
               if(Game.dice(2)==1){
                   maxspeed=monster.getStats().getSpeed();
                   nextmonster=monster;
               }
           }
        
        }
    return nextmonster;
    }
   
    public void monsterhasPlayed(Monster monster){
        this.monsterdone.add(monster);
        this.monsterready.remove(monster);
    }
    
    public void characterhasPlayed(Character character){
        this.characterdone.add(character);
        this.monsterready.remove(character);
    }
    
    public void combatRun(){
        while(this.testGrouplife()&&this.testMonsterlife()){
            action(this.chooseTarget(nextPlay()));
            this.removeDead();
            combatSummary();
            if(this.endTurn()){
                nextTurn();
            }
        }
        if(this.testGrouplife()){
            combatVictory();
        }
    }
    
    public void combatVictory(){
        
       /* FileInputStream blah = null;
         try {
             blah = new FileInputStream("./victoryfanfare.mp3");
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Combat.class.getName()).log(Level.SEVERE, null, ex);
         }
        AudioStream as = null;
         try {
             as = new AudioStream(blah);
         } catch (IOException ex) {
             Logger.getLogger(Combat.class.getName()).log(Level.SEVERE, null, ex);
         }
        AudioPlayer.player.start(as);
        
        String Text ="VICTORY FOR THE HEROES !";
        JOptionPane.showMessageDialog(null, Text);
        
        AudioPlayer.player.stop(as);
        */
        
    }
    
    public boolean endTurn(){
        if(monsterready.isEmpty()&&characterready.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void nextTurn(){
        this.turn+=1;
        
        for(Character character : characterready){
           character.nextTurn();    
        }
        
        monsterready=villains;
        characterready=heroes;
        monsterdone.clear();
        characterdone.clear();
    }
    
    public void nextplayer(){
        if(current==protagonists){
            current=1;
        }
        else{
            current+=1;
        }
        this.nextTurn();
    }
    
    public void speedTest(){
        int j=0,i=0;
        Set fighters = new HashSet<>();
        for(Monster monster : villains){
            fighters.add(monster);
        }
        for(Character character : heroes){
            fighters.add(character);
        }
        
    }
    
    public boolean testMonsterlife(){
        
      if(villains.isEmpty()){
          return false;
      }
      return true;
    }
    
    public boolean testGrouplife(){
        if(heroes.isEmpty()){
            return false;
        }
        return true;
    }
    
    public void removeDead(){
        Monster mprevious = null;
        Character cprevious =null;
        for(Monster monster : this.villains){
            if(mprevious!=null){
                villains.remove(mprevious);
                mprevious=null;
            }
            if(!monster.isAlive()){
                mprevious=monster;
            }
        }
        for(Character character : this.heroes){
            if(cprevious!=null){
                heroes.remove(cprevious);
                cprevious=null;
            }
            if(!character.isAlive()){
                cprevious=character;
            }
        }
        if(mprevious!=null){
                villains.remove(mprevious);
                mprevious=null;
            }
        if(cprevious!=null){
                heroes.remove(cprevious);
                cprevious=null;
            }
    }
    
    public Monster findanyMonster(){
        Monster anymonster = null;
        for(Monster monster : this.villains){
            anymonster= monster;
        }
         return anymonster;
    }
     
     public static Combat noCombat() {
         
         Combat nocombat = new Combat(null,null);
         return nocombat;
        }
     
     public void combatSummary(){
         String Text = "";
         Text+="Combat summary\n\n Heroes :\n";
         for(Character character : this.heroes){
            Text+=character.getName()+" : "+Integer.toString(character.getHealth())+" HP";
            Text+="  "+Integer.toString(character.getStats().getForce())+" FP\n";
        }
         Text+="\n Villains :\n";
         for(Monster monster : this.villains){
            Text+=monster.getName()+" : "+Integer.toString(monster.getHealth())+" HP";
            Text+="\n";
        }
         
         JOptionPane.showMessageDialog(null, Text);   
     }
}


