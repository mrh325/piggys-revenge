/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hales AND Bolton
 */
public class GameControlTest {
    
    public GameControlTest() {
    }

    /**
     ****L06 Team Assignment ****
     * 
     * Test of calcScore method, of class GameControl.
     */
    @Test
    public void testCalcScore() {
        System.out.println("calcScore");
        System.out.println("Test1 - Valid1");
        int numberOfBricks = 250;
        int numberOfTurns = 35;
        boolean hasEaten = false;
        boolean wolfKilled = false;
        int expResult = 2150;
        int result = GameControl.calcScore(numberOfBricks, numberOfTurns, hasEaten, wolfKilled);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        System.out.println("Test2 - Valid2");
        numberOfBricks = 250;
        numberOfTurns = 35;
        hasEaten = true;
        wolfKilled = false;
        expResult = 3150;
        result = GameControl.calcScore(numberOfBricks, numberOfTurns, hasEaten, wolfKilled);
        assertEquals(expResult, result);

        System.out.println("Test3 - Valid3");
        numberOfBricks = 250;
        numberOfTurns = 35;
        hasEaten = true;
        wolfKilled = true;
        expResult = 5150;
        result = GameControl.calcScore(numberOfBricks, numberOfTurns, hasEaten, wolfKilled);
        assertEquals(expResult, result);
        
        System.out.println("Test4 - invalid1 - numberOfBricks");
        numberOfBricks = -1;
        numberOfTurns = 35;
        hasEaten = true;
        wolfKilled = false;
        expResult = -1;
        result = GameControl.calcScore(numberOfBricks, numberOfTurns, hasEaten, wolfKilled);
        assertEquals(expResult, result);
        
        System.out.println("Test5 - invalid2 - numberOfTurns");
        numberOfBricks = 300;
        numberOfTurns = -5;
        hasEaten = false;
        wolfKilled = false;
        expResult = -2;
        result = GameControl.calcScore(numberOfBricks, numberOfTurns, hasEaten, wolfKilled);
        assertEquals(expResult, result);
        
        System.out.println("Test6 - invalid3 - wolfkilled but not eaten");
        numberOfBricks = 250;
        numberOfTurns = 35;
        hasEaten = false;
        wolfKilled = true;
        expResult = -3;
        result = GameControl.calcScore(numberOfBricks, numberOfTurns, hasEaten, wolfKilled);
        assertEquals(expResult, result);
        
        System.out.println("Test4 - lower boundary - 0 Score");
        numberOfBricks = 0;
        numberOfTurns = 1;
        hasEaten = false;
        wolfKilled = false;
        expResult = 0;
        result = GameControl.calcScore(numberOfBricks, numberOfTurns, hasEaten, wolfKilled);
        assertEquals(expResult, result);
        
    }

    /**
     **** Michael Hales L06 Individual Assignment ****
     * 
     * Test of calcNumberofBricks method, of class GameControl.
     */
    @Test
    public void testCalcNumberofBricks() {
        System.out.println("calcNumberOfBricks");
        System.out.println("Test 1 - Length - Lower Boundary");
        int length = -3;
        int width = 6;
        int height = 10;
        int numberOfStories = 3;
        int expResult;
        expResult = -11;
        int result = GameControl.calcNumberofBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        
        System.out.println("Test 2 - Length - Upper Boundary");
        length = 252;
        width = 6;
        height = 10;
        numberOfStories = 2;
        expResult = -12;
        result = GameControl.calcNumberofBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);

        System.out.println("Test 3 - Width - Lower Boundary");
        length = 7;
        width = -5;
        height = 9;
        numberOfStories = 2;
        expResult = -21;
        result = GameControl.calcNumberofBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        
        System.out.println("Test 4 - Width - Upper Boundary");
        length = 7;
        width = 2323;
        height = 8;
        numberOfStories = 1;
        expResult = -22;
        result = GameControl.calcNumberofBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        
        System.out.println("Test 5 - Height - Lower Boundary");
        length = 13;
        width = 15;
        height = 1;
        numberOfStories = 3;
        expResult = -31;
        result = GameControl.calcNumberofBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        
        System.out.println("Test 1 - Height - Upper Boundary");
        length = 9;
        width = 11;
        height = 15;
        numberOfStories = 2;
        expResult = -32;
        result = GameControl.calcNumberofBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        
        System.out.println("Test 1 - numberOfStories - Lower Boundary");
        length = 14;
        width = 15;
        height = 6;
        numberOfStories = 0;
        expResult = -41;
        result = GameControl.calcNumberofBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        
        System.out.println("Test 1 - numberOfStories - Upper Boundary");
        length = 6;
        width = 18;
        height = 6;
        numberOfStories = 8;
        expResult = -42;
        result = GameControl.calcNumberofBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        
        System.out.println("Valid 1 - Length Boundary");
        length = 20;
        width = 8;
        height = 8;
        numberOfStories = 2;
        expResult = 374;
        result = GameControl.calcNumberofBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        
        System.out.println("Valid 2 - Width Boundary");
        length = 11;
        width = 6;
        height = 8;
        numberOfStories = 2;
        expResult = 207;
        result = GameControl.calcNumberofBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        
        System.out.println("Valid 3 - Height Boundary");
        length = 13;
        width = 15;
        height = 10;
        numberOfStories = 2;
        expResult = 462;
        result = GameControl.calcNumberofBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        
        System.out.println("Valid 4 - numberOfStories Boundary");
        length = 13;
        width = 15;
        height = 8;
        numberOfStories = 3;
        expResult = 556;
        result = GameControl.calcNumberofBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
    }
    
}
