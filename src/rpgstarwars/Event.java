/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgstarwars;

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
   
}
