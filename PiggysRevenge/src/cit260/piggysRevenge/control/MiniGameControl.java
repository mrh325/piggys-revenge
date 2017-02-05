/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.control;

import java.util.Random;

/**
 *
 * @author natebolton
 */
public class MiniGameControl {
/**    
    
def checkKeyOrder(playerOrder, keyOrder):
    #if they aren't the same length...
    if len(playerOrder) != len(keyOrder):
        return -1
    #check to be sure they both contain the same number of each character
    for i in range(len(playerOrder)):
        if playerOrder.count(playerOrder[i]) != keyOrder.count(playerOrder[i]):
            return -2
    #if they're the same...
    if playerOrder == keyOrder:
        #return the length of the string
        return len(playerOrder)
    else:
        #count how many are in the correct position by comparing each index of each string to each other and return the count
        tempSum = 0
        for i in range(len(playerOrder)):
            if playerOrder[i] == keyOrder[i]:
                tempSum += 1
        return tempSum
**/
    
    
    
    public String generateComboOrder(String inputKeyOrder) {
        
        //idea copied from:  http://stackoverflow.com/questions/20588736/how-can-i-shuffle-the-letters-of-a-word
        Random rand = new Random();
        // Convert string into a simple char array:
        char newCharArray[] = inputKeyOrder.toCharArray();

        // Scramble the letters using the standard Fisher-Yates shuffle, 
        for(int i=0; i<newCharArray.length; i++) {
            int j = rand.nextInt(newCharArray.length);
            // Swap letters
            char temp = newCharArray[i];
            newCharArray[i] = newCharArray[j];
            newCharArray[j] = temp;
        }       

        return new String(newCharArray);
    }
    
    public String generateComboOrder(String inputKeyOrder, long randSeed) {
        
        //idea copied from:  http://stackoverflow.com/questions/20588736/how-can-i-shuffle-the-letters-of-a-word
        Random rand = new Random(randSeed);
        // Convert string into a simple char array:
        char newCharArray[] = inputKeyOrder.toCharArray();

        // Scramble the letters using the standard Fisher-Yates shuffle, 
        for(int i=0; i<newCharArray.length; i++) {
            int j = rand.nextInt(newCharArray.length);
            // Swap letters
            char temp = newCharArray[i];
            newCharArray[i] = newCharArray[j];
            newCharArray[j] = temp;
        }       

        return new String(newCharArray);
    }
    
    public int checkKeyOrder(String playerOrder, String systemOrder) {
        int playerOrderLen = playerOrder.length();
        int systemOrderLen = systemOrder.length();
        //if inputs are not the same length, return error code -1
        if ( playerOrderLen != systemOrderLen ) {
            return -1;
        }
        //if both inputs do not contain the same count of each character, return -2
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
                return -2;
            }
        }
        
        return 0;
    }
}
