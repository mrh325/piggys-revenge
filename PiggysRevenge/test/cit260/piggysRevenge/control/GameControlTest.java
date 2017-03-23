/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.control;

import cit260.piggysRevenge.exceptions.GameControlException;
import cit260.piggysRevenge.view.ErrorView;
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
    public void testCalcScore() throws GameControlException {
        ErrorView.display(GameControlTest.class.getName(), "calcScore");
        ErrorView.display(GameControlTest.class.getName(), "Test1 - Valid1");
        int numberOfBricks = 250;
        int numberOfTurns = 35;
        boolean hasEaten = false;
        boolean wolfKilled = false;
        int expResult = 2150;
        int result = GameControl.calcScore(numberOfBricks, numberOfTurns, hasEaten, wolfKilled);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        ErrorView.display(GameControlTest.class.getName(), "Test2 - Valid2");
        numberOfBricks = 250;
        numberOfTurns = 35;
        hasEaten = true;
        wolfKilled = false;
        expResult = 3150;
        result = GameControl.calcScore(numberOfBricks, numberOfTurns, hasEaten, wolfKilled);
        assertEquals(expResult, result);

        ErrorView.display(GameControlTest.class.getName(), "Test3 - Valid3");
        numberOfBricks = 250;
        numberOfTurns = 35;
        hasEaten = true;
        wolfKilled = true;
        expResult = 5150;
        result = GameControl.calcScore(numberOfBricks, numberOfTurns, hasEaten, wolfKilled);
        assertEquals(expResult, result);
        
        ErrorView.display(GameControlTest.class.getName(), "Test4 - invalid1 - numberOfBricks");
        numberOfBricks = -1;
        numberOfTurns = 35;
        hasEaten = true;
        wolfKilled = false;
        expResult = -1;
        result = GameControl.calcScore(numberOfBricks, numberOfTurns, hasEaten, wolfKilled);
        assertEquals(expResult, result);
        
        ErrorView.display(GameControlTest.class.getName(), "Test5 - invalid2 - numberOfTurns");
        numberOfBricks = 300;
        numberOfTurns = -5;
        hasEaten = false;
        wolfKilled = false;
        expResult = -2;
        result = GameControl.calcScore(numberOfBricks, numberOfTurns, hasEaten, wolfKilled);
        assertEquals(expResult, result);
        
        ErrorView.display(GameControlTest.class.getName(), "Test6 - invalid3 - wolfkilled but not eaten");
        numberOfBricks = 250;
        numberOfTurns = 35;
        hasEaten = false;
        wolfKilled = true;
        expResult = -3;
        result = GameControl.calcScore(numberOfBricks, numberOfTurns, hasEaten, wolfKilled);
        assertEquals(expResult, result);
        
        ErrorView.display(GameControlTest.class.getName(), "Test4 - lower boundary - 0 Score");
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
    public void testCalcNumberOfBricks() throws GameControlException {
        ErrorView.display(GameControlTest.class.getName(), "calcNumberOfBricks");
        ErrorView.display(GameControlTest.class.getName(), "Test 1 - Length - Invalid");
        int length = -3;
        int width = 6;
        int height = 10;
        int numberOfStories = 3;
        int expResult;
        expResult = -11;
        int result = GameControl.calcNumberOfBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        
        ErrorView.display(GameControlTest.class.getName(), "Test 2 - Length - Invalid");
        length = 252;
        width = 6;
        height = 10;
        numberOfStories = 2;
        expResult = -12;
        result = GameControl.calcNumberOfBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);

        ErrorView.display(GameControlTest.class.getName(), "Test 3 - Width - Invalid");
        length = 7;
        width = -5;
        height = 9;
        numberOfStories = 2;
        expResult = -21;
        result = GameControl.calcNumberOfBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        
        ErrorView.display(GameControlTest.class.getName(), "Test 4 - Width - Invalid");
        length = 7;
        width = 2323;
        height = 8;
        numberOfStories = 1;
        expResult = -22;
        result = GameControl.calcNumberOfBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        
        ErrorView.display(GameControlTest.class.getName(), "Test 5 - Height - Invalid");
        length = 13;
        width = 15;
        height = 1;
        numberOfStories = 3;
        expResult = -31;
        result = GameControl.calcNumberOfBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        
        ErrorView.display(GameControlTest.class.getName(), "Test 6 - Height - Invalid");
        length = 9;
        width = 11;
        height = 15;
        numberOfStories = 2;
        expResult = -32;
        result = GameControl.calcNumberOfBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        
        ErrorView.display(GameControlTest.class.getName(), "Test 7 - numberOfStories - Invalid");
        length = 14;
        width = 15;
        height = 6;
        numberOfStories = 0;
        expResult = -41;
        result = GameControl.calcNumberOfBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        
        ErrorView.display(GameControlTest.class.getName(), "Test 8 - numberOfStories - Invalid");
        length = 6;
        width = 18;
        height = 6;
        numberOfStories = 8;
        expResult = -42;
        result = GameControl.calcNumberOfBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        
        ErrorView.display(GameControlTest.class.getName(), "Test 9 - Valid 1");
        length = 20;
        width = 8;
        height = 8;
        numberOfStories = 2;
        expResult = 374;
        result = GameControl.calcNumberOfBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        
        ErrorView.display(GameControlTest.class.getName(), "Test 10 - Valid 2");
        length = 13;
        width = 15;
        height = 8;
        numberOfStories = 3;
        expResult = 556;
        result = GameControl.calcNumberOfBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        
        ErrorView.display(GameControlTest.class.getName(), "Test 11 - Width Lower Boundary");
        length = 11;
        width = 6;
        height = 8;
        numberOfStories = 2;
        expResult = 207;
        result = GameControl.calcNumberOfBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        
        ErrorView.display(GameControlTest.class.getName(), "Test 12 - Height Upper Boundary");
        length = 13;
        width = 15;
        height = 10;
        numberOfStories = 2;
        expResult = 462;
        result = GameControl.calcNumberOfBricks(length, width, height, numberOfStories);
        assertEquals(expResult, result);
        

    }
    
}
