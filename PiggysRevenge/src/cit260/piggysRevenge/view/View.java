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
public abstract class View implements ViewInterface {
    
    protected String displayMessage;
    
    public View() {
    }
    
    public View(String message) {
        this.displayMessage = message;
    }

    @Override
    public void display() {
        // System.out.println("\n*** display() function called ***");
        boolean done = false;
        do {
            // System.out.println(this.menu);
            String value = this.getInput();
            if (value.toUpperCase().equals("Q"))
                return;
            
            done = this.doAction(value);
            
        } while (!done);
        
     
    }
    
    @Override
    public String getInput() {
        // System.out.println("\n*** getInput() function called ***");
        Scanner keyboard = new Scanner(System.in); 
        String value = "";
        boolean valid = false;

        while (!valid) {
            System.out.println("\n" + this.displayMessage);

            value = keyboard.nextLine();
            value = value.trim();

            if (value.length() < 1) {
                System.out.println("\n-----------------------------------------------------------------"
                        + "\nInvalid input. Please re-enter your input."
                        + "\n-----------------------------------------------------------------");
                continue;

            }
        break;
        }
        return value;
    }

}
