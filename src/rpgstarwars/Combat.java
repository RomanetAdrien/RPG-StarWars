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
import java.util.Iterator;
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
     public Set<Monster> originalvillains;
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
        this.originalvillains= new HashSet<>();
        this.characterready= new HashSet<>();
        this.monsterready= new HashSet<>();
        this.villains= new HashSet<>();
        this.originalvillains = villains;
        //this.villains = this.originalvillains;
        for(Monster monster : originalvillains){
            this.villains.add(monster);
            this.monsterready.add(monster);
        }
        for(Character character : heroes){
            this.characterready.add(character);
        }
        this.turn = 0;
        this.characterdone= new HashSet<>();
        this.monsterdone= new HashSet<>();
        this.protagonists=villains.size()+heroes.size();
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
        String[] data = playerchoice.split("&&");
        String result = "";
        String playerinput="";
        String target = data[0];
        if (target.equals("monsterplay")){
            return this.monsterplay();
        }
        if("*".equals(target) || Boolean.parseBoolean(data[3])){
            result+=this.findanyMonster().getName();
            return result + "&&" + data[1] + "&&" + data[2] + "&&" +data[3];
        }
        else{
            String Text="Time to pick a target !\n\n";
            int i = 0,choice=0;
            String[] monsternames = new String[villains.size()];
            
            for(Monster monster : villains){
            Text+=Integer.toString(i+1) + ": " + monster.getName()+"\n";
            monsternames[i]=monster.getName();
            i++;
            }
            
            do
        {
            playerinput = JOptionPane.showInputDialog(Text);
            if(isInteger(playerinput)){
            choice = Integer.parseInt(playerinput);                
            }

        }while((!isInteger(playerinput)) || choice<1 || choice>villains.size());
            playerinput=monsternames[choice-1];
            return playerinput + "&&" + data[1] + "&&" + data[2] + "&&" +data[3];
        }
        
    }
    
    public static boolean isInteger(String s) {
    try { 
        Integer.parseInt(s); 
    } catch(NumberFormatException e) { 
        return false; 
    } catch(NullPointerException e) {
        return false;
    }
    // only got here if we didn't return false
    return true;
}
    
    public void action(String action){ //action comes under the forme "target&&effect&&amount&&area" or null if monster played
        if(action==null){return;}
        int amount =0;
        String[] data = action.split("&&"); 
        String target = data[0];
        String effect = data[1];
        amount = Integer.parseInt(data[2]);
        Boolean area = Boolean.valueOf(data[3]);
        if(target.equals("monsterplay")){
            monsterAttack(amount);
        }
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
            character.takeDamage(Game.dice(this.protagonists)+5);
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
    
    public void monsterAttack(int damage){
        int rand = Game.dice(heroes.size());
        int i=0;
        for(Character character : heroes){
            if(i==rand){
                character.takeDamage(damage);
            }
            i++;
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
        this.characterready.remove(character);
    }
    
    public void combatRun(){
        this.combatBegin();
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
        else{
            combatDefeat();
        }
    }
    
    public void combatBegin(){
        String Text ="By the force ! You are attacked !\n";
        Text+="Your ennemies are :\n";
        for(Monster monster : villains){
            Text+=monster.getName()+"\n";
        }
        JOptionPane.showMessageDialog(null, Text);
    }
    
    public void combatVictory(){
        //the following commentary block is a reminder of a miserable failure to add sound in case of victory
       /* FileInputStream blah = null;
         try {
             blah = new FileInputStream("victoryfanfare.mp3");
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
        
        int moneygain = 0;
        for(int i=0;i<this.protagonists;i++){
            moneygain+=Game.dice(5)-1;
        }
        String Text ="VICTORY FOR THE HEROES !\n";
        Text+="You win "+ Integer.toString(this.protagonists) +" XP  and "+Integer.toString(moneygain)+" credits";
        for(Character character : heroes){
            character.xpGain(this.protagonists);
            character.gainCredits(moneygain);
        }
        JOptionPane.showMessageDialog(null, Text);
        
    }
    
    public void combatDefeat(){
        String Text ="You are a disgrace, I shut this programm down \n before you have the time to embarass yourself further.";
        JOptionPane.showMessageDialog(null, Text);
        System.exit(0);
        System.out.println("If you are able to read this I have failed to shut the programm  down");
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
        
        for(Monster monster : originalvillains){
            this.villains.add(monster);
            this.monsterready.add(monster);
        }
        for(Character character : heroes){
            this.characterready.add(character);
        }
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
    public void removeDeadmonster(){
        
    }
    
    public void removeDead(){
        Monster mprevious = null;
        Character cprevious =null;
         for (Monster monster : originalvillains) {
             if(mprevious!=null){
                 villains.remove(mprevious);
                 mprevious=null;
             }if(!monster.isAlive()){
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


