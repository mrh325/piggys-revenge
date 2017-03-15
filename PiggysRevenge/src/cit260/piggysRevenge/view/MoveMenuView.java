/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.MapControl;
import cit260.piggysRevenge.exceptions.MapControlException;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;


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
        {
            try {
                this.moveUp();
            } catch (MapControlException ex) {
                System.out.println("Error moving up.");
            }
        }
                break;
            case "D":
        {
            try {
                this.moveDown();
            } catch (MapControlException ex) {
                System.out.println("Error moving down.");
            }
        }
                break;
            case "L":
        {
            try {
                this.moveLeft();
            } catch (MapControlException ex) {
                System.out.println("Error moving left.");
            }
        }
                break;
            case "R":
        {
            try {
                this.moveRight();
            } catch (MapControlException ex) {
                System.out.println("Error moving right.");
            }
        }
                break;
            case "M":
                this.displayMap();
                break;
            case "B":
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again ***");
                break;
        }
        return false;
    }

    private void moveUp() throws MapControlException {
        //System.out.println("\n*** moveUp() function called ***");
        //move the player's location
        MapControl.movePlayer(playerLoc,"up");
        this.doAfterMove(playerLoc,wolfLoc);
    }

    private void moveDown() throws MapControlException {
        //System.out.println("\n*** moveDown() function called ***");
        MapControl.movePlayer(playerLoc,"down");
        this.doAfterMove(playerLoc,wolfLoc);
    }

    private void moveLeft() throws MapControlException {
        //System.out.println("\n*** moveLeft() function called ***");
        MapControl.movePlayer(playerLoc,"left");
        this.doAfterMove(playerLoc,wolfLoc);
    }

    private void moveRight() throws MapControlException {
        //System.out.println("\n*** moveRight() function called ***");
        MapControl.movePlayer(playerLoc,"right");
        this.doAfterMove(playerLoc,wolfLoc);
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
        } else {
            this.displayMessage += "\n  -";
        }
        if (playerLoc.x != 6) {
            this.displayMessage += "\nD - (D)own";
        } else {
            this.displayMessage += "\n  -";
        }
        if (playerLoc.y != 0) {
            this.displayMessage += "\nL - (L)eft";
        } else {
            this.displayMessage += "\n  -";
        }
        if (playerLoc.y != 6) {
            this.displayMessage += "\nR - (R)ight";
        } else {
            this.displayMessage += "\n  -";
        }
        this.displayMessage += "\nM - Display the (M)ap"
                + "\nB - (B)ack to Main Menu"
                + "\n=======================================";   
    }
    
    private void doAfterMove(Point playerLoc,Point wolfLoc) {
        
        //move the wolf
        MapControl.moveWolf(wolfLoc);
        
        //check for wolf-player collision
        if (playerLoc.x == wolfLoc.x && playerLoc.y == wolfLoc.y) {
            WolfView wolfView = new WolfView();
            wolfView.display();
        } else {
            System.out.println("playerLoc and WolfLoc");
            System.out.println(playerLoc);
            System.out.println(wolfLoc);            
        }
        
        //check for actor-player collision
        MapControl.checkUnvisitedActorCollision(playerLoc);
        //check for item-player collision
        MapControl.checkItemCollision(playerLoc);
        //check for bricks-player collision
        
        //redefine the menu for the next display() call
        this.drawMenu(playerLoc);        
        //draw the map to screen
        MapControl.drawMap();
    }
}
