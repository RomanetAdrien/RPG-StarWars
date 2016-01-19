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


/**
 *
 * @author Malomek
 */
public class Game {
    
    public Set<Event> randomevents;
    public Set<Event> specialevents;
    public List<Event> mainstory;
    public int difficulty;
    public Character hero;
    public Set<Character> companions;

    
    public Game() {
      //  mainstory= initStory();
        this.mainHero();
        this.chooseDifficulty();
        this.companions= new HashSet<>();
        this.mainstory= new ArrayList<>();
        this.randomevents= new HashSet<>();
        companions.add(hero);
        this.specialevents= new HashSet<>();
        this.mainstory= Event.initStory(companions);
        
    }
    
    public void storyUpdate(){
        this.mainstory= Event.initStory(companions);
    }
    
    public static void introTheme(){
        String intro = "A long time ago in a galaxy far far away...";
        String Text = "STAR WARS\n";
        Text+="daaaaaadadadadadadadadada\n";
        Text+="dadadaaaadaaadadadadadad...\n\n";
        
        JOptionPane.showMessageDialog(null, intro);
        JOptionPane.showMessageDialog(null, Text);
        
    }
    
    public static void run(){
        Game.introTheme();
        int storycount=0;
        int eventclock=0;
        Game game = new Game();
        while(storycount<game.mainstory.size()){
            game.storyUpdate();
            if(eventclock==0){
                game.newCompanion();
            }
            if(eventclock==1){
                game.triggerRandomevent();  
            }
            if(eventclock==5){
                eventclock=0;  
            }
        
           game.triggerStory(storycount);
           storycount++;
           eventclock++;
        }
        String credits = "Thanks for playing !\nStory by Adrien ROMANET\nGraphics by Adrien ROMANET\nGame Design by Adrien ROMANET\nTeam director : Adrien ROMANET\nSpecial Thanks to Adrien ROMANET";
        JOptionPane.showMessageDialog(null, credits);
        System.exit(0);

    }
    
    public void triggerSpecialevent(){
        Event event = specialevents.iterator().next();
        startEvent(event);
        
    }
    
    public void triggerRandomevent(){
        Event event = Event.initRandomEvent(companions);
        startEvent(event);
        
    }
    
    public void triggerStory(int i){
        Event event = mainstory.get(i);
        startEvent(event);
        
    }
    
    public void newCompanion(){
        String Text="Hello warrior I have heard about you and wish to join you in your quest\nMy name is :";
        String newname = JOptionPane.showInputDialog(Text); 
        String[] propositions = Character.availableclasses.split("&&");
        String newclass = propositions[Game.dice(propositions.length)-1];
        
        Character newcompanion = new Character(newname,newclass);
        Text="I am a level "+this.hero.getLevel()+" "+newclass+" and I am honored to be your companion.\n To infiny and beyond !";
        JOptionPane.showMessageDialog(null, Text);
        this.companions.add(newcompanion);
    }
    
    public void startEvent(Event event){
        if(event.getDialoguesnumber()==0){
            event.getCombat().combatRun();
        }
        else{
            String Text="";
            String playeranswer="";
            for(String dialogue :event.getDialogue()){
                Text+=dialogue+"\n";
                playeranswer = JOptionPane.showInputDialog(Text); 
            }
            if(event.getCombatnumber()!=0){
            event.getCombat().combatRun();                
            }

        }
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
