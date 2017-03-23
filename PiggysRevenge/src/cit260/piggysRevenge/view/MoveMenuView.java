/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.MapControl;
import cit260.piggysRevenge.exceptions.MapControlException;
import java.awt.Point;
import piggysrevenge.PiggysRevenge;


public class MoveMenuView extends View {
    Point playerLoc;
    Point wolfLoc;
    boolean freeTurn = false;
    
    public MoveMenuView(Point playerLoc, Point wolfLoc) {
        super ();
        this.playerLoc = playerLoc;
        this.wolfLoc = wolfLoc;
        MapControl.drawMap();
        this.drawMenu(playerLoc);
    }
    
//    public void display(boolean doOnce) {
//        // this.console.println("\n*** display() function called ***");
//        this.doOnce = doOnce;
//        boolean done = false;
//        do {
//            // this.console.println(this.menu);
//            String value = this.getInput();
//            if (value.toUpperCase().equals("Q")) {
//                return;
//            }
//
//            done = this.doAction(value);
//
//        } while (!done);
//
//    }

    @Override
    public boolean doAction(String menuOption) {
              // this.console.println("\n*** doAction() function called ***");
        
        menuOption = menuOption.toUpperCase();
        
        switch (menuOption) {
            case "U":
        {
            try {
                this.moveUp();
            } catch (MapControlException ex) {
                this.console.println(ex.getMessage());
            }
        }
                break;
            case "D":
        {
            try {
                this.moveDown();
            } catch (MapControlException ex) {
                this.console.println(ex.getMessage());
            }
        }
                break;
            case "L":
        {
            try {
                this.moveLeft();
            } catch (MapControlException ex) {
                this.console.println(ex.getMessage());
            }
        }
                break;
            case "R":
        {
            try {
                this.moveRight();
            } catch (MapControlException ex) {
                this.console.println(ex.getMessage());
            }
        }
                break;
            case "M":
                this.displayMap();
                break;
            case "B":
                return true;
            default:
                this.console.println("\n*** Invalid selection *** Try again ***");
                break;
        }
        return false;
    }

    private void moveUp() throws MapControlException {
        //this.console.println("\n*** moveUp() function called ***");
        //move the player's location
        MapControl.movePlayer(playerLoc,"up");
        if (PiggysRevenge.getCurrentGame().getPlayer().getCurrentShoes() != null) {
            this.freeTurn = !("Sneakers".equals(PiggysRevenge.getCurrentGame().getPlayer().getCurrentShoes().getName()) && this.freeTurn);
        }
        this.doAfterMove(playerLoc,wolfLoc);
    }

    private void moveDown() throws MapControlException {
        //this.console.println("\n*** moveDown() function called ***");
        MapControl.movePlayer(playerLoc,"down");
        if (PiggysRevenge.getCurrentGame().getPlayer().getCurrentShoes() != null) {
            this.freeTurn = !("Sneakers".equals(PiggysRevenge.getCurrentGame().getPlayer().getCurrentShoes().getName()) && this.freeTurn);
        }
        this.doAfterMove(playerLoc,wolfLoc);
    }

    private void moveLeft() throws MapControlException {
        //this.console.println("\n*** moveLeft() function called ***");
        MapControl.movePlayer(playerLoc,"left");
        if (PiggysRevenge.getCurrentGame().getPlayer().getCurrentShoes() != null) {
            this.freeTurn = !("Sneakers".equals(PiggysRevenge.getCurrentGame().getPlayer().getCurrentShoes().getName()) && this.freeTurn);
        }
        this.doAfterMove(playerLoc,wolfLoc);
    }

    private void moveRight() throws MapControlException {
        //this.console.println("\n*** moveRight() function called ***");
        MapControl.movePlayer(playerLoc,"right");
        if (PiggysRevenge.getCurrentGame().getPlayer().getCurrentShoes() != null) {
            this.freeTurn = !("Sneakers".equals(PiggysRevenge.getCurrentGame().getPlayer().getCurrentShoes().getName()) && this.freeTurn);
        }
        this.doAfterMove(playerLoc,wolfLoc);
    }

    private void displayMap() {
//        this.console.println("\n*** displayMap() function called ***");
        this.console.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        MapControl.drawMap();
    }
    
    private void drawMenu(Point playerLoc) {
        int turnsRemaining = PiggysRevenge.getCurrentGame().getTurnsRemaining();
        this.displayMessage = "";
        if (turnsRemaining > -1) {
            if (turnsRemaining == 0) {
                EndGameView endGameView = new EndGameView();
                endGameView.display();
            }
            this.displayMessage += "You have " + turnsRemaining + " turns remaining.";
        }
        this.displayMessage += "\n"
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
                + "\nB - (B)ack to Game Menu"
                + "\n=======================================";   
    }
    
    private void doAfterMove(Point playerLoc,Point wolfLoc) {
        
        //move the wolf
        this.console.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        if (PiggysRevenge.getCurrentGame().getPlayer().getCurrentShoes() != null) {
            if ("Sneakers".equals(PiggysRevenge.getCurrentGame().getPlayer().getCurrentShoes().getName()) && this.freeTurn) {
                this.console.println("You're Wearing Sneakers --> The wolf didn't move this turn.");
            } else {
                this.console.println("The Wolf moved.");
                MapControl.moveWolf(wolfLoc);                
            }
        } else {
                this.console.println("The Wolf moved.");
                MapControl.moveWolf(wolfLoc);                
        }
        //check for wolf-player collision
        if (playerLoc.x == wolfLoc.x && playerLoc.y == wolfLoc.y) {
            WolfView wolfView = new WolfView();
            wolfView.display();
        } //else {
//            this.console.println("playerLoc and WolfLoc");
//            this.console.println(playerLoc);
//            this.console.println(wolfLoc);            
//        }
        
        //check for actor-player collision
        MapControl.checkUnvisitedActorCollision(playerLoc);
        //check for item-player collision
        MapControl.checkItemCollision(playerLoc);
        //check for bricks-player collision
        MapControl.checkBrickCollection(playerLoc);
        
        //redefine the menu for the next display() call
        this.drawMenu(playerLoc);        
        //draw the map to screen
        MapControl.drawMap();
    }
}
