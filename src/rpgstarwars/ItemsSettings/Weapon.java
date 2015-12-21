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
public class Weapon extends Item{
    private int damage;
    private String mainstat; //either aim, strength or force

    public Weapon(String subclass) {
        super("",0,0,0);
        this.setPrice(1);
        this.setWeight(1);
        this.setLevel(1);
        
        switch(subclass){
            
            case "BountyHunter":
                this.setName("DX7 Blaster");
                damage=10;
                mainstat="aim";
                break;
                
            case "JediKnight":
                this.setName("Blue Lightsaber");
                damage=15;
                mainstat="force";
                break;
                
            case "JediMaster":
                this.setName("Green Light");
                damage=15;
                mainstat="force";
                break;
            
            case "SithLord":
                this.setName("Red Lightsaber");
                damage=15;
                mainstat="force";
                break;
                
            case "Smuggler":
                this.setName("Dual K44 blasters");
                damage=12;
                mainstat="aim";
                break;
                
            case "Soldier":
                this.setName("Standart Republic Rifle");
                damage=10;
                mainstat="aim";
                break;
                
            
            case "WookieWarrior":
                this.setName("Big Stick");
                damage=7;
                mainstat="strength";
                break;
        }
    }
    
    
    
}
