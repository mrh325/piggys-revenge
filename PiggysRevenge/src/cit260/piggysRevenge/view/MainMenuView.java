/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.GameControl;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author hales
 */
public class MainMenuView extends View{
    //private String menu;
    private final String menuCurrentGame;
    private final String menuNewGame;
    private GameMenuView gameMenu;

    public MainMenuView() {
        //Game currentGame = PiggysRevenge.getCurrentGame();
            super("\n"
                + "\n======================================="
                + "\n| Main Menu                           |"
                + "\n======================================="
                + "\nN - Start (N)ew game"
                + "\nL - (L)oad saved game"
                + "\nH - Get (H)elp"
                + "\nQ - (Q)uit"
                + "\n=======================================");
            
            //main menu before starting a new game
            this.menuNewGame ="\n"
                + "\n======================================="
                + "\n| Main Menu                           |"
                + "\n======================================="
                + "\nN - Start (N)ew game"
                + "\nL - (L)oad saved game"
                + "\nH - Get (H)elp"
                + "\nQ - (Q)uit"
                + "\n=======================================";
            //main menu after starting a new game
            this.menuCurrentGame = "\n"
                + "\n======================================="
                + "\n| Main Menu                           |"
                + "\n======================================="
                + "\nN - Start (N)ew game"
                + "\nC - (C)ontinue game"
                + "\nL - (L)oad saved game"
                + "\nS - (S)ave game"
                + "\nH - Get (H)elp"
                + "\nQ - (Q)uit"
                + "\n=======================================";
    }
    
    

    @Override
    public boolean doAction(String value) {
        // this.console.println("\n*** doAction() function called ***");
        
        value = value.toUpperCase();
        
        switch (value) {
            case "N":
                this.startNewGame();
                break;
            case "C":
                // This should return to game menu, if there is one
                try {
                    this.displayGameMenu();
                } catch (NullPointerException e) {
                    this.console.println("\n*** ERROR:  No game in progress ***");
                }
                break;
            case "L":
                this.startSavedGame();
                break;
            case "S":
                try {
                    this.saveGame();
                } catch (NullPointerException e) {
                    this.console.println("\n*** ERROR:  No game in progress ***");
                }
                break;
            case "H":
                this.displayHelpMenu();
                break;
            default:
                this.console.println("\n*** Invalid selection *** Try again ***");
                break;
        }
        return false;
    }

    private void startNewGame() {
        // this.console.println("\n*** startNewGame() function called ***");
        //Don't erase a current game unless the player confirms
        if (PiggysRevenge.getCurrentGame() != null) {
            this.displayMessage = "\n-----------------------------------------------------------------"
                        + "\nThis will quit your current game and start a new game!  Continue?  (Y or N)"
                        + "\n-----------------------------------------------------------------";
            String value = this.getInput().toUpperCase();
            switch (value) {
                case "Y":
                    break;
                case "N":
                    this.displayMessage = this.menuCurrentGame;
                    return;
                default:
                    this.console.println("\n-----------------------------------------------------------------"
                            + "\nERROR: Please enter Y or N"
                            + "\n-----------------------------------------------------------------");
            }
        }
        GameControl.createNewGame(PiggysRevenge.getPlayer());
        
        this.displayMessage = this.menuCurrentGame; //change menu to include current game options
        boolean done = false;
        while (!done) {
            done = true;
            try {
                HouseSizeView houseSizeView = new HouseSizeView();
                houseSizeView.display();
            } catch (Exception e) {
                this.console.println(e.getMessage());
                done = false;
            }
        }
        
        this.gameMenu = new GameMenuView();
        this.gameMenu.display();

    }

    private void displayGameMenu() {
        //this.console.println("\n*** displayGameMenu() function called ***");

        this.gameMenu.display();
    }

    private void startSavedGame() {
        this.displayMessage = "\nEnter the name of the file with the saved game.";
        
        String filePath = this.getInput();
        
        try {
            GameControl.getSavedGame(filePath);
            this.displayMessage = this.menuCurrentGame;
            GameMenuView gameMenu = new GameMenuView();
            this.gameMenu = gameMenu;
            
        }catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
            this.displayMessage = this.menuNewGame;
        }
        
        
        
    }

    private void saveGame() {
        
        this.displayMessage = "\n\nEnter the name of the file to be saved.";
        
        String filePath = this.getInput();
        
        try {
            GameControl.saveGame(PiggysRevenge.getCurrentGame(), filePath);
            this.console.println("\nYour game was successfully saved to " + filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        this.displayMessage = this.menuCurrentGame;
    }

    private void displayHelpMenu() {
        // this.console.println("\n*** displayHelpMenu() function called ***");
    
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
        
    }
    

}

