/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dominio.Posicion;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class ServiciosComedorTest {
    
    public ServiciosComedorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class ServiciosComedor.
     */
    @Test
    public void testUpdate() {
        System.out.println("habilitando configuracion del comedor");
        Posicion p = null;
        ServiciosComedor instance = null;
        instance.update(p);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
