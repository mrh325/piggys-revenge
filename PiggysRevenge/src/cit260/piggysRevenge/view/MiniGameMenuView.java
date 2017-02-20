/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.MiniGameControl;
import cit260.piggysRevenge.model.MiniGame;
import java.util.Scanner;

/**
 *
 * @author natebolton
 */
class MiniGameMenuView {
    private String menu;

    public MiniGameMenuView() {
        this.menu = "\n"
                + "\n======================================="
                + "\n| MiniGame Menu                           |"
                + "\n======================================="
                + "\nN - Start a new minigame"
                + "\nH - Get Help"
                + "\nB - Back to Game Menu"
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
            case "N":
                this.startNewMiniGame();
                break;
            case "H":
                this.displayHelpMenu();
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

    private void startNewMiniGame() {
        //System.out.println("\n*** startNewMiniGame() function called ***");
        
        MiniGame miniGame = new MiniGame();
        miniGame.setComboOrder("1234");
        MiniGameControl.generateComboOrder(miniGame);
        MiniGameView miniGameView = new MiniGameView();
        miniGameView.displayMiniGame(miniGame);
    }
    
    private void displayHelpMenu() {
        // System.out.println("\n*** displayHelpMenu() function called ***");
    
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayMenu();
        
    }
}
