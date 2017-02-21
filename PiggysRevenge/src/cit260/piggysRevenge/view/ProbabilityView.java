/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.MapControl;
import cit260.piggysRevenge.model.Game;
import cit260.piggysRevenge.model.Player;
import java.util.Scanner;
import piggysrevenge.PiggysRevenge;
/**
 *
 * @author natebolton
 */
class ProbabilityView {
    
    private final String probabilityIntro;
    private final String prompt1;
    private final String prompt2;
    private Player tempPlayer;
    private Game tempGame;
    
    public ProbabilityView() {
        this.probabilityIntro = "\n-----------------------------------------------------------------"
                + "\nThe probability you will complete the game in the minimum number of turns is:";
        this.prompt1 = "\nHow many scenes have you visited?";
        this.prompt2 = "\nHow many events have you discovered?";
//        this.prompt1 = "\nHow many bricks will be in your house?";
//        this.prompt2 = "\nHow many turns will have passed when the game ends?";
//        this.prompt3 = "\nWill you have eaten the roast beef?";
//        this.prompt4 = "\nWill you have captured the Wolf?";
        
    }

    void displayProbability() {
        //this.tempPlayer = PiggysRevenge.getPlayer(); These will be needed when this becomes automagic.
        //this.tempGame = PiggysRevenge.getCurrentGame();
        System.out.println(this.probabilityIntro);
        boolean done = false;
        do {
            String userInput1 = this.getInput(this.prompt1);
            String userInput2 = this.getInput(this.prompt2);
           
            done = this.doAction(userInput1, userInput2);
            
        } while (!done); 
    }

    private String getInput(String prompt) {
        // System.out.println("\n*** getMenuOption() function called ***");
        Scanner keyboard = new Scanner(System.in); 
        String value = "";
        boolean valid = false;

        while (!valid) {
            System.out.println(prompt);
            
            value = keyboard.nextLine();
            value = value.trim();

            if (value.length() < 1) {
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nInvalid input. Please re-enter your input."
                        + "\n-----------------------------------------------------------------");
                continue;
            
}
        break;
}
    return value;
    }

    private boolean doAction(String input1, String input2) {
        // System.out.println("\n*** doAction() function called ***");
        input1 = input1.toUpperCase();
        input2 = input2.toUpperCase();
        
        if ("Q".equals(input1) || "Q".equals(input2)) {
            return true;
        } else {
        
            double result = MapControl.calculateEventProbability(Double.parseDouble(input1), 25, Double.parseDouble(input2), 5);
            if (result == -1.0) {
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nYou may have visited between 1 and 25 scenes or 0 and 5 events"
                        + "\n-----------------------------------------------------------------");
            } else if (result == -2.0) {
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nYou can't have more visited scenes than total scenes"
                        + "\n-----------------------------------------------------------------");
            } else if (result == -3.0) {
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nYou can't have more visited events than total events"
                        + "\n-----------------------------------------------------------------");
            } else if (result == -4.0) {
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nYou can't have more than 100 total scenes"
                        + "\n-----------------------------------------------------------------");
            } else if (result == -5.0) {
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nYou can't have more than 5 total events"
                        + "\n-----------------------------------------------------------------");            
            } else if (result == -6.0) {
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nYou can't have less remaining scenes than remaining events"
                        + "\n-----------------------------------------------------------------");            
            } else {
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nYou have a "
                        + String.valueOf(result)
                        + " percent chance of completing the game with the fewest moves possible."
                        + "\n-----------------------------------------------------------------");
                return true;
            }
        
        }
        return false;  
    }
    
}
