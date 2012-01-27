/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sensado;

import shell.Kernel;
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
public class SensingConsernTest 
{
    private static SensingConsern instance;
    
    public SensingConsernTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception 
    {
        instance = new SensingConsern(new Kernel());
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
     * Test of setPeso method, of class SensingConsern.
     */
    @Test
    public void testSetPeso() {
        System.out.println("setPeso");
        double peso = 0.0;
        instance.setPeso(peso);
    }

    /**
     * Test of getPeso method, of class SensingConsern.
     */
    @Test
    public void testGetPeso() {
        System.out.println("getPeso");
        double expResult = 0.0;
        double result = instance.getPeso();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setTemperatura method, of class SensingConsern.
     */
    @Test
    public void testSetTemperatura() {
        System.out.println("setTemperatura");
        double temperatura = 0.0;
        instance.setTemperatura(temperatura);
    }

    /**
     * Test of getTemperatura method, of class SensingConsern.
     */
    @Test
    public void testGetTemperatura() {
        System.out.println("getTemperatura");
        double expResult = 0.0;
        double result = instance.getTemperatura();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setPosicion method, of class SensingConsern.
     */
    @Test
    public void testSetPosicion() {
        System.out.println("setPosicion");
        int x = 0;
        int y = 0;
        instance.setPosicion(x, y);
    }
    
    /**
     * Test of getPosicion method, of class SensingConsern.
     */
    @Test
    public void testGetPosicion() {
        System.out.println("getPosicion");
        Posicion expResult = new Posicion();
        expResult.setCoordenadaX(0);
        expResult.setCoordenadaY(0);
        Posicion result = instance.getPosicion();
        assertEquals(expResult, result);
    }

    
}
