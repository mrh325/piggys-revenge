/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.model.HighScore;
import cit260.piggysRevenge.model.Item;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
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
                + "\nN - Print (N)ate's Map Report"
                + "\nP - (P)rint Mike's Inventory Report"
                + "\nH - (H)igh Score List"
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
            case "U":
                this.displayHouseMenu();
                break;
            case "N":
                this.printMapReport();
                break;
            case "H":
                this.displayHighScores();
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
        ScoreView scoreView = new ScoreView(false);
        scoreView.display();
    }


    private void displayHouseMenu() {
        // this.console.println("\n*** displayHouseMenu() function called ***");
        HouseSizeView houseSize = new HouseSizeView();
        houseSize.display();
    }

        private void displayHighScores() {

            HighScore[] highScores;

            File varTmpDir = new File("highscores.txt");

            if (varTmpDir.exists()) {

                try (FileInputStream fips = new FileInputStream("highscores.txt")) {
                    ObjectInputStream input = new ObjectInputStream(fips);

                    highScores = (HighScore[]) input.readObject();
                    PiggysRevenge.getCurrentGame().setHighScores(highScores);
                    HighScoreView highScoreView = new HighScoreView();
                    highScoreView.display();
                } catch (Exception e) {
                    ErrorView.display("GameMenuView", e.getMessage());
                }

            }
            else {
                this.console.println("There are no high scores to display.");
            }
        

    }
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
            out.printf("%n%-5s%-15s%-45s%-10s", "Slot", "Name", "Description", "Item Type");
            out.printf("%n%-5s%-15s%-45s%-10s", "----", "----", "-----------", "---------");
            
            int i = 1;
            for (Item[] inventory1 : inventory) {
                for (Item inventory11 : inventory1) {
                    if (inventory11 == null) {
                        out.printf("%n%-5s%-15s%-45s%-10s", i, "Empty", "Empty", "Empty", "Empty");
                    }
                    else {
                    out.printf("%n%-5s%-15s%-45s%-10s", i, inventory11.getName(), inventory11.getDescription(), inventory11.getItemType());
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
