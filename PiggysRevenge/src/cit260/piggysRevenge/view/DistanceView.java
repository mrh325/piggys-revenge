/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.MapControl;
import cit260.piggysRevenge.model.Actor;
import java.awt.Point;
import static java.lang.Math.abs;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
class DistanceView extends View {

    public DistanceView() {
        
    }

    @Override
    public void display() {
        //Get player location
        Point playerCoords = PiggysRevenge.getCurrentGame().getPlayer().getCoordinates();
        //Get wolf location
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
        //System.out.println("allPoints is:  ");
        //System.out.println(Arrays.toString(allPoints));
        //System.out.println("Player's coords is:  ");
        //System.out.println(playerCoords.toString());
        
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
        //sort lists
        //System.out.println("distances unsorted:  ");
        //System.out.println(Arrays.toString(distances));
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
        //System.out.println("distances sorted:  ");
        //System.out.println(Arrays.toString(distances));
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
    
    @Override
    public boolean doAction(String input1) {
        return false;  
    }
    
}
