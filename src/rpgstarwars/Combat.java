/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgstarwars;

import java.util.Set;
import rpgstarwars.CharactersSettings.Monster;

/**
 *
 * @author Malomek
 */
public class Combat {
     public Set<Character> heroes;
     public Set<Monster> villains;
     public int turn;

    public Combat(Set<Character> heroes, Set<Monster> villains, int turn) {
        this.heroes = heroes;
        this.villains = villains;
        this.turn = turn;
    }
     
     
    public boolean testMonsterlife(){
        boolean res=false;
        ;
        
    }
     
     
     public static Combat noCombat() {
         
         Combat nocombat = new Combat(null,null,0);
         return nocombat;
}
     
}


