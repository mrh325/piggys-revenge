/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.MapControl;
import java.util.Scanner;

/**
 *
 * @author natebolton
 */
class DistanceView {

    private final String introPrompt;
    private final String prompt1;

    public DistanceView() {
        this.introPrompt = "\n-----------------------------------------------------------------"
                + "\nCalculating a distance...(proof of concept only)"
                + "\n-----------------------------------------------------------------";
        this.prompt1 = "\nPlease enter the Point 1 X and Y and Point 2 X and Y"
                + "\nusing the following format: 1 1 5 5"
                + "\nCooridnate values must be between 1 and 5 inclusive"
                + "\nand numbers must be separated by spaces.";
    }

    
    
    void displayDistance() {
        System.out.println("\n*** displayDistance() function called ***");
                System.out.println(this.introPrompt);
        boolean done = false;
        do {
            String userInput = this.getInput(this.prompt1);
           
            done = this.doAction(userInput);
            
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

    private boolean doAction(String input1) {
        // System.out.println("\n*** doAction() function called ***");
        input1 = input1.toUpperCase();

        
        if ("Q".equals(input1)) {
            return true;
        } else {
            int count = 0;
            //let's check to make sure there are 4 digits.
            for (int i = 0, len = input1.length(); i < len; i++) {
                if (Character.isDigit(input1.charAt(i))) {
                    count++;
                }
            }
            if (count != 4) {
                System.out.println("\nPlease enter exactly 4 single digits separated by spaces.");
                return false;
            }
            
            count = 0;
            int cList[] = new int[4];
            Scanner scanner = new Scanner(input1);
            while (scanner.hasNextInt()) {
                cList[count] = scanner.nextInt();

                //break after 4 ints
                if (count == 3) {
                    break;
                }
                    
                count++;
            }
            if (count != 3) {
                System.out.println("\nUnknown Error.  Please enter exactly 4 single digits separated by spaces.");
                return false;
            }
            
            
            double result = MapControl.calcDistance(cList[0], cList[1], cList[2], cList[3]);
            if (result == -1.0) {
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nA coordinate may not be less than 1 (and no letters please)"
                        + "\n-----------------------------------------------------------------");
            } else if (result == -2.0) {
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nA coordinate may not be more than 5"
                        + "\n-----------------------------------------------------------------");
            } else {
                result *= 100.0;
                result = Math.round(result);
                result /= 100.0;
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nThe distance between ("
                        + String.valueOf(cList[0])
                        + ","
                        + String.valueOf(cList[1])
                        + "),("
                        + String.valueOf(cList[2])
                        + ","
                        + String.valueOf(cList[3])
                        + ") is:  "
                        + String.valueOf(result)
                        + "\n-----------------------------------------------------------------");
                return true;
            }
        }
        return false;  
    }
    
}
