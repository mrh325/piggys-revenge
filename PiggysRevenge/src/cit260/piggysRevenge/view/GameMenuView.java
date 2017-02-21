/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import java.util.Scanner;

/**
 *
 * @author hales
 */
public class GameMenuView {

    private String menu;

    public GameMenuView() {
        this.menu = "\n"
                + "\n======================================="
                + "\n| Game Menu                           |"
                + "\n======================================="
                + "\nV - Move"
                + "\nS - Show Map"
                + "\nD - List Known Distance"
                + "\nI - Inventory"
                + "\nH - Change your hat"
                + "\nO - Change your Shoes"
                + "\nG - Play the Mini Game!"
                + "\nC - Show possible score"
                + "\nE - Show probability of winning the game"
                + "\n    in the fewest turns possible"
                + "\nU - Caluclate number of bricks for the house"
                + "\nB - Back to Main Menu"
                + "\n=======================================";
    }
    
    public void displayMenu() {
        // System.out.println("\n*** displayMenu() function called ***");
        boolean done = false;
        do {
            System.out.println(this.menu);
            String menuOption = this.getMenuOption();
           /* if (menuOption.toUpperCase().equals("Q"))
                return; */
           
            done = this.doAction(menuOption);
            
        } while (!done);
        
     
    }

    private String getMenuOption() {
        // System.out.println("\n*** getMenuOption() function called ***");
        Scanner keyboard = new Scanner(System.in); 
        String value = "";
        boolean valid = false;

        while (!valid) {
            System.out.println("\nPlease choose from the options above: ");

            value = keyboard.nextLine();
            value = value.trim();

            if (value.length() < 1 || value.length() > 1) {
                System.out.println("\nInvalid value: Please re-enter");
                continue;
}
        break;
}
    return value;
    }

    private boolean doAction(String menuOption) {
        // System.out.println("\n*** doAction() function called ***");
        
        menuOption = menuOption.toUpperCase();
        
        switch (menuOption) {
            case "V":
                this.displayMoveMenu();
                break;
            case "S":
                this.displayMap();
                break;
            case "D":
                this.displayDistance();
                break;
            case "I":
                this.displayInventory();
                break;
            case "H":
                this.displayHatMenu();
                break;
            case "O":
                this.displayShoeMenu();
                break;
            case "G":
                this.displayMiniGameMenu();
                break;
            case "C":
                this.displayScore();
                break;
            case "E":
                this.displayProbability();
                break;
            case "U":
                this.displayHouseMenu();
                break;
            case "B":
            case "Q":
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again ***");
                break;
        }
        return false;    
    }

    private void displayMoveMenu() {
        
        MoveMenuView moveMenu = new MoveMenuView();
        moveMenu.displayMenu();
    }

    private void displayMap() {
        System.out.println("\n*** displayMap() function called ***");
    }

    private void displayDistance() {
        System.out.println("\n*** displayDistance() function called ***");
    }

    private void displayInventory() {
        System.out.println("\n*** displayInventory() function called ***");
    }

    private void displayHatMenu() {
        System.out.println("\n*** displayHatMenu() function called ***");
    }

    private void displayShoeMenu() {
        System.out.println("\n*** displayShoeMenu() function called ***");
    }

    private void displayMiniGameMenu() {
        //System.out.println("\n*** displayMiniGameMenu() function called ***");
        MiniGameMenuView miniGameMenu = new MiniGameMenuView();
        miniGameMenu.displayMenu();
    }

    private void displayScore() {
        //System.out.println("\n*** displayScore() function called ***");
        ScoreView scoreView = new ScoreView();
        scoreView.displayScore();
    }

    private void displayProbability() {
        //System.out.println("\n*** displayProbability() function called ***");
        ProbabilityView probabilityView = new ProbabilityView();
        probabilityView.displayProbability();
    }

    private void displayHouseMenu() {
        System.out.println("\n*** displayHouseMenu() function called ***");
    }
    
}
