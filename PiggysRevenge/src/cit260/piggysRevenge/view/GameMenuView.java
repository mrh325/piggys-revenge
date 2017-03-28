/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.model.HighScore;
import cit260.piggysRevenge.model.House;
import cit260.piggysRevenge.model.Item;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.lang.String;
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
                + "\nC - Show s(C)ore"
                + "\nH - (H)igh Score list"
                + "\nN - Print (N)ate's Map Report"
                + "\nP - (P)rint Mike's Inventory Report"
                + "\nB - (B)ack to Main Menu"
                + "\n=======================================");
    }
    @Override
    public boolean doAction(String menuOption) {
        // this.console.println("\n*** doAction() function called ***");
        
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
            case "C":
                this.displayScore();
                break;
            case "P":
        {
            try {
                this.printInventoryReport();
            } catch (FileNotFoundException ex) {
                this.console.print(ex.getMessage());
            }
        }
                break;
//            case "L":
//                try {
//                    this.displayTestDistanceException();
//                } catch (MapControlException ex) {
//                    this.console.println(ex.getMessage());
//                }
//                break;
//            case "Z":
//                try {
//                    this.displayTestDistanceException2();
//                } catch (MapControlException ex) {
//                    this.console.println(ex.getMessage());
//                }
//                break;
            case "U":
                this.displayHouseMenu();
                break;
            case "H":
                this.displayHighScores();
                break;
            case "N":
                this.printMapReport();
                break;
            case "B":
            case "Q":
                return true;
            default:
                this.console.println("\n*** Invalid selection *** Try again ***");
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
//        this.console.println("\n*** displayMap() function called ***");
        MapView mapView = new MapView();
        mapView.display();
        //MapControl.drawMap();
    }

    private void displayDistances() {
        //this.console.println("\n*** displayDistance() function called ***");
        DistanceView distanceView = new DistanceView();
        distanceView.display();
        
    }

    private void displayInventoryMenu() {
        //this.console.println("\n*** displayInventory() function called ***");
        //We'll probably pass a backpack object in here.
        InventoryMenuView inventoryMenu = new InventoryMenuView();
        inventoryMenu.display();
    }

    private void displayScore() {
        //this.console.println("\n*** displayScore() function called ***");
        ScoreView scoreView = new ScoreView();
        scoreView.display();
    }

//    private void displayProbability() {
//        //this.console.println("\n*** displayProbability() function called ***");
//        ProbabilityView probabilityView = new ProbabilityView();
//        probabilityView.display();
//    }
//
    private void displayHouseMenu() {
        // this.console.println("\n*** displayHouseMenu() function called ***");
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


//    private void displayTestDistanceException() throws MapControlException {
//        MapControl.calcDistance(-1, 4, 2, 3);
//        
//    }
//
//    private void displayTestDistanceException2() throws MapControlException {
//        MapControl.calcDistance(2, 125, 2, 3);
//    }
//

    private void printMapReport() {
        MapReportView mapReportView = new MapReportView();
        mapReportView.display();
    }
    

    private void printInventoryReport() throws FileNotFoundException {
        
        this.displayMessage = "\n\nEnter the name of the file to be saved.";
        
        String outputLocation = this.getInput();
        Item[][] inventory = PiggysRevenge.getCurrentGame().getBackpack().getItemList();
        
        try (PrintWriter out = new PrintWriter(outputLocation)) {
            out.println("\n\n             Inventory Report             ");
            out.printf("%n%-10s%20s%10s%10s", "Slot", "Description", "Name", "Item Type");
            out.printf("%n%-10s%20s%10s%10s", "----", "-----------", "----", "---------");
            
            int i = 1;
            for (Item[] inventory1 : inventory) {
                for (Item inventory11 : inventory1) {
                    if (inventory11 == null) {
                        out.printf("%n%-10s%20s%10s%10s", i, "Empty", "Empty", "Empty", "Empty");
                    }
                    else {
                    out.printf("%n%-10s%20s%10s%10s", i, inventory11.getDescription(), inventory11.getName(), inventory11.getItemType());
                    }
                    i++;
                }
            }
            this.console.print("\nReport saved to "+ outputLocation + " successfully.");
    }
        catch (IOException ex) {
                ErrorView.display("GameMenuView", ex.getMessage());
        }
        finally {
            this.displayMessage = "\n"
                + "\n======================================="
                + "\n| Game Menu                           |"
                + "\n======================================="
                + "\nM - (M)ove"
                + "\nS - (S)how Map"
                + "\nD - Show all (D)istances"
                + "\nI - (I)nventory"
                + "\nC - Show s(C)ore"
                + "\nH - (H)igh Score list"
                + "\nN - Print (N)ate's Map Report"
                + "\nP - (P)rint Mike's Inventory Report"
                + "\nB - (B)ack to Main Menu"
                + "\n=======================================";
        }

}

}
