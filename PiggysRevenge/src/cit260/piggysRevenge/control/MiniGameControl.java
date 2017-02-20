/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.control;

import cit260.piggysRevenge.model.MiniGame;
import java.util.Random;

/**
 *
 * @author natebolton
 */
public class MiniGameControl {    
    
    public static void generateComboOrder(MiniGame miniGame) {
        
        String inputComboOrder = miniGame.getComboOrder();
        //idea copied from:  http://stackoverflow.com/questions/20588736/how-can-i-shuffle-the-letters-of-a-word
        Random rand = new Random();
        // Convert string into a simple char array:
        char newCharArray[] = inputComboOrder.toCharArray();

        // Scramble the letters using the standard Fisher-Yates shuffle, 
        for(int i=0; i<newCharArray.length; i++) {
            int j = rand.nextInt(newCharArray.length);
            // Swap letters
            char temp = newCharArray[i];
            newCharArray[i] = newCharArray[j];
            newCharArray[j] = temp;
        }       
        
        miniGame.setComboOrder(new String(newCharArray));
        //return new String(newCharArray);
    }
    
    public static void generateComboOrder(MiniGame miniGame, long randSeed) {
        
        String inputComboOrder = miniGame.getComboOrder();
        //idea copied from:  http://stackoverflow.com/questions/20588736/how-can-i-shuffle-the-letters-of-a-word
        Random rand = new Random(randSeed);
        // Convert string into a simple char array:
        char newCharArray[] = inputComboOrder.toCharArray();

        // Scramble the letters using the standard Fisher-Yates shuffle, 
        for(int i=0; i<newCharArray.length; i++) {
            int j = rand.nextInt(newCharArray.length);
            // Swap letters
            char temp = newCharArray[i];
            newCharArray[i] = newCharArray[j];
            newCharArray[j] = temp;
        }       

        miniGame.setComboOrder(new String(newCharArray));
        //return new String(newCharArray);
    }
    
    public static int checkKeyOrder(String playerOrder, String systemOrder) {
        int playerOrderLen = playerOrder.length();
        int systemOrderLen = systemOrder.length();
        //if empty stings, return -1
        if ( playerOrderLen == 0 || systemOrderLen == 0 ) {
            return -1;
        }
        //if inputs are not the same length, return error code -1
        if ( playerOrderLen != systemOrderLen ) {
            return -2;
        }
        //if both inputs do not contain the same count of each character, return -2
        // for each letter in playerOrder, count the number of occurences in both Strings and compare
        for ( int i=0; i < playerOrderLen; i++ ) {
            int count1 = 0;
            char testChar = playerOrder.charAt(i);
            for ( int j=0; j < playerOrderLen; j++) {
                if (testChar == playerOrder.charAt(j)) {
                    count1++;
                }    
            }
            
            int count2 = 0;
            for ( int j=0; j < systemOrderLen; j++) {
                if (testChar == systemOrder.charAt(j)) {
                    count2++;
                }    
            }            
            
            if (count1 != count2) {
                return -3;
            }
        }
        //if they equal, return playeOrder length
        if (playerOrder.equals(systemOrder)) {
            return playerOrderLen;
        } else {
            //else for each char in playerOrder, if the char at the same index is the same, add to sum
            int sum = 0;
            for ( int i=0; i < playerOrderLen; i++ ) {
                if (playerOrder.charAt(i) == systemOrder.charAt(i)) {
                    sum++;
                }
            }
            return sum;
            
        }
    }
}
