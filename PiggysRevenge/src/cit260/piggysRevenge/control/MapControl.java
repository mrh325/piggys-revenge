/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.control;

/**
 *
 * @author natebolton
 */
public class MapControl {
    
    public static double calculateEventProbability(int visitedScenes, int totalScenes, int visitedEvents, int totalEvents) {

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

        //avoid division by zero
        if (totalScenes - visitedScenes == totalEvents - visitedEvents) {
            return 1.0;
        }

        double probability = 1.0;

        //loop through a range from 0 to the number of unvisited events, calculating probability for discovering/visiting one event per turn until all events are visited
        for ( int i=0; i < totalEvents - visitedEvents; i++) {
            probability *= 1.0 / (totalScenes - visitedScenes - i);
        }
        
        //round and multiply by 100 to get percent
        probability *= 1000;
        probability = (double)Math.round(probability);
        probability /= 10;
        return probability;

    }

    
}
