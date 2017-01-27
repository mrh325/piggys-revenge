/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piggysrevenge;

import cit260.piggysRevenge.model.Backpack;
import cit260.piggysRevenge.model.Player;
import cit260.piggysRevenge.model.Item;
import cit260.piggysRevenge.model.Hat;
/**
 *
 * @author hales
 */
public class PiggysRevenge {

    public static void teamAssignment() {
        Player playerOne = new Player();
        
        playerOne.setName("Bob");
        playerOne.setDistanceToWolf(2);
        playerOne.setDistanceToPantry(3);
        playerOne.setDistanceToNearestKey(5);
        playerOne.setHasEaten(true);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
    }
    
    public static void nateBoltonAssignment() {
        Backpack myBackpack = new Backpack();
        
        myBackpack.setName("Green Backpack");
        myBackpack.setItemList("Hat1, Hat2, Shoes1");
        
        System.out.println(myBackpack.toString());
        
        Item myItem = new Item();
        
        myItem.setName("key1");
        myItem.setDescription("This is the first of four keys required to unlock the pantry.");
        myItem.setItemType("key");
        myItem.setMovementBonus(0);
        
        System.out.println(myItem.toString());
        
        Hat myHat = new Hat();
        
        myHat.setTargetScene("Empty Scene");
        
        System.out.println(myHat.toString());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        teamAssignment();
        nateBoltonAssignment();
        
    }
    
}
