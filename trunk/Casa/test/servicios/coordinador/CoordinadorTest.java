/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.coordinador;

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
public class CoordinadorTest {
    
    public CoordinadorTest() {
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
     * Test of analisisEstado method, of class Coordinador.
     */
    @Test
    public void testAnalisisEstado() {
        System.out.println("analisando la forma del comando");
        Comando comando = new Comando();
        Coordinador instance = new Coordinador();
        boolean ResultExp = true;
        //se inician las pruebas con los comandos correctos
        comando.setNombre("TURN ON");
        comando.setObjeto("TV");
        boolean result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
        comando.setObjeto("STEREO");
        result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
        comando.setNombre("TURN OFF");
        comando.setObjeto("TV");
        result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
        comando.setObjeto("STEREO");
        result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
        comando.setNombre("SET");
        comando.setObjeto("CHANNEL");
        comando.setParmetro("23");
        result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
        comando.setObjeto("SONG");
        comando.setParmetro("2");
        result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
        
        //ahora se prueba con los comandos incorrectos
        ResultExp = false;
        comando.setNombre("OPEN");
        comando.setObjeto("TV");
        result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
        comando.setObjeto("STEREO");
        result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
        comando.setNombre("CLOSE");
        comando.setObjeto("TV");
        result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
        comando.setObjeto("STEREO");
        result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
        comando.setNombre("AJUSTAR");
        comando.setObjeto("CHANNEL");
        comando.setParmetro("23");
        result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
        comando.setObjeto("SONG");
        comando.setParmetro("2");
        result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
        
        //probando con el objeto incorrecto
        comando.setNombre("TURN ON");
        comando.setObjeto("DOOR");
        result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
        comando.setObjeto("WINDOW");
        result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
        comando.setNombre("TURN OFF");
        comando.setObjeto("DOOR");
        result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
        comando.setObjeto("WINDOW");
        result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
        comando.setNombre("SET");
        comando.setObjeto("TV");
        comando.setParmetro("23");
        result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
        comando.setObjeto("STEREO");
        comando.setParmetro("2");
        result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
        
        //probando con los parametros incorrectos
        comando.setNombre("SET");
        comando.setObjeto("CHANNEL");
        comando.setParmetro("aaa");
        result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
        comando.setObjeto("SONG");
        comando.setParmetro("bbb");
        result = instance.analisisEstado(comando);
        assertEquals(ResultExp, result);
    }
}
