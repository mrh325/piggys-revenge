/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.GameControl;
import cit260.piggysRevenge.model.Game;
import cit260.piggysRevenge.model.House;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
class ScoreView extends View {


    public ScoreView() {
        super("\n-----------------------------------------------------------------"
                + "\nGenerating your possible score... Please enter the following"
                + "\non one line. Separate each value with a space"
                + "\n-----------------------------------------------------------------"
                + "\nHow many bricks will be in your house?"
                + "\nHow many turns will have passed when the game ends?"
                + "\nWill you have eaten the roast beef? (Y or N)"
                + "\nWill you have captured the Wolf? (Y or N)");
    }

    @Override
    public void display() {
        // System.out.println("\n*** display() function called ***");
        Game game = PiggysRevenge.getCurrentGame();
        int bricks;
        if (game.getHouse().isCompleted()) {
            House house = game.getHouse();
            bricks = GameControl.calcNumberOfBricks(house.getLength(), house.getWidth(), house.getHeight(), house.getStories());
        } else {
            bricks = 0;
        }
        int turns = game.getTurns();
        boolean hasEaten = game.getPlayer().isHasEaten();
        boolean wolfKilled = game.isWolfKilled();
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
                    + "\nCongrats!  Your score is: "
                    + String.valueOf(result)
                    + "."
                    + "\nYou lasted " + turns + " turns."
                    + "\n-----------------------------------------------------------------");
        }
        
     
    }
    
    @Override
    public boolean doAction(String value) {
//        // System.out.println("\n*** doAction() function called ***");
//        //split whitespace separated values
//        String[] parts = value.split("\\s+");
//        if (parts.length != 4) {
//            System.out.println("\n-----------------------------------------------------------------"
//                        + "\nERROR:  You must enter 4 space-separated values"
//                        + "\n-----------------------------------------------------------------");
//            return false;
//        }
//
//        String input1 = parts[0].toUpperCase();
//        String input2 = parts[1].toUpperCase();
//        String input3 = parts[2].toUpperCase();
//        String input4 = parts[3].toUpperCase();
//
//        
//        if ("Q".equals(input1) || "Q".equals(input2) || "Q".equals(input3) || "Q".equals(input4)) {
//            return true;
//        }
//        int bricks;
//        int turns;
//        boolean hasEaten;
//        boolean wolfKilled;
//        try {
//            bricks = Integer.parseInt(input1);
//            turns = Integer.parseInt(input2);
//        } catch (NumberFormatException e) {
//            System.out.println("\n-----------------------------------------------------------------"
//                        + "\nERROR:  Number of Bricks and Turns must be whole numbers"
//                        + "\n-----------------------------------------------------------------");
//            return false;
//        }
//        if (!("Y".equals(input3) || "N".equals(input3))) {
//            System.out.println("\n-----------------------------------------------------------------"
//                    + "\nERROR: You must enter Y or N for the Has Eaten question"
//                    + "\n-----------------------------------------------------------------");
//            return false;
//        } else if (!("Y".equals(input4) || "N".equals(input4))) {
//            System.out.println("\n-----------------------------------------------------------------"
//                    + "\nERROR: You must enter Y or N for the Wolf Killed question"
//                    + "\n-----------------------------------------------------------------");
//            return false;
//        } else {
//            if (null == input3) {
//                System.out.println("\n-----------------------------------------------------------------"
//                        + "\nERROR: Null Error"
//                        + "\n-----------------------------------------------------------------");                
//                return false;
//            } else switch (input3) {
//                case "Y":
//                    hasEaten = true;
//                    break;
//                case "N":
//                    hasEaten = false;
//                    break;
//                default:
//                    System.out.println("\n-----------------------------------------------------------------"
//                            + "\nERROR: Unkown Error"
//                            + "\n-----------------------------------------------------------------");
//                    return false;
//            }
//            if (null == input4) {
//                System.out.println("\n-----------------------------------------------------------------"
//                        + "\nERROR: Null Error"
//                        + "\n-----------------------------------------------------------------");                
//                return false;
//            } else switch (input4) {
//                case "Y":
//                    wolfKilled = true;
//                    break;
//                case "N":
//                    wolfKilled = false;
//                    break;
//                default:
//                    System.out.println("\n-----------------------------------------------------------------"
//                            + "\nERROR: Unkown Error"
//                            + "\n-----------------------------------------------------------------");
//                    return false;
//            }
//            
//            int result = GameControl.calcScore(bricks, turns, hasEaten, wolfKilled);
//            if (result == -1) {
//                System.out.println("\n-----------------------------------------------------------------"
//                        + "\nERROR: You may not have less than 0 bricks"
//                        + "\n-----------------------------------------------------------------");
//            } else if (result == -2) {
//                System.out.println("\n-----------------------------------------------------------------"
//                        + "\nERROR: Turns can not be less than 1"
//                        + "\n-----------------------------------------------------------------");
//            } else if (result == -3) {
//                System.out.println("\n-----------------------------------------------------------------"
//                        + "\nERROR: The wolf can't be killed if the player has not eaten"
//                        + "\n-----------------------------------------------------------------");
//            } else {
//                System.out.println("\n-----------------------------------------------------------------"
//                        + "\nWith answers like those, Your score would be "
//                        + String.valueOf(result)
//                        + "."
//                                + "\n-----------------------------------------------------------------");
//                return true;
//            }
//        }
        return false;  
    }
    
}
