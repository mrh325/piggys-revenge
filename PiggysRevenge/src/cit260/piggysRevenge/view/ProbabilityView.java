/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.MapControl;
import cit260.piggysRevenge.model.Game;
import cit260.piggysRevenge.model.Player;
/**
 *
 * @author natebolton
 */
class ProbabilityView extends View {
    
    private Player tempPlayer;
    private Game tempGame;
    
    public ProbabilityView() {
        super("\n-----------------------------------------------------------------"
                + "\nThe probability you will complete the game in the minimum"
                + "\nnumber of turns is...  Please enter the following"
                + "\non one line. Separate each value with a space:"
                + "\n\nHow many scenes have you visited? How many events have you discovered?");
    }

    @Override
    public boolean doAction(String value) {
        // System.out.println("\n*** doAction() function called ***");
        //split whitespace separated values
        String[] parts = value.split("\\s+");
        if (parts.length != 2) {
            System.out.println("\n-----------------------------------------------------------------"
                        + "\nERROR:  You must enter 2 space-separated values"
                        + "\n-----------------------------------------------------------------");
            return false;
        }
        
        String input1 = parts[0].toUpperCase();
        String input2 = parts[1].toUpperCase();
        
        if ("Q".equals(input1) || "Q".equals(input2)) {
            return true;
        }
        double scenesV;
        double eventsV;
        try {
            scenesV = Double.parseDouble(input1);
            eventsV = Double.parseDouble(input2);
        } catch (NumberFormatException e) {
            System.out.println("\n-----------------------------------------------------------------"
                    + "\nERROR:  Scenses vistied and events visited must be numbers"
                    + "\n-----------------------------------------------------------------");
            return false;
        }
        
        double result = MapControl.calculateEventProbability(scenesV, 25, eventsV, 5);
        if (result == -1.0) {
            System.out.println("\n-----------------------------------------------------------------"
                    + "\nERROR:  You may have visited between 1 and 25 scenes or 0 and 5 events"
                    + "\n-----------------------------------------------------------------");
        } else if (result == -2.0) {
            System.out.println("\n-----------------------------------------------------------------"
                    + "\nERROR:  You can't have more visited scenes than total scenes"
                    + "\n-----------------------------------------------------------------");
        } else if (result == -3.0) {
            System.out.println("\n-----------------------------------------------------------------"
                    + "\nERROR:  You can't have more visited events than total events"
                    + "\n-----------------------------------------------------------------");
        } else if (result == -4.0) {
            System.out.println("\n-----------------------------------------------------------------"
                    + "\nERROR:  You can't have more than 100 total scenes"
                    + "\n-----------------------------------------------------------------");
        } else if (result == -5.0) {
            System.out.println("\n-----------------------------------------------------------------"
                    + "\nERROR:  You can't have more than 5 total events"
                    + "\n-----------------------------------------------------------------");            
        } else if (result == -6.0) {
            System.out.println("\n-----------------------------------------------------------------"
                    + "\nERROR:  You can't have less remaining scenes than remaining events"
                    + "\n-----------------------------------------------------------------");            
        } else {
            System.out.println("\n-----------------------------------------------------------------"
                    + "\nYou have a "
                    + String.valueOf(result)
                    + " percent chance of completing the game with the fewest moves possible."
                    + "\n-----------------------------------------------------------------");
            return true;
        }
        
        return false;  
    }
    
}
