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
class MiniGameView {
    
    private final String miniGameIntro;
    private MiniGame miniGame;
    private int comboLength;
    
    public MiniGameView() {
        this.miniGameIntro = "\n-----------------------------------------------------------------"
                + "\nIn this game, you will guess the corect order of four numbers. (1 2 3 4)"
                + "\nThe correct order is chosen at random.  You will enter a four"
                + "\ndigit number and then you will be told the how many digits"
                + "\nare in the correct order.  You win when you guess the correct order."
                + "\n-----------------------------------------------------------------";
    }

    public void displayMiniGame(MiniGame miniGame) {
        //System.out.println("\n*** displayMiniGame() function called ***");
        this.miniGame = miniGame;
        this.comboLength = miniGame.getComboOrder().length();
        System.out.println(this.miniGameIntro);
        boolean done = false;
        do {
            String userGuess = this.getInput();
           
            done = this.doAction(userGuess);
            
        } while (!done);  
        
        
    }

    private String getInput() {
        // System.out.println("\n*** getMenuOption() function called ***");
        Scanner keyboard = new Scanner(System.in); 
        String value = "";
        boolean valid = false;

        while (!valid) {
            System.out.println("\n\nGuess the correct order (ie. 1234, or 3241, etc.), or Q to quit: ");

            value = keyboard.nextLine();
            value = value.trim();

            if (value.length() < 1 || value.length() > this.comboLength) {
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nYour Guess is too long or too short. Please re-enter your guess."
                        + "\n-----------------------------------------------------------------");
                continue;
}
        break;
}
    return value;
    }

    private boolean doAction(String userGuess) {
        // System.out.println("\n*** doAction() function called ***");
        userGuess = userGuess.toUpperCase();
        
        if ("Q".equals(userGuess)) {
            return true;
        }
        
        int result = MiniGameControl.checkKeyOrder(userGuess, this.miniGame.getComboOrder());
        
        switch (result) {
            case -1:
            case -2:
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nPlease enter a number that is exactly "
                        + String.valueOf(this.comboLength)
                        + " digits long."
                        + "\n-----------------------------------------------------------------");
                break;
            case -3:
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nYou must enter a combination of 1234.  You must include exactly"
                        + "\none of each digit."
                        + "\n-----------------------------------------------------------------");
                break;
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
