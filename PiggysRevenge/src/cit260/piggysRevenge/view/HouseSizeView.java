/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.GameControl;
import cit260.piggysRevenge.exceptions.GameControlException;

/**
 *
 * @author hales
 */
class HouseSizeView extends View {

    private String promptIntro;

    public HouseSizeView() {
        super("\n"
                + "\n============================="
                + "\n| House Size View            |"
                + "\n============================="
                + "\n"
                + "\nPlease enter the length, width, height, and number of "
                + "\nstories of the house you would like to build (Enter all"
                + "\nvalues on one line separated by spaces):");

    }

//    void displayHouse() {
//        System.out.println(this.promptIntro);
//        boolean done = false;
//        do {
//            String userInput1 = this.getInput("Enter the length of the house (between 5 and 20)");
//            String userInput2 = this.getInput("Enter the width of the house (between 5 and 20)");
//            String userInput3 = this.getInput("Enter the height of the house (between 6 and 10)");
//            String userInput4 = this.getInput("Enter the number of stories of the house (between 1 and 3)");
//           
//            done = this.doAction(userInput1, userInput2, userInput3, userInput4);
//            
//        } while (!done); 
//    }
    @Override
    public boolean doAction(String value) {
        // System.out.println("\n*** doAction() function called ***");
        String[] parts = value.split("\\s+");

        if (parts.length != 4) {
            System.out.println("Please enter exactly 4 integers.");
            return false;
        }

        String input1 = parts[0].toUpperCase();
        String input2 = parts[1].toUpperCase();
        String input3 = parts[2].toUpperCase();
        String input4 = parts[3].toUpperCase();

        if ("Q".equals(input1) || "Q".equals(input2) || "Q".equals(input3) || "Q".equals(input4)) {
            return true;

        }
        int num1, num2, num3, num4 = 0;

        try {
            num1 = Integer.parseInt(input1);
            num2 = Integer.parseInt(input2);
            num3 = Integer.parseInt(input3);
            num4 = Integer.parseInt(input4);
            // is an integer!
        } catch (NumberFormatException e) {
            System.out.println("\nYou did not enter an integer, please try again.");
            return false;
        }

        int result;
        try {
            result = GameControl.calcNumberOfBricks(num1, num2, num3, num4);
            System.out.println("\nYou will need " + result + " bricks to build a house with the parameters given.");
            return true;
        } catch (GameControlException ex) {
            System.out.println(ex.getMessage());

        }
//        switch (result) {
//            case -11:
//                System.out.println("\n-----------------------------------------------------------------"
//                        + "\nLength is too small."
//                        + "\n-----------------------------------------------------------------");
//                break;
//            case -12:
//                System.out.println("\n-----------------------------------------------------------------"
//                        + "\nLength is too large."
//                        + "\n-----------------------------------------------------------------");
//                break;
//            case -21:
//                System.out.println("\n-----------------------------------------------------------------"
//                        + "\nWidth is too small."
//                        + "\n-----------------------------------------------------------------");
//                break;
//            case -22:
//                System.out.println("\n-----------------------------------------------------------------"
//                        + "\nWidth is too large."
//                        + "\n-----------------------------------------------------------------");
//                break;
//            case -31:
//                System.out.println("\n-----------------------------------------------------------------"
//                        + "\nHeight is too small."
//                        + "\n-----------------------------------------------------------------");
//                break;
//            case -32:
//                System.out.println("\n-----------------------------------------------------------------"
//                        + "\nHeight is too large."
//                        + "\n-----------------------------------------------------------------");
//                break;
//            case -41:
//                System.out.println("\n-----------------------------------------------------------------"
//                        + "\nNumber of stories is too small."
//                        + "\n-----------------------------------------------------------------");
//                break;
//            case -42:
//                System.out.println("\n-----------------------------------------------------------------"
//                        + "\nNumber of stories is too large."
//                        + "\n-----------------------------------------------------------------");
//                break;
//            default:
//                System.out.println("\n-----------------------------------------------------------------"
//                        + "\nYou will need to collect  "
//                        + String.valueOf(result)
//                        + " bricks."
//                                + "\n-----------------------------------------------------------------");
//                return true;
//        }
        return false;
    }

}
