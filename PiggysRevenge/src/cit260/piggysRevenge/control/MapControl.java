/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.control;

import cit260.piggysRevenge.model.Actor;
import cit260.piggysRevenge.model.Location;
import cit260.piggysRevenge.model.SceneType;
import cit260.piggysRevenge.model.Map;
import cit260.piggysRevenge.model.Scene;
import java.awt.Point;
import java.util.Random;

/**
 *
 * @author natebolton
 */
public class MapControl {
    //L06 BOLTON INDIVIDUAL ASSIGNMENT
    public static double calculateEventProbability(double visitedScenes, double totalScenes, double visitedEvents, double totalEvents) {

        if (visitedScenes < 1 || totalScenes < 2 || visitedEvents < 0 || totalEvents < 1) {
            return -1;
        }
        if (visitedScenes > totalScenes) {
            return -2;
        }
        if (visitedEvents > totalEvents) {
            return -3;
        }
        if (totalScenes > 100) {
            return -4;
        }
        if (totalEvents > 5) {
            return -5;
        }
        if ((totalScenes - visitedScenes) < (totalEvents - visitedEvents)) {
            return -6;
        }

        //avoid division by zero
        if (totalScenes - visitedScenes == totalEvents - visitedEvents) {
            return 100.0;
        }

        double probability = 1.0;

        //loop through a range from 0 to the number of unvisited events, calculating probability for discovering/visiting one event per turn until all events are visited
        for ( double i=0; i < totalEvents - visitedEvents; i++) {
            double a = totalEvents - visitedEvents - i;
            double b = totalScenes - visitedScenes - i;
            probability *= a/b;
        }
        
        //round and multiply by 100 to get percent
        probability *= 1000;
        probability = (double)Math.round(probability);
        probability /= 10.0;
        return probability;

    }


    //L06 INDIVIDUAL ASSIGNMENT ZAC POWELL
    public static double calcDistance(double startPositionX, double startPositionY, double endPositionX, double endPositionY){

        if (startPositionX < 1 || endPositionX < 1 || startPositionY < 1 || endPositionY < 1){
                return -1;
        }
        if (startPositionX > 5 || startPositionY > 5 || endPositionX > 5 || endPositionY > 5){
                return -2;
        }

        return Math.sqrt( (startPositionX - endPositionX) * (startPositionX - endPositionX) + (startPositionY-endPositionY) * (startPositionY-endPositionY) );

    }

    public static Map createMap() {
        // System.out.println("*** createMap() called ***");
        
        Map map = new Map(7, 7);
        
        Scene[] scenes = createScenes();
        
        GameControl.assignScenesToLocations(map, scenes);
        return map;
    }

    private static Scene[] createScenes() {
        // System.out.println("*** Scene function called***");
        
        Scene[] scenes = new Scene[SceneType.values().length];
        
        Scene startingScene = new Scene();
        startingScene.setName("Starting Scene");
        startingScene.setDescription("Yay, you're at the beginning");
        startingScene.setMapSymbol(" P ");
        scenes[SceneType.start.ordinal()] = startingScene;
        
        //for (int i = 1; i < SceneType.values().length; i++) {
        Scene randomScene = new Scene();
        randomScene.setName("The desert");
        randomScene.setDescription("You are in the middle of barren, lifeless desert."
                + "\nWater lost to evaporation and transpiration here"
                + "\nexceeds the amount of precipitation...");
        randomScene.setMapSymbol(" . ");
        scenes[SceneType.desert.ordinal()] = randomScene;
        
        randomScene = new Scene();
        randomScene.setName("The forest");
        randomScene.setDescription("You are in a busy, dense forest.");
        randomScene.setMapSymbol(" . ");
        scenes[SceneType.forest.ordinal()] = randomScene;
        
        randomScene = new Scene();
        randomScene.setName("The Old Mill");
        randomScene.setDescription("You are at the old mill.  Rumor is there may"
                + "\nbe gold buried in the foundation...");
        randomScene.setMapSymbol(" . ");
        scenes[SceneType.mill.ordinal()] = randomScene;
        
        randomScene = new Scene();
        randomScene.setName("The grassy field");
        randomScene.setDescription("You are in huge field of grass.");
        randomScene.setMapSymbol(" . ");
        scenes[SceneType.grassyField.ordinal()] = randomScene;
        
        randomScene = new Scene();
        randomScene.setName("The valley");
        randomScene.setDescription("You are in a millenia old valley carved by ancient glaciers.");
        randomScene.setMapSymbol(" . ");
        scenes[SceneType.valley.ordinal()] = randomScene;
        
        randomScene = new Scene();
        randomScene.setName("The river");
        randomScene.setDescription("You'r at the edge of a swift and violent river.");
        randomScene.setMapSymbol(" . ");
        scenes[SceneType.river.ordinal()] = randomScene;
        
        randomScene = new Scene();
        randomScene.setName("The rocky cliffs");
        randomScene.setDescription("You are at the rocky cliffs, hundreds of feet above the cliff floors."
                + "\nDon't fall off.");
        randomScene.setMapSymbol(" . ");
        scenes[SceneType.rockyCliffs.ordinal()] = randomScene;
        
        randomScene = new Scene();
        randomScene.setName("The frozen tundra");
        randomScene.setDescription("You are at the frozen tundra, with reindeer, and ice...");
        randomScene.setMapSymbol(" . ");
        scenes[SceneType.frozenTundra.ordinal()] = randomScene;
        
        randomScene = new Scene();
        randomScene.setName("The beach");
        randomScene.setDescription("You are the beach!  Relax.");
        randomScene.setMapSymbol(" . ");
        scenes[SceneType.beach.ordinal()] = randomScene;
        
        randomScene = new Scene();
        randomScene.setName("The ancient canyons");
        randomScene.setDescription("You are deep down in the canyons.  The ancients made their homes here.");
        randomScene.setMapSymbol(" . ");
        scenes[SceneType.canyons.ordinal()] = randomScene;
        //}
        return scenes;
    }

    static void moveActorsToStartingLocation(Map map) {
        // System.out.println("*** assignScenesToLocations called ***");
        //pick random, unique locations for actors and assign the actor to those locations.
        Location[][] locations = map.getLocations();
        Point[] tempPoints = new Point[Actor.values().length];

        Random rand = new Random();
        boolean pickNewLocation = true;
        Point point;
        int point1, point2;
        //for each of the actors in Actor...
        for (int i = 0; i < tempPoints.length; i++) {
            do {
                //pick a random row
                point1 = 3;
                while (point1 == 3) {
                    point1 = rand.nextInt(map.getRowCount());
                }
                //pick a random column
                point2 = 3;
                while (point2 == 3) {
                    point2 = rand.nextInt(map.getColumnCount());
                }
                //if not the starting point, create a point
                point = new Point(point1,point2);

                //check to make sure the point is unique
                for (Point temp : tempPoints) {
                    if (temp==null) {
                        pickNewLocation = false;
                        break;
                    } else if (temp.equals(point)) {
                        break;
                    } else {
                        pickNewLocation = false;
                    }
                }
            } while (pickNewLocation);
            //if unique, add to the temp array for checking later points
            tempPoints[i] = point;
            //and assign the next actor in the Actor class to the chosen location.
            locations[point1][point2].setActor(Actor.values()[i]);
        }
    }

}