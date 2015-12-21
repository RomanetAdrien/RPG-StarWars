/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgstarwars.CharactersSettings;

import rpgstarwars.ItemsSettings.Inventory;
import java.util.Set;
import rpgstarwars.ItemsSettings.Armor;
import rpgstarwars.ItemsSettings.Weapon;

/**
 *
 * @author Malomek
 */
public class Character {
    
    private String name;
    private int health;
    private Stats stats;
    private Set<Capacity> capacities;
    private Inventory inventory;
    private Armor armor;
    private Weapon weapon;
    private Status status;

    public Character(String name, String subclass) {
        this.name = name;
        this.inventory = new Inventory();
        this.status= new Status();
        this.stats= new Stats(subclass);
        this.armor= new Armor(subclass);
        this.weapon=new Weapon(subclass);
        this.capacities= Capacity.initCapacities(subclass);
        this.health=this.stats.getMaxhp();
        
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public Stats getStats() {
        return stats;
    }
    public void setStats(Stats stats) {
        this.stats = stats;
    }
    public Set<Capacity> getCapacities() {
        return capacities;
    }
    public void setCapacities(Set<Capacity> capacities) {
        this.capacities = capacities;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public Armor getArmor() {
        return armor;
    }
    public void setArmor(Armor armor) {
        this.armor = armor;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    
}
