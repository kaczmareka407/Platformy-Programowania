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
import pl.poznan.put.gol.game.Cells;
import pl.poznan.put.gol.game.ConwaysCell;

/**
 *
 * @author user
 */
public class ConwaysCellTest
{

   /* public ConwaysCellTest()
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
     * Test of neighbors method, of class ConwaysCell.
     */
    /*@Test
    public void testNeighbors()
    {
        System.out.println("neighbors");
        ConwaysCell instance = null;
        Cells expResult = null;
        Cells result = instance.neighbors();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ConwaysCell.
     */
   /* @Test
    public void testToString()
    {
        System.out.println("toString");
        ConwaysCell instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
//Zadanie 1
    //zwracającą zbiór komórek sąsiadujących z daną komórką
    @Test

    void TestNeighbors()
    {
        System.out.println("neighbors");
        ConwaysCell instance = new ConwaysCell(0, 0);
        Cells expResult = new Cells();
        for (int i = 0; i <= 2; i++)
        {
            for (int j = 0; j <= 2; j++)
            {
                ConwaysCell neighborCC = new ConwaysCell(i, j);
                if (!instance.equals(neighborCC))
                {
                    expResult.add(instance);
                }
            }
        }
        Cells result = instance.neighbors();
        assertEquals(expResult, result);

    }

    //sprawdzającą czy dwa obiekty reprezentują tą samą komórkę.
    @Test
    void TestEquals()
    {
        System.out.println("equals");
        ConwaysCell instance = new ConwaysCell(0, 0);
        ConwaysCell expResult = new ConwaysCell(0, 0);
        
        assertEquals(expResult, instance);
    }

}
