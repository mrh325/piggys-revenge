/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.MiniGameControl;
import cit260.piggysRevenge.exceptions.MiniGameControlException;
import cit260.piggysRevenge.model.MiniGame;

/**
 *
 * @author natebolton
 */
class MiniGameView extends View {
    
    //private final String miniGameIntro;
    private final MiniGame miniGame;
    private final int comboLength;
    
    public MiniGameView(MiniGame miniGame) {
        super("\n\nGuess the correct order (ie. 1234, or 3241, etc.), or Q to quit: ");
        System.out.println("\n-----------------------------------------------------------------"
                + "\nIn this game, you will guess the corect order of four numbers. (1 2 3 4)"
                + "\nThe correct order is chosen at random.  You will enter a four"
                + "\ndigit number and then you will be told the how many digits"
                + "\nare in the correct order.  You win when you guess the correct order."
                + "\n-----------------------------------------------------------------");
        this.miniGame = miniGame;
        this.comboLength = miniGame.getComboOrder().length();
    }

    @Override
    public boolean doAction(String userGuess) {
        // System.out.println("\n*** doAction() function called ***");
        userGuess = userGuess.toUpperCase();
        
        if ("Q".equals(userGuess)) {
            return true;
        }
        
        int result = -1;
        try {
            result = MiniGameControl.checkKeyOrder(userGuess, this.miniGame.getComboOrder());
        } catch (MiniGameControlException ex) {
            System.out.println(ex.getMessage());
        }
        
        switch (result) {
            case 0:
            case 1:
            case 2:
            case 3:
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nYou have " + String.valueOf(result) + " digits in the correct order."
                        + "\n-----------------------------------------------------------------");
                break;
            case 4:
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nYou win! The correct order was "
                        + String.valueOf(this.miniGame.getComboOrder())
                        + "\n-----------------------------------------------------------------");
                return true;
        }
        return false;  
    }
}
