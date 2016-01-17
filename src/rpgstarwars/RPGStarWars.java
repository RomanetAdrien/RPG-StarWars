/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgstarwars;

import java.util.HashSet;
import java.util.Set;
import rpgstarwars.CharacterClasses.BountyHunter;
import rpgstarwars.CharactersSettings.Monster;

/**
 *
 * @author Malomek
 */
public class RPGStarWars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       BountyHunter joueur =new BountyHunter("bibi");
        Set gentil= new HashSet<>();
        Set mechant= new HashSet<>();
        mechant.add(Monster.cleaningDroid());
        mechant.add(Monster.cleaningDroid());
        gentil.add(joueur);
        Combat fight = new Combat(gentil,mechant);
       fight.combatRun();
       
        
        
        // TODO code application logic here
    }
    
}
