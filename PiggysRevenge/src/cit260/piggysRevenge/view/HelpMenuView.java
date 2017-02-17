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
class HelpMenuView {


private String menu;
    
    public HelpMenuView() {
        this.menu = "\n"
                + "\n======================================="
                + "\n| Help Menu                           |"
                + "\n======================================="
                + "\nG - Game description"
                + "\nH - How to move"
                + "\nS - Scoring"
                + "\nM - Main Menu"
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
            case "G":
                System.out.println("Game Description"); // Add Game description
                break;
            case "H":
                System.out.println("How to move"); // Add Game description
                break;
            case "S":
                 System.out.println("Scoring"); // Add Game description
                break;
            case "M":
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again ***");
                break;
        }
        return false;    }
} 

