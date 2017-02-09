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
 * @author hales
 */
public class GameControlTest {
    
    public GameControlTest() {
    }

    /**
     * Test of calcScore method, of class GameControl.
     */
    @Test
    public void testCalcScore() {
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
    
}
