/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.MapControl;
import cit260.piggysRevenge.model.Actor;
import cit260.piggysRevenge.model.Location;
import java.awt.Point;
import static java.lang.Math.abs;
import java.util.Arrays;
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
                + "\nU - Calc(U)late number of bricks for the house"
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
            case "U":
                this.displayHouseMenu();
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
        
        MoveMenuView moveMenu = new MoveMenuView();
        moveMenu.display();
    }

    private void displayMap() {
//        System.out.println("\n*** displayMap() function called ***");
        int columns = PiggysRevenge.getCurrentGame().getMap().getColumnCount();
        //get locations and prep an empty line for string building
        Location[][] locations = PiggysRevenge.getCurrentGame().getMap().getLocations();
        String emptyLine = "";
        for (int i = 1; i < columns*5+10; i++ ) {
            emptyLine += " ";
        }

        //draw the title
        StringBuilder line = new StringBuilder(emptyLine);
        String mapTitle = "The Far Away Land of Nonsense";
        //System.out.println(mapTitle.length()/2);
        //System.out.println(line.toString().length()/2);
        line.insert(10, mapTitle);
        System.out.println(line.toString());
        
        //draw a line.
        String aLine = "";
        for (int i = 0; i <= columns*5+10; i++ ) {
            aLine += "–";
        }
        System.out.println(aLine);
        
        //draw column headers
        line = new StringBuilder(emptyLine);
        char ch = 'A';
        for (int insertPoint = 10; insertPoint <= columns*5+9; insertPoint+=5) {
            line.insert(insertPoint,"| " + ch + " |");
            ch++;
        }
        System.out.println(line.toString());
        
        //draw the rows
        for (int currentRow = 1; currentRow <= PiggysRevenge.getCurrentGame().getMap().getRowCount(); currentRow++) {
            line = new StringBuilder(emptyLine);
            line.insert(7,Integer.toString(currentRow) + " ");
            for (int currentColumn = 0; currentColumn < columns; currentColumn++) {
                line.insert(10+currentColumn*5,"|" + locations[currentRow-1][currentColumn].getScene().mapSymbol() + "|");
            }
            System.out.println(line.toString());
        }
        System.out.println("\nKEY:  	. Unvisited");
	System.out.println("	# Visited");
	System.out.println("	@ You (A5)");
	System.out.println("	P Piggy Found");
	System.out.println("	B Building Site Found");
    }

    private void displayDistances() {
        //System.out.println("\n*** displayDistance() function called ***");
        //DistanceView distanceView = new DistanceView();
        //distanceView.display();
        
        //Get player location
        Point playerCoords = PiggysRevenge.getCurrentGame().getPlayer().getCoordinates();
        //Get wolf location
//        try {
//            System.out.println(PiggysRevenge.getCurrentGame().getWolf().getCoordinates().toString());
//        } catch (NullPointerException e) {
//            System.out.println("wolf has no coordinates!");
//        }
        Point wolfCoords = PiggysRevenge.getCurrentGame().getWolf().getCoordinates();
        //Get list of actor coordinates (as Points) in a list from MapControl
        Point[] actorPoints = MapControl.getActorPoints(PiggysRevenge.getCurrentGame().getMap());
        //make new list to add the wolf.
        Point[] allPoints = new Point[actorPoints.length+1];
        int index = 0;
        for (Point point : actorPoints) {
            allPoints[index] = point;
            index++;
        }
        allPoints[index] = wolfCoords;
        System.out.println("allPoints is:  ");
        System.out.println(Arrays.toString(allPoints));
        System.out.println("Player's coords is:  ");
        System.out.println(playerCoords.toString());
        //convert list of points to list of distances from player
        double[] distances = new double[allPoints.length];
        index = 0;
        for (Point point : allPoints) {
            double result = MapControl.calcDistance(playerCoords.x, playerCoords.y, point.x, point.y);
            if (result >= 0) {
                result *= 10.0;
                result = Math.round(result);
                result /= 10.0;
                distances[index] = abs(result);
            } else {
                System.out.println("error in calcDistance function in displayDistances function in GameMenuView class");
            }
            index++;
        }
        //sort list
        System.out.println("distances unsorted:  ");
        System.out.println(Arrays.toString(distances));
        //bubble sort both arrays
        for (int n = 0; n < 5; n++) {
            for (int m = 0; m < 4 - n; m++) {
                if (distances[m] > distances[m + 1]) {
                    Double swapDouble = distances[m];
                    distances[m] = distances[m + 1];
                    distances[m + 1] = swapDouble;
                    Point swapPoint = allPoints[m];
                    allPoints[m] = allPoints[m + 1];
                    allPoints[m + 1] = swapPoint;
                }
            }
        }
        System.out.println("distances sorted:  ");
        System.out.println(Arrays.toString(distances));
        //display sorted List of actors and wolf
        System.out.println("\nSORTED DISTANCES\n");
        StringBuilder line = new StringBuilder("                                         ");
        line.insert(0, "ACTOR");
        line.insert(20, "DISTANCE");
        System.out.println(line.toString());
        index = 0;
        for (Point point : allPoints) {
            line = new StringBuilder("                                         ");
            Actor value = MapControl.getActorFromPoint(point,PiggysRevenge.getCurrentGame().getMap());
            if (value == null) {
                line.insert(0, Integer.toString(index+1) + ":  Wolf");
            } else {
                line.insert(0, Integer.toString(index+1) + ":  " + value);
            }
            line.insert(20, distances[index]);
            System.out.println(line.toString());
            index++;
        }

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
    
}
