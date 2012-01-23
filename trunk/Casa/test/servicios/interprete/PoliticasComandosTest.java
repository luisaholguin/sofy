/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.interprete;

import shell.Kernel;
import dominio.Comando;
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
public class PoliticasComandosTest 
{
    private static Comando comando;
    
    public PoliticasComandosTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception 
    {
        comando = new Comando();
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
     * Test of analisisSintactico method, of class PoliticasComandos.
     */
    @Test
    public void testAnalisisSintactico() {
        System.out.println("analisis Sintactico");
        
        PoliticasComandos instance = new PoliticasComandos();
        boolean expResult = true;
        
        //probar con el comando correcto
        comando.setNombre("TURN ON");
        comando.setObjeto("TV");
        boolean result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("STEREO");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setNombre("TURN OFF");
        comando.setObjeto("TV");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("STEREO");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setNombre("SET");
        comando.setObjeto("CHANNEL");
        comando.setParmetro("23");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("SONG");
        comando.setParmetro("2");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("LIGHT");
        comando.setParmetro("70");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("TEMPERATURE");
        comando.setParmetro("23");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("PROFILE");
        comando.setParmetro("FIESTA");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setNombre("OPEN");
        comando.setObjeto("DOOR");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("WINDOW");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setNombre("CLOSE");
        comando.setObjeto("DOOR");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("WINDOW");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        
        //ahora se prueba con los comandos incorrectos
        expResult = false;
        comando.setNombre("OPEN");
        comando.setObjeto("TV");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("STEREO");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setNombre("CLOSE");
        comando.setObjeto("TV");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("STEREO");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setNombre("AJUSTAR");
        comando.setObjeto("CHANNEL");
        comando.setParmetro("23");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("SONG");
        comando.setParmetro("2");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("LIGHT");
        comando.setParmetro("70");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("TEMPERATURE");
        comando.setParmetro("23");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("PROFILE");
        comando.setParmetro("FIESTA");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setNombre("ABRIRR");
        comando.setObjeto("DOOR");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("WINDOW");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setNombre("CERRAR");
        comando.setObjeto("DOOR");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("WINDOW");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        
        //probando con el objeto incorrecto
        comando.setNombre("TURN ON");
        comando.setObjeto("DOOR");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("WINDOW");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setNombre("TURN OFF");
        comando.setObjeto("DOOR");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("WINDOW");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setNombre("SET");
        comando.setObjeto("TV");
        comando.setParmetro("23");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("STEREO");
        comando.setParmetro("2");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("DOOR");
        comando.setParmetro("70");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("ALGO");
        comando.setParmetro("23");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("PROF");
        comando.setParmetro("FIESTA");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setNombre("OPE");
        comando.setObjeto("DOOR");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("WINDOW");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setNombre("CLOS");
        comando.setObjeto("DOOR");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("WINDOW");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        
        //probando con los parametros incorrectos
        comando.setNombre("SET");
        comando.setObjeto("CHANNEL");
        comando.setParmetro("aaa");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("SONG");
        comando.setParmetro("bbb");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("LIGHT");
        comando.setParmetro("-33");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        comando.setObjeto("TEMPERATURE");
        comando.setParmetro("150");
        result = instance.analisisSintactico(comando);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of analizarParametros method, of class PoliticasComandos.
     */
    @Test
    public void testAnalizarParametros() {
        System.out.println("analizarParametros");
        PoliticasComandos instance = new PoliticasComandos();
        boolean expResult = false;
        
        //probando con los parametros correctos
        comando.setNombre("SET");
        comando.setObjeto("CHANNEL");
        comando.setParmetro("23");
        boolean result = instance.analizarParametros(comando);
        assertEquals(expResult, result);
        comando.setObjeto("SONG");
        comando.setParmetro("2");
        result = instance.analizarParametros(comando);
        assertEquals(expResult, result);
        comando.setObjeto("LIGHT");
        comando.setParmetro("70");
        result = instance.analizarParametros(comando);
        assertEquals(expResult, result);
        comando.setObjeto("TEMPERATURE");
        comando.setParmetro("23");
        result = instance.analizarParametros(comando);
        assertEquals(expResult, result);
        comando.setObjeto("PROFILE");
        comando.setParmetro("FIESTA");
        result = instance.analizarParametros(comando);
        assertEquals(expResult, result);
        
        //probando con los parametros incorrectos
        comando.setNombre("SET");
        comando.setObjeto("CHANNEL");
        comando.setParmetro("aaa");
        result = instance.analizarParametros(comando);
        assertEquals(expResult, result);
        comando.setObjeto("SONG");
        comando.setParmetro("bbb");
        result = instance.analizarParametros(comando);
        assertEquals(expResult, result);
        comando.setObjeto("LIGHT");
        comando.setParmetro("-33");
        result = instance.analizarParametros(comando);
        assertEquals(expResult, result);
        comando.setObjeto("TEMPERATURE");
        comando.setParmetro("150");
        result = instance.analizarParametros(comando);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    

    /**
     * Test of requiereParametros method, of class PoliticasComandos.
     */
    @Test
    public void testRequiereParametros() {
        System.out.println("requiere Parametros");
        PoliticasComandos instance = new PoliticasComandos();
        boolean expResult = false;
        //probando con objetos que no requieren parametros
        this.comando.setObjeto("TV");
        boolean result = instance.requiereParametros(comando);
        assertEquals(expResult, result);
        this.comando.setObjeto("STEREO");
        result = instance.requiereParametros(comando);
        assertEquals(expResult, result);
        
        //probando con objetos que si requieren parametros
        expResult = true;
        this.comando.setObjeto("LIGHT");
        result = instance.requiereParametros(comando);
        assertEquals(expResult, result);
        this.comando.setObjeto("TEMPERATURE");
        result = instance.requiereParametros(comando);
        assertEquals(expResult, result);
        this.comando.setObjeto("SONG");
        result = instance.requiereParametros(comando);
        assertEquals(expResult, result);
        this.comando.setObjeto("CHANNEL");
        result = instance.requiereParametros(comando);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
}
