/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgstarwars;

import java.util.ArrayList;
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
    public Set<Monster> ennemies;
    private Set<Item> drop;
    private int dialoguesnumber;
    private int characterintervention;
    private List<String> dialogue;
    public Combat combat;
    private int combatnumber;
    public int instance;//counter that tells us wich dialogue/combat/decision we do now
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
        this.dialogue = new ArrayList<>();
        this.combat = null;
        this.combatnumber = 1;
        this.instance = 0;
        this.place = "";
    }
    
    
    public static Event initRandomEvent(Set<rpgstarwars.CharactersSettings.Character> heroes){
         Event newevent = new Event();
         int alea = Game.dice(1);
         switch(alea){
            
            case 1 ://Event 1
        newevent.type=2;
        newevent.ennemies.add(Monster.securityDroid());
        newevent.ennemies.add(Monster.securityDroid());
        newevent.ennemies.add(Monster.securityDroid());
        newevent.ennemies.add(Monster.securityDroid());
        newevent.combat=new Combat(heroes,newevent.ennemies);
        newevent.place="Coruscant";
        newevent.characterintervention=1;
                break;
                
         }
        
        
        
        
      return newevent;  
    }
    

    public static List<Event> initStory(Set<rpgstarwars.CharactersSettings.Character> heroes){
        Event event1,event2,event3,event4,event5;
        List<Event> story = new ArrayList<>();
        int storytype=0;
        
        //Event1
        event1=new Event();
        event1.dialoguesnumber=1;
        event1.type=storytype;
        event1.combatnumber=0;
        event1.dialogue.add("Oh no ! A really bad guy, so bad even the sith want him stoppes, is trying to take over the galaxy !\n I have to do something ! It is said he hides on Malachor5, That is where i'm going !");
        event1.place="Coruscant";
        
        //Event2
        event2=new Event();
        event2.type=storytype;
        event2.combatnumber=0;
        event2.dialoguesnumber=1;
        event2.dialogue.add("Pfiou, this fight is over, let's go to Malachor5\n *Travel to Malachor5");
        event2.place="Coruscant";
        
        //Event3
        event3=new Event();
        event3.type=storytype;
        event3.combatnumber=1;
        event3.dialoguesnumber=1;
        event3.dialogue.add("There he is ! Brace yourselves companions ! May the force be with us !");
        event3.place="Malachor5";
        event3.ennemies.add(Monster.darkLordCthulu());
        event3.combat = new Combat(heroes,event3.ennemies);
        
        
        //Event4
        event4=new Event();
        event4.type=storytype;
        event4.combatnumber=0;
        event4.dialoguesnumber=1;
        event4.dialogue.add("We did it, we did it we dit yeah ! Yes we did it...");
        event4.place="Malachor5";
        
        story.add(event1);
        story.add(event2);
        story.add(event3);
        story.add(event4);
        return story;
        
    }
  

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
