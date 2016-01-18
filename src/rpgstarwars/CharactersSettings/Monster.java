/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgstarwars.CharactersSettings;

/**
 *
 * @author Malomek
 */
public class Monster {
    private String name;
    private int maindamage;
    private Stats stats;
    private Status status;
    private int health;

    public Monster(String name, int maindamage, Stats stats) {
        this.name = name;
        this.maindamage = maindamage;
        this.stats = stats;
        this.status= new Status();
        health=this.stats.getMaxhp();
    }
    
        public static Monster cleaningDroid(){
        Monster newmonster = new Monster("CleaningDroid",1,Stats.monsterStats("CleaningDroid"));
        return newmonster;
    }
       public static Monster securityDroid(){
        Monster newmonster = new Monster("SecurityDroid",1,Stats.monsterStats("SecurityDroid"));
        return newmonster;
    }
    
    public String play(){
        return "monsterplay&&monsterplay&&monsterplay&&monsterplay";
        
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
    
    public void iscontrolled(int amount){
        this.status.statusAffected(2, amount, 0);
    }
    
    public boolean isAlive(){
        if(this.health>0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static Monster emptyMonster(){
        Monster monster = null;
        return monster;
    }
    


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMaindamage() {
        return maindamage;
    }
    public void setMaindamage(int maindamage) {
        this.maindamage = maindamage;
    }
    public Stats getStats() {
        return stats;
    }
    public void setStats(Stats stats) {
        this.stats = stats;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    
    
}
