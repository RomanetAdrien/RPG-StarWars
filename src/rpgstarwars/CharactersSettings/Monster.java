/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgstarwars.CharactersSettings;

/**
 *
 * @author Malomek
 */
public class Monster {
    private String name;
    private int maindamage;
    private Stats stats;
    private Status status;

    public Monster(String name, int maindamage, Stats stats) {
        this.name = name;
        this.maindamage = maindamage;
        this.stats = stats;
        this.status= new Status();
    }
    
    
}
