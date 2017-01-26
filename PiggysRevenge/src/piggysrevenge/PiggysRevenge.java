/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piggysrevenge;

import cit260.piggysRevenge.model.Player;

/**
 *
 * @author hales
 */
public class PiggysRevenge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        
        playerOne.setName("Bob");
        playerOne.setDistanceToWolf(2);
        playerOne.setDistanceToPantry(3);
        playerOne.setDistanceToNearestKey(5);
        playerOne.setHasEaten(true);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
        
    }
    
}
