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
    
    
}