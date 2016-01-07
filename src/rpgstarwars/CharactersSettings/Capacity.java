/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgstarwars.CharactersSettings;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Malomek
 */
public class Capacity {
    
    private String name;
    private String type; //Damage, control or heal
    private int amount;
    private int cost;
    private boolean area;//1 if affects entire team,0 if not


    public Capacity(String name, String type, int amount, int cost, boolean area) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.cost=cost;
        this.area=area;
    }
    
    public static Set<Capacity> initCapacities(String subclass) {
        
        Set<Capacity> capacities = new HashSet<Capacity>();
        Capacity baseattack = new Capacity("Base Attack","damage",5,0,false);
        Capacity capacity1 = null;
        Capacity capacity2 = null;
        
        
        switch(subclass){
        
             case "BountyHunter":
                capacity1= new Capacity("Make it rain","damage",10,0,true);
                capacity2= new Capacity("Flamethrower","damage",30,0,false);
                break;
                
            case "JediKnight":
                capacity1= new Capacity("Force push","damage",40,5,false);
                capacity2= new Capacity("Lighsaber throw","damage",20,2,false);
                break;
                
            case "JediMaster":
                capacity1= new Capacity("Force Heal","heal",30,5,false);
                capacity2= new Capacity("Force Stasis","control",3,5,false);
                break;
            
            case "SithLord":
                capacity1= new Capacity("Force Lightning","damage",40,5,false);
                capacity2= new Capacity("Fear me","control",1,5,true);
                break;
                
            case "Smuggler":
                capacity1= new Capacity("Dirty Kick","control",3,0,false);
                capacity2= new Capacity("Wild Wild West","damage",10,0,true);
                break;
                
            case "Soldier":
                capacity1= new Capacity("Grenade Launcher","damage",15,0,true);
                capacity2= new Capacity("Medpac","heal",20,0,false);
                break;
            
            case "WookieWarrior":
                capacity1= new Capacity("Mad Claw","damage",25,0,false);
                capacity2= new Capacity("Wild Roar","control",1,0,true);
                break;
        }
        
        capacities.add(baseattack);
        capacities.add(capacity1);
        capacities.add(capacity2);
        
        return capacities;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public boolean isArea() {
        return area;
    }
    public void setArea(boolean area) {
        this.area = area;
    }
    
    
}
