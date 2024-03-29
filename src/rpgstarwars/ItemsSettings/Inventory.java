/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgstarwars.ItemsSettings;

import java.util.HashSet;
import java.util.Set;
import rpgstarwars.ItemsSettings.Armor;
import rpgstarwars.ItemsSettings.Grenade;
import rpgstarwars.ItemsSettings.Weapon;

/**
 *
 * @author Malomek
 */
public class Inventory {

    private int totalweight;
    private int healthpacks;
    private int credits;
    private int bananas; //bananas give back force points to the user
    private Set<Weapon> weapons;
    private Set<Armor> armors;
    private Grenade grenades;

    public Inventory() {
        this.armors = new HashSet<>();
        //this.grenades = new HashSet<>();
        this.grenades=Grenade.thermalDetonator();
        this.weapons = new HashSet<>();
        this.totalweight=0;
        this.healthpacks=1;
        this.bananas=0;
        
    }
    
    public void gainCredits(int credits){
        this.credits+=credits;
    }
    
    public int getTotalweight() {
        return totalweight;
    }
    public int getHealthpacks() {
        return healthpacks;
    }
    public int getBananas() {
        return bananas;
    }
    public Set<Weapon> getWeapons() {
        return weapons;
    }
    public Set<Armor> getArmors() {
        return armors;
    }
    public Grenade getGrenades() {
        return grenades;
    }
    public int getCredits() {
        return credits;
    }
    public void setTotalweight(int totalweight) {
        this.totalweight = totalweight;
    }
    public void setHealthpacks(int healthpacks) {
        this.healthpacks = healthpacks;
    }
    public void setBananas(int bananas) {
        this.bananas = bananas;
    }
    public void setWeapons(Set<Weapon> weapons) {
        this.weapons = weapons;
    }
    public void setArmors(Set<Armor> armors) {
        this.armors = armors;
    }
    public void setGrenades(Grenade grenades) {
        this.grenades = grenades;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    
}
