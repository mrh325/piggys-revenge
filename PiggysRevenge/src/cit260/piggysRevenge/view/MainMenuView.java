/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.GameControl;
import cit260.piggysRevenge.model.Game;
import java.util.Scanner;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author hales
 */
public class MainMenuView {
    private String menu;
    private String menuCurrentGame;

    public MainMenuView() {
        Game currentGame = PiggysRevenge.getCurrentGame();
        
            //If game is null
            this.menu = "\n"
                + "\n======================================="
                + "\n| Main Menu                           |"
                + "\n======================================="
                + "\nN - Start new game"
                + "\nL - Load saved game"
                + "\nH - Get Help"
                + "\nQ - Quit"
                + "\n=======================================";
            //if game is not null
            this.menuCurrentGame = "\n"
                    + "\n======================================="
                    + "\n| Main Menu                           |"
                    + "\n======================================="
                    + "\nN - Start new game"
                    + "\nC - Continue game"
                    + "\nL - Load saved game"
                    + "\nS - Save game"
                    + "\nH - Get Help"
                    + "\nQ - Quit"
                    + "\n=======================================";
    }
    
    

    public void displayMainMenuView() {
        // System.out.println("\n*** displayMainMenuView() function called ***");
        boolean done = false;
        do {
            System.out.println(this.menu);
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q"))
                return;
            
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
            case "N":
                this.startNewGame();
                break;
            case "C":
                this.displayGameMenu(); // This should return to game menu
                break;
            case "L":
                this.loadSavedGame();
                break;
            case "S":
                this.saveGame();
                break;
            case "H":
                this.displayHelpMenu();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again ***");
                break;
        }
        return false;
    }

    private void startNewGame() {
        // System.out.println("\n*** startNewGame() function called ***");
        
        GameControl.createNewGame(PiggysRevenge.getPlayer());
        this.menu = this.menuCurrentGame; //change menu to include current game options
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu();
    }

    private void displayGameMenu() {
        //System.out.println("\n*** displayGameMenu() function called ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu();
    }

    private void loadSavedGame() {
        System.out.println("\n*** loadSavedGame() function called ***");
    }

    private void saveGame() {
        System.out.println("\n*** saveGame() function called ***");
    }

    private void displayHelpMenu() {
        // System.out.println("\n*** displayHelpMenu() function called ***");
    
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayMenu();
        
    }
    
}
