/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.MapControl;
import cit260.piggysRevenge.exceptions.MapControlException;
import cit260.piggysRevenge.model.HighScore;
import cit260.piggysRevenge.model.House;
import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
public class GameMenuView extends View {

    public GameMenuView() {
        super ("\n"
                + "\n======================================="
                + "\n| Game Menu                           |"
                + "\n======================================="
                + "\nM - (M)ove"
                + "\nS - (S)how Map"
                + "\nD - Show all (D)istances"
                + "\nI - (I)nventory"
                + "\nG - Play the Mini (G)ame!"
                + "\nC - Show s(C)ore"
                + "\nP - Show (P)robability of winning the game"
                + "\nL - Test distance (L)ower bound exception"
                + "\nZ - Test distance upper bound exception"
                + "\nX - Test Nate's NumberException View"
                + "\nU - Calc(U)late number of bricks for the house"
                + "\nH - (H)igh Score list"
                + "\nB - (B)ack to Main Menu"
                + "\n=======================================");
    }
    @Override
    public boolean doAction(String menuOption) {
        // System.out.println("\n*** doAction() function called ***");
        
        menuOption = menuOption.toUpperCase();
        
        switch (menuOption) {
            case "M":
                this.displayMoveMenu();
                break;
            case "S":
                this.displayMap();
                break;
            case "D":
                this.displayDistances();
                break;
            case "I":
                this.displayInventoryMenu();
                break;
            case "G":
                this.displayMiniGameMenu();
                break;
            case "C":
                this.displayScore();
                break;
            case "P":
                this.displayProbability();
                break;
            case "L":
                try {
                    this.displayTestDistanceException();
                } catch (MapControlException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case "Z":
                try {
                    this.displayTestDistanceException2();
                } catch (MapControlException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case "X":
                this.displayL11Exception();
                break;
            case "U":
                this.displayHouseMenu();
                break;
            case "H":
                this.displayHighScores();
                break;
            case "B":
            case "Q":
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again ***");
                break;
        }
        return false;    
    }

    private void displayMoveMenu() {
        Point playerLoc = PiggysRevenge.getCurrentGame().getPlayer().getCoordinates();
        Point wolfLoc = PiggysRevenge.getCurrentGame().getWolf().getCoordinates();
        MoveMenuView moveMenu = new MoveMenuView(playerLoc,wolfLoc);
        moveMenu.display();
    }

    private void displayMap() {
//        System.out.println("\n*** displayMap() function called ***");
        MapControl.drawMap();
    }

    private void displayDistances() {
        //System.out.println("\n*** displayDistance() function called ***");
        DistanceView distanceView = new DistanceView();
        distanceView.display();
        
    }

    private void displayInventoryMenu() {
        //System.out.println("\n*** displayInventory() function called ***");
        //We'll probably pass a backpack object in here.
        InventoryMenuView inventoryMenu = new InventoryMenuView();
        inventoryMenu.display();
    }

    private void displayMiniGameMenu() {
        //System.out.println("\n*** displayMiniGameMenu() function called ***");
        MiniGameMenuView miniGameMenu = new MiniGameMenuView();
        miniGameMenu.display();
    }

    private void displayScore() {
        //System.out.println("\n*** displayScore() function called ***");
        ScoreView scoreView = new ScoreView();
        scoreView.display();
    }

    private void displayProbability() {
        //System.out.println("\n*** displayProbability() function called ***");
        ProbabilityView probabilityView = new ProbabilityView();
        probabilityView.display();
    }

    private void displayHouseMenu() {
        // System.out.println("\n*** displayHouseMenu() function called ***");
        HouseSizeView houseSize = new HouseSizeView();
        houseSize.display();
    }

    private void displayHighScores() {

        ArrayList<HighScore> highScores = PiggysRevenge.getCurrentGame().getHighScores();
        highScores.add(new HighScore("Player1", 900, new House(8,8,8,2)));
        highScores.add(new HighScore("Player2", 78300, new House(19,13,8,3)));
        highScores.add(new HighScore("Player3", 1600, new House(7,8,9,1)));
        
        PiggysRevenge.getCurrentGame().setHighScores(highScores);
        
        HighScoreView highScoreView = new HighScoreView();
        highScoreView.display();
    }

    private void displayTestDistanceException() throws MapControlException {
        MapControl.calcDistance(-1, 4, 2, 3);
        
    }

    private void displayTestDistanceException2() throws MapControlException {
        MapControl.calcDistance(2, 125, 2, 3);
    }

    private void displayL11Exception() {
        L11View l11view = new L11View();
        l11view.display();
    }
    
}
