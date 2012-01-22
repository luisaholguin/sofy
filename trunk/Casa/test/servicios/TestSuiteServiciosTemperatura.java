/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dominio.Comando;
import dominio.Temperatura;
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
//@Suite.SuiteClasses({servicios.TestSuiteServiciosPuerta.class, servicios.TestSuiteServiciosStereo.class, servicios.TestSuiteServiciosTelevisor.class, servicios.TestSuiteServiciosPersiana.class, servicios.TestSuiteServiciosLuz.class})
public class TestSuiteServiciosTemperatura 
{
    private static Comando cmd;
    private static Temperatura temperatura;

    @BeforeClass
    public static void setUpClass() throws Exception 
    {
        cmd = new Comando();
        temperatura = new Temperatura();
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
     * Test of run method, of class ServTemperatura.
     */
    @Test
    public void testFijarCanal() 
    {
        System.out.println("ajustando la temperatura");
//        this.temperatura.setEstado(true);
        cmd.setNombre("FIJAR");
        cmd.setParmetro("20");
        cmd.setParametroRequerido(true);
//        cmd.setObjeto("persiana 1");
        ServTemperatura instance = new ServTemperatura();
        boolean expResult = true;
        boolean result = instance.run(temperatura, cmd);
        assertEquals(expResult, result);
    }
}
