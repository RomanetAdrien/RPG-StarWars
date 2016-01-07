/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgstarwars;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import rpgstarwars.CharactersSettings.Monster;
import rpgstarwars.CharactersSettings.Character;

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

    public Combat(Set<Character> heroes, Set<Monster> villains, int turn) {
        this.heroes = heroes;
        this.villains = villains;
        this.turn = turn;
        this.characterready=heroes;
        this.monsterready=villains;
        this.characterdone= new HashSet<>();
        this.monsterdone= new HashSet<>();
    }
    
    public String nextPlay(){
        Character nextcharacter = this.findNextcharacter();
        Monster nextmonster = this.findNextmonster();
        if(nextcharacter==null){
            return nextmonster.play();
        }
        if(nextmonster==null){
            return nextcharacter.play();
        }
        
        if(nextcharacter.getStats().getSpeed()>nextmonster.getStats().getSpeed()){
            return nextcharacter.play();
        }
        else{
            if(nextcharacter.getStats().getSpeed()<nextmonster.getStats().getSpeed()){
                return nextmonster.play();
            }
            else{
                if(Game.dice(2)==1){
                    return nextcharacter.play();
                }
                else{
                    return nextmonster.play();
                }
            }
        }
    }
    
    public void action(String action){
        
        String[] donnees = action.split("&&");
        String target = donnees[0];
        String effect = donnees[1];
        int amount = Integer.parseInt(donnees[2]);
        Boolean area = Boolean.valueOf(donnees[3]);
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
   
    
    
    public void nextTurn(){
        this.turn+=1;
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
        
        for(Monster monster : this.villains){
            if(monster.isAlive()){
                return false;
            }
        }
        return true;
    }
    
    public boolean testGrouplife(){
        
        for(Character character : this.heroes){
            if(character.isAlive()){
                return false;
            }
        }
        return true;
    }
     
     
     public static Combat noCombat() {
         
         Combat nocombat = new Combat(null,null,0);
         return nocombat;
}
     
}


