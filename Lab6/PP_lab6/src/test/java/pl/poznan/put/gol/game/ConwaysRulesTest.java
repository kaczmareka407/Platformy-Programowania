/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.gol.game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pl.poznan.put.gol.game.ConwaysRules;

/**
 *
 * @author user
 */
public class ConwaysRulesTest
{
    
    public ConwaysRulesTest()
    {
    }
    
    @BeforeAll
    public static void setUpClass()
    {
    }
    
    @AfterAll
    public static void tearDownClass()
    {
    }
    
    @BeforeEach
    public void setUp()
    {
    }
    
    @AfterEach
    public void tearDown()
    {
    }

    /**
     * Test of inNextGeneration method, of class ConwaysRules.
     */
    @Test
    public void testInNextGeneration()
    {
        System.out.println("inNextGeneration");
        boolean alive = false;
        int numberOfNeighbors = 0;
        ConwaysRules instance = new ConwaysRules();
        boolean expResult = false;
        boolean result = instance.inNextGeneration(alive, numberOfNeighbors);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
