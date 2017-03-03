/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.MiniGameControl;
import cit260.piggysRevenge.model.MiniGame;

/**
 *
 * @author natebolton
 */
class MiniGameMenuView extends View {
    //private String menu;

    public MiniGameMenuView() {
        super("\n"
                + "\n======================================="
                + "\n| MiniGame Menu                           |"
                + "\n======================================="
                + "\nN - Start a (N)ew minigame"
                + "\nH - Get (H)elp"
                + "\nB - (B)ack to Game Menu"
                + "\n=======================================");
    }

    @Override
    public boolean doAction(String menuOption) {
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
        MiniGameView miniGameView = new MiniGameView(miniGame);
        miniGameView.display();
    }
    
    private void displayHelpMenu() {
        // System.out.println("\n*** displayHelpMenu() function called ***");
    
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayMenu();
        
    }
}
