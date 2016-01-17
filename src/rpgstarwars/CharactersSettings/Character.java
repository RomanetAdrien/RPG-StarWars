/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgstarwars.CharactersSettings;

import rpgstarwars.ItemsSettings.Inventory;
import java.util.Set;
import javax.swing.JOptionPane;
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
    
    
    public String play(){
        int capacitiesnumber= this.capacities.size();
        String playerinput =null;
        int choice;
        int i=0;
        Capacity[] tabcapacities = new Capacity[capacitiesnumber+5];
        String Text = "It's the turn of " + this.name +" \n\n";
        Text+="What will the hero's decision be ?\n";
        for(Capacity capacity : this.capacities){
            
                Text+=Integer.toString(i+1) + ": " + capacity.getName() +"\n";
                tabcapacities[i]=capacity;
                i++;
            }
        Text+=Integer.toString(i+1) + ": Grenade\n";
                i++;        
        do
        {
            playerinput = JOptionPane.showInputDialog(Text);
            choice = Integer.parseInt(playerinput);
        }while(choice<1 && choice>capacitiesnumber+1);
                
        if(choice == capacitiesnumber+1 ){
            return "*&&"+this.getInventory().getGrenades().getData();
        }
        else{
            return "+&&"+tabcapacities[choice-1].getData();
        }
    }
    
    public void takeDamage(int damage){
        int newhealth=this.health-damage;
        if(newhealth<0){
            this.setHealth(0);
        }
        else{
            this.setHealth(newhealth);
        }
    }
    
    public void isHealed(int amount){
        int newhealth=this.health+amount;
        if(newhealth>this.getStats().getMaxhp()){
            this.setHealth(this.getStats().getMaxhp());
        }
        else{
            this.setHealth(newhealth);
        }
    }
    
   
    public boolean isAlive(){
        return this.health>0;
    }
    
    public void nextTurn(){
        this.status.nextTurn();
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
