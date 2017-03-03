/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import java.util.Scanner;


public class MoveMenuView {
    
    private String menu;

    public MoveMenuView() {
        this.menu = "\n"
                + "\n======================================="
                + "\n| Move Menu                           |"
                + "\n======================================="
                + "\nU - (U)p"
                + "\nD - (D)own"
                + "\nL - (L)eft"
                + "\nR - (R)ight"
                + "\nT - (T)est Wolf Encounter View"
                + "\nB - (B)ack to Main Menu"
                + "\n=======================================";
    }
    

    public void displayMenu() {
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
            case "U":
                this.moveUp();
                break;
            case "D":
                this.moveDown();
                break;
            case "L":
                this.moveLeft();
                break;
            case "R":
                this.moveRight();
                break;
            case "T":
                this.displayWolfView();
                break;
            case "B":
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again ***");
                break;
        }
        return false;
    }

    private void moveUp() {
        System.out.println("\n*** moveUp() function called ***");
    }

    private void moveDown() {
        System.out.println("\n*** moveDown() function called ***");
    }

    private void moveLeft() {
        System.out.println("\n*** moveLeft() function called ***");
    }

    private void moveRight() {
        System.out.println("\n*** moveRight() function called ***");
    }

    private void displayWolfView() {
        //PROOF OF CONCEPT ONLY, REMOVE WHEN THIS VIEW IS INSERTED IN ITS PROPER PLACE
        WolfView wolfView = new WolfView();
        wolfView.display();
    }


}
