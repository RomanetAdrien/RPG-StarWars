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
public class Item {
    private String name;
    private int price;
    private int weight;
    private int level;

    public Item(String name, int price, int weight, int level) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.level = level;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    
    
}
