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

    public Combat(Set<Character> heroes, Set<Monster> villains, int turn) {
        this.heroes = heroes;
        this.villains = villains;
        this.turn = turn;
    }
     
    
    
    public void nextTurn(){
        this.turn+=1;
    }
    
    public void nextplayer(){
        if(current==protagonists){
            current=1;
            this.nextTurn();
        }
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


