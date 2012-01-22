/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dominio.Televisor;
import dominio.Comando;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import org.junit.runners.Suite;

/**
 *
 * @author Administrator
 */
//@RunWith(Suite.class)
//@Suite.SuiteClasses({servicios.TestSuiteServiciosPuerta.class, servicios.TestSuiteServiciosStereo.class, servicios.TestSuiteServiciosPersiana.class, servicios.TestSuiteServiciosLuz.class})
public class TestSuiteServiciosTelevisor 
{
    private static Comando cmd;
    private static Televisor televisor;

    @BeforeClass
    public static void setUpClass() throws Exception 
    {
        cmd = new Comando();
        televisor = new Televisor();
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
     * Test of run method, of class ServTelevisor.
     */
    @Test
    public void testEncenderStereo() 
    {
        System.out.println("encendiendo el televisor");
        this.televisor.setEstado(false);
        cmd.setNombre("ENCENDER");
//        cmd.setObjeto("persiana 1");
        ServTelevisor instance = new ServTelevisor();
        boolean expResult = true;
        boolean result = instance.run(televisor, cmd);
        assertEquals(expResult, result);
        this.televisor.setEstado(true);
        expResult = false;
        result = instance.run(televisor, cmd);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of run method, of class ServTelevisor.
     */
    @Test
    public void testApagarTelevisor() 
    {
        System.out.println("apagando el televisor");
        this.televisor.setEstado(true);
        cmd.setNombre("APAGAR");
//        cmd.setObjeto("persiana 1");
        ServTelevisor instance = new ServTelevisor();
        boolean expResult = true;
        boolean result = instance.run(televisor, cmd);
        assertEquals(expResult, result);
        this.televisor.setEstado(false);
        expResult = false;
        result = instance.run(televisor, cmd);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of run method, of class ServTelevisor.
     */
    @Test
    public void testFijarCanal() 
    {
        System.out.println("mostrando un canal");
        this.televisor.setEstado(true);
        cmd.setNombre("FIJAR");
        cmd.setParmetro("2");
        cmd.setParametroRequerido(true);
//        cmd.setObjeto("persiana 1");
        ServTelevisor instance = new ServTelevisor();
        boolean expResult = true;
        boolean result = instance.run(televisor, cmd);
        assertEquals(expResult, result);
        this.televisor.setEstado(false);
        expResult = false;
        result = instance.run(televisor, cmd);
        assertEquals(expResult, result);
    }
    
}
