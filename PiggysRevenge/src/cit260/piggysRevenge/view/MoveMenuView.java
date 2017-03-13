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
    Point wolfLoc;
    
    public MoveMenuView(Point playerLoc, Point wolfLoc) {
        super ();
        this.playerLoc = playerLoc;
        this.wolfLoc = wolfLoc;
        MapControl.drawMap();
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
            case "M":
                this.displayMap();
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
        //System.out.println("\n*** moveUp() function called ***");
        //move the player's location
        MapControl.movePlayer(playerLoc,"up");
        this.doAfterMove(playerLoc,wolfLoc);
//        //----------------------------
//        //MOVE THE WOLF HERE
//        MapControl.moveWolf(wolfLoc);
//        //----------------------------
//
//        //----------------------------
//        //ADD CHECKS FOR EVENTS HERE starting with wolf encounter, then 
//        //piggy's or building site, then items or bricks.
//        if (playerLoc.equals(wolfLoc)) {
//            WolfView wolfView = new WolfView();
//            wolfView.display();
//        }
//        //----------------------------
//        
//        //redefine the menu for the next display() call
//        this.drawMenu(playerLoc);        
//        //draw the map to screen
//        MapControl.drawMap();
    }

    private void moveDown() {
        //System.out.println("\n*** moveDown() function called ***");
        MapControl.movePlayer(playerLoc,"down");
        this.doAfterMove(playerLoc,wolfLoc);
    }

    private void moveLeft() {
        //System.out.println("\n*** moveLeft() function called ***");
        MapControl.movePlayer(playerLoc,"left");
        this.doAfterMove(playerLoc,wolfLoc);
    }

    private void moveRight() {
        //System.out.println("\n*** moveRight() function called ***");
        MapControl.movePlayer(playerLoc,"right");
        this.doAfterMove(playerLoc,wolfLoc);
    }

    private void findHat() {
        FindHatView findHat = new FindHatView();
        findHat.display();
    }

    private void displayMap() {
//        System.out.println("\n*** displayMap() function called ***");
        MapControl.drawMap();
    }
    
    private void drawMenu(Point playerLoc) {
        this.displayMessage = "\n"
                + "\n======================================="
                + "\n| Move Menu                           |"
                + "\n=======================================";
        if (playerLoc.x != 0) {
            this.displayMessage += "\nU - (U)p";
        }
        if (playerLoc.x != 6) {
            this.displayMessage += "\nD - (D)own";
        }
        if (playerLoc.y != 0) {
            this.displayMessage += "\nL - (L)eft";
        }
        if (playerLoc.y != 6) {
            this.displayMessage += "\nR - (R)ight";
        }
        this.displayMessage += "\nM - Display the (M)ap"
                + "\nH - Test find (H)at view (FOR TESTING ONLY)"
                + "\nB - (B)ack to Main Menu"
                + "\n=======================================";   
    }
    
    private void doAfterMove(Point playerLoc,Point wolfLoc) {
        
        //MOVE THE WOLF HERE
        MapControl.moveWolf(wolfLoc);
        //ADD CHECKS FOR EVENTS HERE starting with wolf encounter, then 
        //piggy's or building site, then items or bricks.
        if (playerLoc.x == wolfLoc.x && playerLoc.y == wolfLoc.y) {
            WolfView wolfView = new WolfView();
            wolfView.display();
        } else {
            System.out.println("playerLoc and WolfLoc");
            System.out.println(playerLoc);
            System.out.println(wolfLoc);            
        }
        
        //redefine the menu for the next display() call
        this.drawMenu(playerLoc);        
        //draw the map to screen
        MapControl.drawMap();
    }
}
