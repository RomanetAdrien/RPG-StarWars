/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgstarwars;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import rpgstarwars.CharactersSettings.Character;
import java.util.Set;
import javax.swing.JOptionPane;

//import java.lang.Math.random;

/**
 *
 * @author Malomek
 */
public class Game {
    
    private Set<Event> randomevents;
    private Set<Event> specialevents;
    private List<Event> mainstory;
    private int difficulty;
    private Character hero;
    private Set<Character> companions;

    
    public Game() {
      //  mainstory= initStory();
        this.mainHero();
        this.chooseDifficulty();
        this.companions= new HashSet<>();
        this.mainstory= new ArrayList<>();
        this.randomevents= new HashSet<>();
        companions.add(hero);
        this.specialevents= new HashSet<>();
        
        
    }
    
    public static void run(){
        Game game = new Game();

        
        
    }
    
    public void triggerRandomevent(){
        Event event = Event.initRandomEvent(companions);
        startEvent(event);
        
    }
    
    public void startEvent(Event event){
        event.getCombat().combatRun();
    }
    
    public void chooseDifficulty(){
        String Text = "How tough should the galaxy be ?\n";
        String playerinput = "";
        Text+="1: Baby Monkeylizard\n";
        Text+="2: Stormtrooper\n";
        Text+="3: Ancient Rakata God of destruction";
        int choice=0;
        do
        {
            playerinput = JOptionPane.showInputDialog(Text);
            if(isInteger(playerinput)){
            choice = Integer.parseInt(playerinput);                
            }
        }while((!isInteger(playerinput)) || (choice!=1 && choice!=2 && choice!=3));
          this.difficulty=choice;  
    }
    
    public void mainHero(){
        String Text ="Greetings hero, what is your name ?";
        String playerinput = "";
        String charactername = JOptionPane.showInputDialog(Text);
        Text="I can tell you know some things about fighting, what kind of warrior are you exactly ?\n";
        String[] propositions = Character.availableclasses.split("&&");
        for(int i=0;i<propositions.length;i++){
            Text+=Integer.toString(i+1)+": "+propositions[i]+"\n";
        }
        int choice=0;
        do
        {
            playerinput = JOptionPane.showInputDialog(Text);
            if(isInteger(playerinput)){
            choice = Integer.parseInt(playerinput);                
            }
        }while((!isInteger(playerinput)) || choice<1 || choice>propositions.length);
        String characterclass=propositions[choice-1];
        this.hero = new Character(charactername, characterclass);
    }
    
    public static int dice(int faces){ //roll a dice with the given a number of faces
       int random = (int) (Math.random()*faces) + 1;
       return random;
    }
    
    public static boolean isInteger(String s) {
    try { 
        Integer.parseInt(s); 
    } catch(NumberFormatException e) { 
        return false; 
    } catch(NullPointerException e) {
        return false;
    }
    // only got here if we didn't return false
    return true;
}
    
}
