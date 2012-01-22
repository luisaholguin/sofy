/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dominio.Persiana;
import dominio.Comando;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Suite;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
//@RunWith(Suite.class)
//@Suite.SuiteClasses({servicios.ServPersianaTest.class})
public class TestSuiteServicios 
{
    private static Persiana persiana;
    private static Comando cmd = new Comando();

    @BeforeClass
    public static void setUpClass() throws Exception 
    {
         persiana = new Persiana();
    }

    @AfterClass
    public static void tearDownClass() throws Exception 
    {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    
    /**
     * Test of run method, of class ServPersiana.
     */
    @Test
    public void testAbrirPersiana() 
    {
        System.out.println("abriendo persiana");
        this.persiana.setEstado(false);
        cmd.setNombre("ABRIR");
//        cmd.setObjeto("persiana 1");
        ServPersiana instance = new ServPersiana();
        boolean expResult = true;
        boolean result = instance.run(persiana, cmd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
