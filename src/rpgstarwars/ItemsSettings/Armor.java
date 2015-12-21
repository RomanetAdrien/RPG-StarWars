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
public class Armor extends Item{
    
    private int defense;
    private int requirement; //minimum strength required

    public Armor(String subclass) {
        super("",0,0,0);
        this.setPrice(1);
        this.setWeight(1);
        this.setLevel(1);
        requirement=1;
        switch(subclass){
            
            case "BountyHunter":
                this.setName("Mercenary Clothes");
                defense=1;
                break;
                
            case "JediKnight":
                this.setName("Jedi Robes");
                defense=0;
                break;
                
            case "JediMaster":
                this.setName("Jedi Robes");
                defense=0;
                break;
            
            case "SithLord":
                this.setName("Black Robes");
                defense=0;
                break;
                
            case "Smuggler":
                this.setName("Cool Jacket");
                defense=0;
                break;
                
            case "Soldier":
                this.setName("Standart Republic Uniform");
                defense=2;
                break;
            
            case "WookieWarrior":
                this.setName("Big Furr");
                defense=1;
                break;
        }
    }

    
    
    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public int getRequirement() {
        return requirement;
    }
    public void setRequirement(int requirement) {
        this.requirement = requirement;
    }
    
    
    
}
