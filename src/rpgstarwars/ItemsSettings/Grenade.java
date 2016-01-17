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

    public Grenade(String name, int price, int weight, int level, int damage) {
        super(name, price, weight, level);
        this.damage=damage;
    }
    
    public static Grenade thermalDetonator(){
        
        Grenade detonator = new Grenade("ThermalDetonator", 10, 1, 1, 20);
        detonator.setNumber(3);
        return detonator;
    }
    
    public String getData() { //returns the necessary infos for a chosen capacity;
        
        String result ="";
        result+="damage"+"&&";
        result+=Integer.toString(this.getDamage())+"&&";
        result+=String.valueOf(1==1);
        return result;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    
    
    
    
}
