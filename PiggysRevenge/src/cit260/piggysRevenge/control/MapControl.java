/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.control;

import cit260.piggysRevenge.model.Map;
import cit260.piggysRevenge.model.Scene;

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
        
        Map map = new Map (7, 7);
        
        Scene[] scenes = createScenes();
        
        GameControl.assignScenesToLocations(map, scenes);
        return map;
    }

    private static Scene[] createScenes() {
        // System.out.println("*** Scene function called***");
        
        Scene[] scenes = new Scene[SceneType.values().length];
        
        Scene startingScene = new Scene();
        startingScene.setDescription("Yay, you're at the beginning");
        startingScene.setMapSymbol(" P ");
        scenes[SceneType.start.ordinal()] = startingScene;
        
        for (int i = 1; i < SceneType.values().length; i++) {
            Scene randomScene = new Scene();
            randomScene.setDescription("Yay, you're at random location" + i);
            randomScene.setMapSymbol(" ? ");
            scenes[i] = randomScene;
        }
        return scenes;
    }
}