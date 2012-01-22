/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dominio.Comando;
import dominio.Luz;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import shell.Kernel;
import static org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import org.junit.runners.Suite;

/**
 *
 * @author Administrator
 */
//@RunWith(Suite.class)
//@Suite.SuiteClasses({servicios.TestSuiteServiciosPuerta.class, servicios.TestSuiteServiciosPersiana.class})
public class TestSuiteServiciosLuz 
{
    private static Comando cmd;
    private static Luz luz;

    @BeforeClass
    public static void setUpClass() throws Exception 
    {
        cmd = new Comando();
        luz = new Luz();
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
     * Test of run method, of class ServLuz.
     */
    @Test
    public void testEncenderLuz() 
    {
        System.out.println("encendiendo la luz");
        this.luz.setEncendida(false);
        cmd.setNombre("ENCENDER");
//        cmd.setObjeto("persiana 1");
        ServLuz instance = new ServLuz(new Kernel());
        boolean expResult = true;
        boolean result = instance.run(luz, cmd);
        assertEquals(expResult, result);
        this.luz.setEncendida(true);
        expResult = false;
        result = instance.run(luz, cmd);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of run method, of class ServLuz.
     */
    @Test
    public void testApagarLuz() 
    {
        System.out.println("apagando la luz");
        this.luz.setEncendida(true);
        cmd.setNombre("APAGAR");
//        cmd.setObjeto("persiana 1");
        ServLuz instance = new ServLuz(new Kernel());
        boolean expResult = true;
        boolean result = instance.run(luz, cmd);
        assertEquals(expResult, result);
        this.luz.setEncendida(false);
        expResult = false;
        result = instance.run(luz, cmd);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of run method, of class ServLuz.
     */
    @Test
    public void testAjustarIntensidadLuz() 
    {
        System.out.println("ajustando intensidad de luz");
        this.luz.setEncendida(true);
        cmd.setNombre("AJUSTAR");
        cmd.setParmetro("50");
        cmd.setParametroRequerido(true);
//        cmd.setObjeto("persiana 1");
        ServLuz instance = new ServLuz(new Kernel());
        boolean expResult = true;
        boolean result = instance.run(luz, cmd);
        assertEquals(expResult, result);
        this.luz.setEncendida(false);
        expResult = true;
        result = instance.run(luz, cmd);
        assertEquals(expResult, result);
    }
}
