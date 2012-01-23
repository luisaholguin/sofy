/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.adquisicion;

import servicios.salida.Decodificador;
import shell.Kernel;
import servicios.interprete.AnalizadorLexico;
import javax.speech.recognition.ResultEvent;
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
public class ColectorTest 
{
    private static Filtro filtro; 
    
    public ColectorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception 
    {
        filtro = new Filtro(new AnalizadorLexico(), new Kernel(), new Decodificador());
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
     * Test of iniciar method, of class Colector.
     */
    @Test
    public void testIniciar() {
        System.out.println("iniciar");
        
        Colector instance = new Colector();
        instance.iniciar(filtro);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of resultAccepted method, of class Colector.
     */
    @Test
    public void testResultAccepted() {
        System.out.println("resultAccepted");
        ResultEvent re = null;
        Colector instance = new Colector();
        instance.resultAccepted(re);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
