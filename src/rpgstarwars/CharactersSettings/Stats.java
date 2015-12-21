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
public class Stats {
    //main stats
    private int maxhp;
    private int maxforce;
    private int speed;
    private int room;
    
    //offensive stats
    private int strength;
    private int aim;
    private int force;
    
    //defensive stats
    private int dodge;
    private int block;

    public Stats(String subclass) {
        
        switch(subclass){
            
            case "BountyHunter" :
                maxhp=50;
                maxforce=1;
                speed=10;
                room=20;
                strength=40;
                aim=40;
                force=1;
                dodge=20;
                block=40;
                break;
            
            case "JediKnight" :
                maxhp=40;
                maxforce=40;
                speed=40;
                room=20;
                strength=20;
                aim=20;
                force=40;
                dodge=20;
                block=30;
                break;
                
            case "JediMaster" :
                maxhp=30;
                maxforce=60;
                speed=30;
                room=20;
                strength=10;
                aim=10;
                force=60;
                dodge=50;
                block=20;
                break;
            
            case "SithLord" :
                maxhp=50;
                maxforce=30;
                speed=30;
                room=20;
                strength=40;
                aim=20;
                force=30;
                dodge=10;
                block=50;
                break;
            
            case "Smuggler" :
                maxhp=30;
                maxforce=1;
                speed=50;
                room=20;
                strength=20;
                aim=50;
                force=1;
                dodge=30;
                block=10;
                break;
                
            case "Soldier" :
                maxhp=50;
                maxforce=1;
                speed=30;
                room=20;
                strength=50;
                aim=40;
                force=1;
                dodge=10;
                block=20;
                break;
                
            case "WookieWarrior" :
                maxhp=60;
                maxforce=1;
                speed=10;
                room=20;
                strength=70;
                aim=20;
                force=1;
                dodge=10;
                block=20;
                break;
                
        }
        
        
    }

    
    
    public int getMaxhp() {
        return maxhp;
    }
    public void setMaxhp(int maxhp) {
        this.maxhp = maxhp;
    }
    public int getMaxforce() {
        return maxforce;
    }
    public void setMaxforce(int maxforce) {
        this.maxforce = maxforce;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getRoom() {
        return room;
    }
    public void setRoom(int room) {
        this.room = room;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getAim() {
        return aim;
    }
    public void setAim(int aim) {
        this.aim = aim;
    }
    public int getForce() {
        return force;
    }
    public void setForce(int force) {
        this.force = force;
    }
    public int getDodge() {
        return dodge;
    }
    public void setDodge(int dodge) {
        this.dodge = dodge;
    }
    public int getBlock() {
        return block;
    }
    public void setBlock(int block) {
        this.block = block;
    }
 
    
    
}
