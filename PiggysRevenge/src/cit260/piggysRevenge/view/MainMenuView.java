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
    private GameMenuView gameMenu;

    public MainMenuView() {
        //Game currentGame = PiggysRevenge.getCurrentGame();
        
            //main menu before starting a new game
            super("\n"
                + "\n======================================="
                + "\n| Main Menu                           |"
                + "\n======================================="
                + "\nN - Start (N)ew game"
                + "\nL - (L)oad saved game"
                + "\nH - Get (H)elp"
                + "\nQ - (Q)uit"
                + "\n=======================================");
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
    
    

//    public void displayMainMenuView() {
//        // System.out.println("\n*** displayMainMenuView() function called ***");
//        boolean done = false;
//        do {
//            System.out.println(this.menu);
//            String menuOption = this.getMenuOption();
//            if (menuOption.toUpperCase().equals("Q"))
//                return;
//            
//            done = this.doAction(menuOption);
//            
//        } while (!done);
//        
//     
//    }
//
//    private String getMenuOption() {
//        // System.out.println("\n*** getMenuOption() function called ***");
//        Scanner keyboard = new Scanner(System.in); 
//        String value = "";
//        boolean valid = false;
//
//        while (!valid) {
//            System.out.println("\nPlease choose from the options above: ");
//
//            value = keyboard.nextLine();
//            value = value.trim();
//
//            if (value.length() < 1 || value.length() > 1) {
//                System.out.println("\nInvalid value: Please re-enter");
//                continue;
//}
//        break;
//}
//    return value;
//    }

    @Override
    public boolean doAction(String value) {
        // System.out.println("\n*** doAction() function called ***");
        
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
                    System.out.println("\n*** ERROR:  No game in progress ***");
                }
                break;
            case "L":
                this.loadSavedGame();
                break;
            case "S":
                try {
                    this.saveGame();
                } catch (NullPointerException e) {
                    System.out.println("\n*** ERROR:  No game in progress ***");
                }
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
                    System.out.println("\n-----------------------------------------------------------------"
                            + "\nERROR: Please enter Y or N"
                            + "\n-----------------------------------------------------------------");
            }
        }
        GameControl.createNewGame(PiggysRevenge.getPlayer());
//        GameControl.createNewHouse(PiggysRevenge.getPlayer());
        //ASK PLAYER FOR HOUSE INPUTS HERE (FUTURE IMPLEMENTATION)
//        this.displayMessage = "\n-----------------------------------------------------------------"
//                + "\nPlease enter the size of house you plan to build.  The size of your house"
//                + "\ndetermines the number of bricks you must collect and adds to your"
//                + "score at the end of the game."
//                + "\n-----------------------------------------------------------------";
//        HouseSizeView houseSizeView = new HouseSizeView();
//        houseSizeView.display();

        
        this.displayMessage = this.menuCurrentGame; //change menu to include current game options

        this.gameMenu = new GameMenuView();
        this.gameMenu.display();

    }

    private void displayGameMenu() {
        //System.out.println("\n*** displayGameMenu() function called ***");

        this.gameMenu.display();
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
        helpMenu.display();
        
    }
    
}

