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
    private Stats stats;
    private Set<Capacity> capacities;
    private Inventory inventory;
    private Armor armor;
    private Weapon weapon;
    private Status status;
    
}
