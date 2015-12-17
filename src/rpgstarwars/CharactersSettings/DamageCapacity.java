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
public class DamageCapacity extends Capacity{
    private boolean general; //1 if affect all opponents, 0 if single target
    private int damage;

    public DamageCapacity(String name, String type,Boolean general, int damage) {
        super(name, type);
        this.damage=damage;
        this.general=general;
    }

    public boolean isGeneral() {
        return general;
    }
    public void setGeneral(boolean general) {
        this.general = general;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    
}
