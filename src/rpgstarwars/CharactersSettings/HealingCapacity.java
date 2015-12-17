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
public class HealingCapacity extends Capacity{
    
    private boolean general; //1 if heal affect whole team,0 if single target
    private int amount;

    public HealingCapacity(String name, String type, Boolean general, int amount) {
        super(name, type);
        this.general=general;
        this.amount=amount;
    }
    
    public boolean isGeneral() {
        return general;
    }
    public void setGeneral(boolean general) {
        this.general = general;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
