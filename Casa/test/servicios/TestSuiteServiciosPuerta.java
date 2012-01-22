/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dominio.Comando;
import dominio.Puerta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import org.junit.runners.Suite;

/**
 *
 * @author Administrator
 */
//@RunWith(Suite.class)
//@Suite.SuiteClasses({servicios.TestSuiteServiciosPersiana.class})
public class TestSuiteServiciosPuerta 
{
    
    private static Puerta puerta;
    private static Comando cmd;

    @BeforeClass
    public static void setUpClass() throws Exception 
    {
        puerta = new Puerta();
        cmd = new Comando();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    /**
     * Test of run method, of class ServPuerta.
     */
    @Test
    public void testAbrirPuerta() 
    {
        System.out.println("abriendo puerta");
        this.puerta.setEstado(false);
        cmd.setNombre("ABRIR");
//        cmd.setObjeto("persiana 1");
        ServPuerta instance = new ServPuerta();
        boolean expResult = true;
        boolean result = instance.run(puerta, cmd);
        assertEquals(expResult, result);
        this.puerta.setEstado(true);
        expResult = false;
        result = instance.run(puerta, cmd);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of run method, of class ServPuerta.
     */
    @Test
    public void testCerrarPuerta() 
    {
        System.out.println("cerrando puerta");
        this.puerta.setEstado(true);
        cmd.setNombre("CERRAR");
//        cmd.setObjeto("persiana 1");
        ServPuerta instance = new ServPuerta();
        boolean expResult = true;
        boolean result = instance.run(puerta, cmd);
        assertEquals(expResult, result);
        this.puerta.setEstado(true);
        expResult = false;
        result = instance.run(puerta, cmd);
        assertEquals(expResult, result);
    }
    
}
