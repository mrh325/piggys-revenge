/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.MapControl;
import java.awt.Point;


public class MoveMenuView extends View {
    Point playerLoc;
    
    public MoveMenuView(Point playerLoc) {
        super ();
        this.playerLoc = playerLoc;
        this.drawMenu(playerLoc);
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
        MapControl.movePlayer(playerLoc,"up");
        this.drawMenu(playerLoc);
        MapControl.drawMap();
    }

    private void moveDown() {
        System.out.println("\n*** moveDown() function called ***");
        MapControl.movePlayer(playerLoc,"down");
        this.drawMenu(playerLoc);
        MapControl.drawMap();
    }

    private void moveLeft() {
        System.out.println("\n*** moveLeft() function called ***");
        MapControl.movePlayer(playerLoc,"left");
        this.drawMenu(playerLoc);
        MapControl.drawMap();
    }

    private void moveRight() {
        System.out.println("\n*** moveRight() function called ***");
        MapControl.movePlayer(playerLoc,"right");
        this.drawMenu(playerLoc);
        MapControl.drawMap();
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

    private void drawMenu(Point playerLoc) {
        this.displayMessage = "\n"
                + "\n======================================="
                + "\n| Move Menu                           |"
                + "\n=======================================";
        if (playerLoc.y != 0) {
            this.displayMessage += "\nU - (U)p";
        }
        if (playerLoc.y != 6) {
            this.displayMessage += "\nD - (D)own";
        }
        if (playerLoc.x != 0) {
            this.displayMessage += "\nL - (L)eft";
        }
        if (playerLoc.x != 6) {
            this.displayMessage += "\nR - (R)ight";
        }
        this.displayMessage += "\nT - (T)est Wolf Encounter View (FOR TESTING ONLY)"
                + "\nH - Test find (H)at view (FOR TESTING ONLY)"
                + "\nB - (B)ack to Main Menu"
                + "\n=======================================";   
    }
}
