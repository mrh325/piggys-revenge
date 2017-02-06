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
 * @author natebolton
 */
public class MiniGameControlTest {
    
    public MiniGameControlTest() {
    }

    /**
     * Test of generateComboOrder method, of class MiniGameControl.
     */
    @Test
    public void testGenerateComboOrder_String_long() {
        System.out.println("generateComboOrder");
        
        //TEST 1
        System.out.println("TEST 1 - VALID");
        String inputKeyOrder = "1234";
        long randSeed = 1L;
        String expResult = "2431";
        String result = MiniGameControl.generateComboOrder(inputKeyOrder, randSeed);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        //TEST 2
        System.out.println("TEST 2 EMPTY STRING");        
        inputKeyOrder = "";
        randSeed = 1L;
        expResult = "";
        result = MiniGameControl.generateComboOrder(inputKeyOrder, randSeed);
        assertEquals(expResult, result);
        
        //TEST 3
        System.out.println("TEST 2 LARGE STRING");        
        inputKeyOrder = "Stack Overflow is a community of 6.7 million programmers, just like you, helping each other. Join them; it only takes a minute:";
        randSeed = 1L;
        expResult = "i lichmklyuiimgoJts et6n ptu7eekpis nrenna y.yrochlf o tv l k;ofl a e:Stsmm aoiouoo mmec,snrtilmteaeOj irwg.a  hhunir, eo t  a ";
        result = MiniGameControl.generateComboOrder(inputKeyOrder, randSeed);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkKeyOrder method, of class MiniGameControl.
     */
    @Test
    public void testCheckKeyOrder() {
        System.out.println("checkKeyOrder");
        
        //TEST 1
        System.out.println("TEST 1 VALID"); 
        String playerOrder = "4321";
        String systemOrder = "4321";
        int expResult = 4;
        int result = MiniGameControl.checkKeyOrder(playerOrder, systemOrder);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");

        //TEST 2
        System.out.println("TEST 2 INVALID EMPTY STRINGS"); 
        playerOrder = "";
        systemOrder = "";
        expResult = -1;
        result = MiniGameControl.checkKeyOrder(playerOrder, systemOrder);
        assertEquals(expResult, result);        

        //TEST 3
        System.out.println("TEST 3 INVALID NOT SAME LENGTH"); 
        playerOrder = "54321";
        systemOrder = "4321";
        expResult = -2;
        result = MiniGameControl.checkKeyOrder(playerOrder, systemOrder);
        assertEquals(expResult, result);

        //TEST 4
        System.out.println("TEST 4 INVALID NOT SAME LENGTH, DIFFERENT CHARACTER COUNT"); 
        playerOrder = "4421";
        systemOrder = "54321";
        expResult = -2;
        result = MiniGameControl.checkKeyOrder(playerOrder, systemOrder);
        assertEquals(expResult, result);
        
        //TEST 5
        System.out.println("TEST 5 INVALID SAME LENGTH, DIFFERENT CHARACTER COUNT"); 
        playerOrder = "4421";
        systemOrder = "4321";
        expResult = -3;
        result = MiniGameControl.checkKeyOrder(playerOrder, systemOrder);
        assertEquals(expResult, result);
        

    }
    
}
