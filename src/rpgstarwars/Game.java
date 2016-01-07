/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgstarwars;

import java.util.List;
import rpgstarwars.CharactersSettings.Character;
import java.util.Set;
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
    }
    
    
    
    public static int dice(int faces){ //roll a dice with the given a number of faces
       int random = (int) (Math.random()*faces) + 1;
       return random;
    }
    
}
