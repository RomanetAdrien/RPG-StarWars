/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgstarwars;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rpgstarwars.CharactersSettings.Monster;
import rpgstarwars.ItemsSettings.Item;

/**
 *
 * @author Malomek
 */
public class Event {
    private int type;//0:main story 1:LegendaryBattle 2:random battle 3:Legendary drop  4:random drop 5:Decision
    private Set<Monster> ennemies;
    private Set<Item> drop;
    private int dialoguesnumber;
    private int characterintervention;
    private List<String> dialogue;
    private Combat combat;
    private int combatnumber;
    private int instance;//counter that tells us wich dialogue/combat/decision we do now
    private String place;

    public Event(int type, Set<Monster> ennemies, Set<Item> drop, int dialoguesnumber, int characterintervention, List<String> dialogue, Combat combat, int combatnumber, int instance, String place) {
        this.type = type;
        this.ennemies = ennemies;
        this.drop = drop;
        this.dialoguesnumber = dialoguesnumber;
        this.characterintervention = characterintervention;
        this.dialogue = dialogue;
        this.combat = combat;
        this.combatnumber = combatnumber;
        this.instance = instance;
        this.place = place;
    }
    
    public Event() {
        this.type = 0;
        this.ennemies = new HashSet<>();
        this.drop = null;
        this.dialoguesnumber = 0;
        this.characterintervention = 0;
        this.dialogue = null;
        this.combat = null;
        this.combatnumber = 1;
        this.instance = 0;
        this.place = "";
    }
    
    
    public static Set<Event> initRandomEvents(Set<rpgstarwars.CharactersSettings.Character> heroes){
        Set<Event> randomevents= new HashSet<>();
         Event newevent = new Event();
         
        //Event 1
        newevent.type=2;
        newevent.ennemies.add(Monster.securityDroid());
        newevent.ennemies.add(Monster.securityDroid());
        newevent.ennemies.add(Monster.securityDroid());
        newevent.ennemies.add(Monster.securityDroid());
        newevent.combat=new Combat(heroes,newevent.ennemies);
        newevent.place="Coruscant";
        newevent.characterintervention=1;
        randomevents.add(newevent);
        
        
      return randomevents;  
    }
/*
    public List<Event> initStory(){
        Event event1,event2,event3,event4,event5;
        int storytype=0;
            
    }
  */ 

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public Set<Monster> getEnnemies() {
        return ennemies;
    }
    public void setEnnemies(Set<Monster> ennemies) {
        this.ennemies = ennemies;
    }
    public Set<Item> getDrop() {
        return drop;
    }
    public void setDrop(Set<Item> drop) {
        this.drop = drop;
    }
    public int getDialoguesnumber() {
        return dialoguesnumber;
    }
    public void setDialoguesnumber(int dialoguesnumber) {
        this.dialoguesnumber = dialoguesnumber;
    }
    public int getCharacterintervention() {
        return characterintervention;
    }
    public void setCharacterintervention(int characterintervention) {
        this.characterintervention = characterintervention;
    }
    public List<String> getDialogue() {
        return dialogue;
    }
    public void setDialogue(List<String> dialogue) {
        this.dialogue = dialogue;
    }
    public Combat getCombat() {
        return combat;
    }
    public void setCombat(Combat combat) {
        this.combat = combat;
    }
    public int getCombatnumber() {
        return combatnumber;
    }
    public void setCombatnumber(int combatnumber) {
        this.combatnumber = combatnumber;
    }
    public int getInstance() {
        return instance;
    }
    public void setInstance(int instance) {
        this.instance = instance;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    
    
    
}
