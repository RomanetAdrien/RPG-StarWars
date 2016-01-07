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
public class Status {
    private int type; //0:normal 1:continue damage 2:paralyzed
    private int length;
    private int remaining;
    private int damage;
    
    public Status() {
        type=0;
        length=0;
        remaining=0;
    }
    
    public void nextTurn(){
        if(this.type==0){
            return;
        }
        this.remaining-=1;
        if(this.remaining==0){
            this.statusReset();
        }
    }
    
    public boolean isAffected(){
        if(this.type!=0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void statusReset(){
        this.type=0;
        this.length=0;
        this.remaining=0;
        this.damage=0;
    }
    
    public void statusAffected(int type, int length,int damage){
        this.type=type;
        this.length=length;
        this.remaining=remaining;
        this.damage=0;
    }
    
    public boolean canMove(){
        if(this.type==2){
            return false;
        }
        else{
            return true;
        }
    }
    
    public void getAffected(int type, int length){
        this.setType(type);
        this.setLength(length);
        this.setRemaining(length);
        this.setDamage(0);
    }
    public void getAffected(int type, int length, int damage){
        this.setType(type);
        this.setLength(length);
        this.setRemaining(length);
        this.setDamage(damage);
    }

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public int getRemaining() {
        return remaining;
    }
    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    

}
