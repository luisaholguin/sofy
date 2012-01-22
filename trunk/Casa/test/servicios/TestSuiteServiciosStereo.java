/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import org.junit.Test;
import dominio.Stereo;
import dominio.Comando;
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
//@Suite.SuiteClasses({servicios.TestSuiteServiciosPuerta.class, servicios.TestSuiteServiciosPersiana.class, servicios.TestSuiteServiciosLuz.class})
public class TestSuiteServiciosStereo 
{
    private static Comando cmd;
    private static Stereo stereo;

    @BeforeClass
    public static void setUpClass() throws Exception 
    {
        cmd = new Comando();
        stereo = new Stereo();
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
     * Test of run method, of class ServStereo.
     */
    @Test
    public void testEncenderStereo() 
    {
        System.out.println("encendiendo el stereo");
        this.stereo.setEstado(false);
        cmd.setNombre("ENCENDER");
//        cmd.setObjeto("persiana 1");
        ServStereo instance = new ServStereo();
        boolean expResult = true;
        boolean result = instance.run(stereo, cmd);
        assertEquals(expResult, result);
        this.stereo.setEstado(true);
        expResult = false;
        result = instance.run(stereo, cmd);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of run method, of class ServStereo.
     */
    @Test
    public void testApagarStereo() 
    {
        System.out.println("apagando esl stereo");
        this.stereo.setEstado(true);
        cmd.setNombre("APAGAR");
//        cmd.setObjeto("persiana 1");
        ServStereo instance = new ServStereo();
        boolean expResult = true;
        boolean result = instance.run(stereo, cmd);
        assertEquals(expResult, result);
        this.stereo.setEstado(false);
        expResult = false;
        result = instance.run(stereo, cmd);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of run method, of class ServStereo.
     */
    @Test
    public void testReproducirCancion() 
    {
        System.out.println("reproduciendo cancion");
        this.stereo.setEstado(true);
        cmd.setNombre("REPRODUCIR");
        cmd.setParmetro("2");
        cmd.setParametroRequerido(true);
//        cmd.setObjeto("persiana 1");
        ServStereo instance = new ServStereo();
        boolean expResult = true;
        boolean result = instance.run(stereo, cmd);
        assertEquals(expResult, result);
        this.stereo.setEstado(false);
        expResult = false;
        result = instance.run(stereo, cmd);
        assertEquals(expResult, result);
    }
}
