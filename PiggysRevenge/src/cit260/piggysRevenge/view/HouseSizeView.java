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
 * @author hales
 */
class HouseSizeView {

    private String promptIntro;
    
    public HouseSizeView() {
        this.promptIntro = "\n"
                + "\n============================="
                + "\n| House Size View            |"
                + "\n=============================";
                
    }
    void displayHouse() {
        System.out.println(this.promptIntro);
        boolean done = false;
        do {
            String userInput1 = this.getInput("Enter the length of the house (between 5 and 20)");
            String userInput2 = this.getInput("Enter the width of the house (between 5 and 20)");
            String userInput3 = this.getInput("Enter the height of the house (between 6 and 10)");
            String userInput4 = this.getInput("Enter the number of stories of the house (between 1 and 3)");
           
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
//            try{
//                int num = Integer.parseInt(value);
//                // is an integer!
//}               catch (NumberFormatException e) {
//                // not an integer! }

                continue;
            
}
        break;
}
    return value;
    }
        
 private boolean doAction(String input1, String input2, String input3, String input4) {
        // System.out.println("\n*** doAction() function called ***");

        input1 = input1.toUpperCase();
        input2 = input2.toUpperCase();
        input3 = input3.toUpperCase();
        input4 = input4.toUpperCase();

        if ("Q".equals(input1) || "Q".equals(input2) || "Q".equals(input3) || "Q".equals(input4)) {
            return true;
        
        
    }
    int result = GameControl.calcNumberOfBricks(Integer.parseInt(input1), Integer.parseInt(input2), Integer.parseInt(input3), Integer.parseInt(input4));
        switch (result) {
            case -11:
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nLength is too small."
                        + "\n-----------------------------------------------------------------");
                break;
            case -12:
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nLength is too large."
                        + "\n-----------------------------------------------------------------");
                break;
            case -21:
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nWidth is too small."
                        + "\n-----------------------------------------------------------------");
                break;
            case -22:
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nWidth is too large."
                        + "\n-----------------------------------------------------------------");
                break;
            case -31:
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nHeight is too small."
                        + "\n-----------------------------------------------------------------");
                break;
            case -32:
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nHeight is too large."
                        + "\n-----------------------------------------------------------------");
                break;
            case -41:
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nNumber of stories is too small."
                        + "\n-----------------------------------------------------------------");
                break;
            case -42:
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nNumber of stories is too large."
                        + "\n-----------------------------------------------------------------");
                break;
            default:
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nYou will need to collect  "
                        + String.valueOf(result)
                        + " bricks."
                                + "\n-----------------------------------------------------------------");
                return true;
        }
return false;
 }
}