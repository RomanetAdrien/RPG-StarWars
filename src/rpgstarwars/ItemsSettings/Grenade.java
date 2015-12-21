/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgstarwars.ItemsSettings;

/**
 *
 * @author Malomek
 */
public class Grenade extends Item{
    private int damage;
    private int number; //tells how much of this particular grenade the user has.

    public Grenade(String name, int price, int weight, int level) {
        super(name, price, weight, level);
    }
    
    
}
