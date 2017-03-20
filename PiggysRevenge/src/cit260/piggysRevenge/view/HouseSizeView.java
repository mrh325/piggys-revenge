/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.GameControl;
import cit260.piggysRevenge.exceptions.GameControlException;
import cit260.piggysRevenge.model.House;
import java.util.logging.Level;
import java.util.logging.Logger;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author hales
 */
class HouseSizeView extends View {

    public HouseSizeView() {
        super("\n"
                + "\n============================="
                + "\n| Choose Your House Size    |"
                + "\n============================="
                + "\n\nBefore we begin, you must choose the size of the house you"
                + "\nwish to build.  A bigger house will require you to collect"
                + "\nmore bricks, but will result in a higher score."
                + "\n"
                + "\nPlease enter the length, width, height, and number of "
                + "\nstories of the house you would like to build");
    }

    @Override
    public void display() {
        House playerHouse = PiggysRevenge.getCurrentGame().getHouse();

        if (playerHouse.getHeight() == 0
            || playerHouse.getLength() == 0
            || playerHouse.getWidth() == 0
            || playerHouse.getStories() == 0) {
            this.chooseSizes();
        } else {
            try {
                System.out.println("\nYour previously chosen house dimensions are:"
                        + "\nLength: " + playerHouse.getLength()
                        + "\nWidth: " + playerHouse.getWidth()
                        + "\nHeight: " + playerHouse.getHeight()
                        + "\nStories: " + playerHouse.getStories()
                        + "\nWhich will require "
                        + GameControl.calcNumberOfBricks(playerHouse.getLength(), playerHouse.getWidth(), playerHouse.getHeight(), playerHouse.getStories())
                        + " bricks.");
            } catch (GameControlException ex) {
                System.out.println(ex.getMessage());
            }
            //temporarily change messages for getInput
            this.displayMessage = "\nWould you like to change your dimensions? (Y or N)";
            String value = this.getInput().toUpperCase();
            switch (value) {
                case "Y":
                    this.displayMessage = "\nPlease enter the length, width, height, and number of "
                                        + "\nstories of the house you would like to build";
                    this.chooseSizes();
                    break;
                case "N":
                    return;
                default:
                    System.out.println("\n-----------------------------------------------------------------"
                            + "\nERROR: Please enter Y or N"
                            + "\n-----------------------------------------------------------------");
            }
        }

    }
    
    public boolean doAction(String input1,String input2,String input3,String input4) {
        // System.out.println("\n*** doAction() function called ***");
//        String[] parts = value.split("\\s+");
//
//        if (parts.length != 4) {
//            System.out.println("Please enter exactly 4 integers.");
//            return false;
//        }
//
//        String input1 = parts[0].toUpperCase();
//        String input2 = parts[1].toUpperCase();
//        String input3 = parts[2].toUpperCase();
//        String input4 = parts[3].toUpperCase();
//
//        if ("Q".equals(input1.toUpperCase()) || "Q".equals(input2.toUpperCase()) || "Q".equals(input3.toUpperCase()) || "Q".equals(input4.toUpperCase())) {
//            return true;
//
//        }
        int num1, num2, num3, num4;

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
        //I guess all is well, let's save the dimensions
        House playerHouse = PiggysRevenge.getCurrentGame().getHouse();
        playerHouse.setLength(num1);
        playerHouse.setWidth(num2);
        playerHouse.setHeight(num3);
        playerHouse.setStories(num4);
        //Tell the player how many bricks they'll need.
        int result;
        try {
            result = GameControl.calcNumberOfBricks(num1, num2, num3, num4);
            System.out.println("\nYou will need " + result + " bricks to build your house  Good Luck!");
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

    @Override
    public boolean doAction(String value) {
        System.out.println("\n*** doAction() function called ***");
        return true;
    }

    private void chooseSizes() {
        System.out.println(this.displayMessage);
        boolean done = false;
        do {
            this.displayMessage = "Enter the length of the house (between 5 and 20)";
            String userInput1 = this.getInput();
            if ("Q".equals(userInput1.toUpperCase())) {
                System.out.println("House Size View Interrupted.");
                return;
            }
            this.displayMessage = "Enter the width of the house (between 5 and 20)";
            String userInput2 = this.getInput();
            if ("Q".equals(userInput2.toUpperCase())) {
                System.out.println("House Size View Interrupted.");
                return;
            }
            this.displayMessage = "Enter the height of the house (between 6 and 10)";
            String userInput3 = this.getInput();
            if ("Q".equals(userInput3.toUpperCase())) {
                System.out.println("House Size View Interrupted.");
                return;
            }
            this.displayMessage = "Enter the number of stories of the house (between 1 and 3)";
            String userInput4 = this.getInput();
            if ("Q".equals(userInput4.toUpperCase())) {
                System.out.println("House Size View Interrupted.");
                return;
            }
           
            done = this.doAction(userInput1, userInput2, userInput3, userInput4);
            
        } while (!done); 
    }

}
