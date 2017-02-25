/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.control;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author natebolton
 */
public class MapControlTest {
    
    public MapControlTest() {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    //BOLTON L06 Individual Assignment - tests CalculateEventProbability()
    /**
     * Test of calculateEventProbability method, of class MapControl.
     */
    @Test
    public void testCalculateEventProbability() {
        System.out.println("calculateEventProbability");
        
        //TEST 1
        System.out.println("TEST 1 - VALID");
        int visitedScenes = 16;
        int totalScenes = 25;
        int visitedEvents = 3;
        int totalEvents = 5;
        double expResult = 2.8;
        double result = MapControl.calculateEventProbability(visitedScenes, totalScenes, visitedEvents, totalEvents);
        assertEquals(expResult, result, 0.0001);

        //TEST 2
        System.out.println("TEST 2 - INVALID -1");
        visitedScenes = 0;
        totalScenes = 25;
        visitedEvents = 0;
        totalEvents = 5;
        expResult = -1;
        result = MapControl.calculateEventProbability(visitedScenes, totalScenes, visitedEvents, totalEvents);
        assertEquals(expResult, result, 0.0001);
        //TEST 3
        System.out.println("TEST 3 - INVALID -1");
        visitedScenes = 1;
        totalScenes = 1;
        visitedEvents = 0;
        totalEvents = 5;
        expResult = -1;
        result = MapControl.calculateEventProbability(visitedScenes, totalScenes, visitedEvents, totalEvents);
        assertEquals(expResult, result, 0.0001);
        //TEST 4
        System.out.println("TEST 4 - INVALID -1");
        visitedScenes = 1;
        totalScenes = 25;
        visitedEvents = -1;
        totalEvents = 5;
        expResult = -1;
        result = MapControl.calculateEventProbability(visitedScenes, totalScenes, visitedEvents, totalEvents);
        assertEquals(expResult, result, 0.0001);
        //TEST 5
        System.out.println("TEST 5 - INVALID -1");
        visitedScenes = 1;
        totalScenes = 25;
        visitedEvents = 0;
        totalEvents = 0;
        expResult = -1;
        result = MapControl.calculateEventProbability(visitedScenes, totalScenes, visitedEvents, totalEvents);
        assertEquals(expResult, result, 0.0001);
        //TEST 6
        System.out.println("TEST 6 - INVALID -2");
        visitedScenes = 26;
        totalScenes = 25;
        visitedEvents = 0;
        totalEvents = 5;
        expResult = -2;
        result = MapControl.calculateEventProbability(visitedScenes, totalScenes, visitedEvents, totalEvents);
        assertEquals(expResult, result, 0.0001);
        //TEST 7
        System.out.println("TEST 7 - INVALID -3");
        visitedScenes = 1;
        totalScenes = 25;
        visitedEvents = 6;
        totalEvents = 5;
        expResult = -3;
        result = MapControl.calculateEventProbability(visitedScenes, totalScenes, visitedEvents, totalEvents);
        assertEquals(expResult, result, 0.0001);
        //TEST 8
        System.out.println("TEST 8 - INVALID -4");
        visitedScenes = 1;
        totalScenes = 101;
        visitedEvents = 0;
        totalEvents = 5;
        expResult = -4;
        result = MapControl.calculateEventProbability(visitedScenes, totalScenes, visitedEvents, totalEvents);
        assertEquals(expResult, result, 0.0001);
        //TEST 9
        System.out.println("TEST 9 - INVALID -5");
        visitedScenes = 1;
        totalScenes = 25;
        visitedEvents = 0;
        totalEvents = 6;
        expResult = -5;
        result = MapControl.calculateEventProbability(visitedScenes, totalScenes, visitedEvents, totalEvents);
        assertEquals(expResult, result, 0.0001);
        //TEST 10
        System.out.println("TEST 10 - BOUNDARY 1.0");
        visitedScenes = 1;
        totalScenes = 2;
        visitedEvents = 0;
        totalEvents = 1;
        expResult = 100.0;
        result = MapControl.calculateEventProbability(visitedScenes, totalScenes, visitedEvents, totalEvents);
        assertEquals(expResult, result, 0.0001);
        //TEST 11
        System.out.println("TEST 11 - BOUNDARY 0.0");
        visitedScenes = 1;
        totalScenes = 100;
        visitedEvents = 0;
        totalEvents = 5;
        expResult = 0.0;
        result = MapControl.calculateEventProbability(visitedScenes, totalScenes, visitedEvents, totalEvents);
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of calcDistance method, of class MapControl.
     */
    //POWELL INDIVIDUAL ASSIGNMENT testCalcdistance
    @Test
    public void testCalcDistance() {
        
        //TEST 1 
        System.out.println("calcDistance TEST1 Valid");
        double startPositionX = 2.0;
        double endPositionX = 3.0;
        double startPositionY = 4.0;
        double endPositionY = 3.0;
        double expResult = 1.4142135623730951;
        double result = MapControl.calcDistance(startPositionX, startPositionY, endPositionX, endPositionY);
        assertEquals(expResult, result, 0.0);
        
         //TEST 2 
        System.out.println("calcDistance TEST2 LESS THAN 1");
        startPositionX = -1.0;
        endPositionX = 2.0;
        startPositionY = 3.0;
        endPositionY = 3.0;
        expResult = -1;
        result = MapControl.calcDistance(startPositionX, startPositionY, endPositionX, endPositionY);
        assertEquals(expResult, result, 0.0);
        
          //TEST 3
        System.out.println("calcDistance TEST3 MORE THAN 5");
        startPositionX = 6.0;
        endPositionX = 3.0;
        startPositionY = 2.0;
        endPositionY = 3.0;
        expResult = -2;
        result = MapControl.calcDistance(startPositionX, startPositionY, endPositionX, endPositionY);
        assertEquals(expResult, result, 0.0);
        
         //TEST 4 
        System.out.println("calcDistance TEST4 BOUNDARY");
        startPositionX = 1.0;
        endPositionX = 5.0;
        startPositionY = 1.0;
        endPositionY = 5.0;
        expResult = 5.656854249492381;
        result = MapControl.calcDistance(startPositionX, startPositionY, endPositionX, endPositionY);
        assertEquals(expResult, result, 0.0);
        
         //TEST 5
        System.out.println("calcDistance TEST5 REVERSE BOUNDARY");
        startPositionX = 5.0;
        endPositionX = 1.0;
        startPositionY = 5.0;
        endPositionY = 1.0;
        expResult = 5.656854249492381;
        result = MapControl.calcDistance(startPositionX, startPositionY, endPositionX, endPositionY);
        assertEquals(expResult, result, 0.0);
     
       }
    
}
