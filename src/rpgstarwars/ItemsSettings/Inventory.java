/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgstarwars.ItemsSettings;

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
    private int bananas; //bananas give back force points to the user
    private Set<Weapon> weapons;
    private Set<Armor> armors;
    private Set<Grenade> grenades;
    
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
    public Set<Grenade> getGrenades() {
        return grenades;
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

    public void setGrenades(Set<Grenade> grenades) {
        this.grenades = grenades;
    }
    
}
