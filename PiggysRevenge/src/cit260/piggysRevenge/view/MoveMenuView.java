/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;


public class MoveMenuView extends View {
    
    public MoveMenuView() {
        super ( "\n"
                + "\n======================================="
                + "\n| Move Menu                           |"
                + "\n======================================="
                + "\nU - (U)p"
                + "\nD - (D)own"
                + "\nL - (L)eft"
                + "\nR - (R)ight"
                + "\nT - (T)est Wolf Encounter View (FOR TESTING ONLY)"
                + "\nH - Test find (H)at view (FOR TESTING ONLY)"
                + "\nB - (B)ack to Main Menu"
                + "\n=======================================");
    }
    

    @Override
    public boolean doAction(String menuOption) {
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
            case "H":
                this.findHat();
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

    private void findHat() {
        FindHatView findHat = new FindHatView();
        findHat.display();
    }


}
