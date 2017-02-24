/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.GameControl;
import java.util.Scanner;

/**
 *
 * @author natebolton
 */
class ScoreView {

    private final String prompt1;
    private final String prompt2;
    private final String prompt3;
    private final String prompt4;
    private final String scoreIntro;

    public ScoreView() {
        this.scoreIntro = "\n-----------------------------------------------------------------"
                + "\nGenerating your possible score..."
                + "\n-----------------------------------------------------------------";
        this.prompt1 = "\nHow many bricks will be in your house?";
        this.prompt2 = "\nHow many turns will have passed when the game ends?";
        this.prompt3 = "\nWill you have eaten the roast beef? (Y or N)";
        this.prompt4 = "\nWill you have captured the Wolf? (Y or N)";
    }

    void displayScore() {
        System.out.println(this.scoreIntro);
        boolean done = false;
        do {
            String userInput1 = this.getInput(this.prompt1);
            String userInput2 = this.getInput(this.prompt2);
            String userInput3 = this.getInput(this.prompt3);
            String userInput4 = this.getInput(this.prompt4);
           
            done = this.doAction(userInput1, userInput2, userInput3, userInput4);
            
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

    private boolean doAction(String input1, String input2, String input3, String input4) {
        // System.out.println("\n*** doAction() function called ***");
        boolean hasEaten;
        boolean wolfKilled;

        input1 = input1.toUpperCase();
        input2 = input2.toUpperCase();
        input3 = input3.toUpperCase();
        input4 = input4.toUpperCase();

        
        if ("Q".equals(input1) || "Q".equals(input2) || "Q".equals(input3) || "Q".equals(input4)) {
            return true;
        }
        int bricks;
        int turns;
        try {
            bricks = Integer.parseInt(input1);
            turns = Integer.parseInt(input2);
        } catch (NumberFormatException e) {
            System.out.println("\n-----------------------------------------------------------------"
                        + "\nERROR:  Number of Bricks and Turns must be whole numbers"
                        + "\n-----------------------------------------------------------------");
            return false;
        }
        if (!("Y".equals(input3) || "N".equals(input3))) {
            System.out.println("\n-----------------------------------------------------------------"
                    + "\nERROR: You must enter Y or N for the Has Eaten question"
                    + "\n-----------------------------------------------------------------");
            return false;
        } else if (!("Y".equals(input4) || "N".equals(input4))) {
            System.out.println("\n-----------------------------------------------------------------"
                    + "\nERROR: You must enter Y or N for the Wolf Killed question"
                    + "\n-----------------------------------------------------------------");
            return false;
        } else {
            if (null == input3) {
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nERROR: Null Error"
                        + "\n-----------------------------------------------------------------");                
                return false;
            } else switch (input3) {
                case "Y":
                    hasEaten = true;
                    break;
                case "N":
                    hasEaten = false;
                    break;
                default:
                    System.out.println("\n-----------------------------------------------------------------"
                            + "\nERROR: Unkown Error"
                            + "\n-----------------------------------------------------------------");
                    return false;
            }
            if (null == input4) {
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nERROR: Null Error"
                        + "\n-----------------------------------------------------------------");                
                return false;
            } else switch (input4) {
                case "Y":
                    wolfKilled = true;
                    break;
                case "N":
                    wolfKilled = false;
                    break;
                default:
                    System.out.println("\n-----------------------------------------------------------------"
                            + "\nERROR: Unkown Error"
                            + "\n-----------------------------------------------------------------");
                    return false;
            }
            
            int result = GameControl.calcScore(bricks, turns, hasEaten, wolfKilled);
            if (result == -1) {
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nERROR: You may not have less than 0 bricks"
                        + "\n-----------------------------------------------------------------");
            } else if (result == -2) {
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nERROR: Turns can not be less than 1"
                        + "\n-----------------------------------------------------------------");
            } else if (result == -3) {
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nERROR: The wolf can't be killed if the player has not eaten"
                        + "\n-----------------------------------------------------------------");
            } else {
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nWith answers like those, Your score would be "
                        + String.valueOf(result)
                        + "."
                                + "\n-----------------------------------------------------------------");
                return true;
            }
        }
        return false;  
    }
    
}
