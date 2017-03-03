/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import java.util.Scanner;

/**
 *
 * @author natebolton
 */
public class GameMenuView {

    private String menu;

    public GameMenuView() {
        this.menu = "\n"
                + "\n======================================="
                + "\n| Game Menu                           |"
                + "\n======================================="
                + "\nM - Move"
                + "\nS - Show Map"
                + "\nD - Calculate distance between two points"
                + "\nI - Inventory"
                + "\nG - Play the Mini Game!"
                + "\nC - Show possible score"
                + "\nE - Show probability of winning the game"
                + "\n    in the fewest turns possible"
                + "\nU - Calculate number of bricks for the house"
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
            case "M":
                this.displayMoveMenu();
                break;
            case "S":
                this.displayMap();
                break;
            case "D":
                this.displayDistance();
                break;
            case "I":
                this.displayInventoryMenu();
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
        //System.out.println("\n*** displayDistance() function called ***");
        DistanceView distanceView = new DistanceView();
        distanceView.display();
    }

    private void displayInventoryMenu() {
        //System.out.println("\n*** displayInventory() function called ***");
        //We'll probably pass a backpack object in here.
        InventoryMenuView inventoryMenu = new InventoryMenuView();
        inventoryMenu.display();
    }

    private void displayMiniGameMenu() {
        //System.out.println("\n*** displayMiniGameMenu() function called ***");
        MiniGameMenuView miniGameMenu = new MiniGameMenuView();
        miniGameMenu.display();
    }

    private void displayScore() {
        //System.out.println("\n*** displayScore() function called ***");
        ScoreView scoreView = new ScoreView();
        scoreView.display();
    }

    private void displayProbability() {
        //System.out.println("\n*** displayProbability() function called ***");
        ProbabilityView probabilityView = new ProbabilityView();
        probabilityView.display();
    }

    private void displayHouseMenu() {
        // System.out.println("\n*** displayHouseMenu() function called ***");
        HouseSizeView houseSize = new HouseSizeView();
        houseSize.displayHouse();
    }
    
}
