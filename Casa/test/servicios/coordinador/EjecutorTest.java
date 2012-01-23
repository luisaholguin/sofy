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
//import static org.junit.Assert.*;
import shell.Kernel;

/**
 *
 * @author Administrator
 */
public class EjecutorTest {
    
    public EjecutorTest() {
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
     * Test of ejecutar method, of class Ejecutor.
     */
    @Test
    public void testEjecutar() {
        System.out.println("ejecutar");
        Kernel kernel = null;
        Comando comando = new Comando();
        Ejecutor instance = new Ejecutor();
        
        //probar con el comando correcto
        comando.setNombre("TURN ON");
        comando.setObjeto("TV");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("STEREO");
        instance.ejecutar(kernel, comando);
        comando.setNombre("TURN OFF");
        comando.setObjeto("TV");
        instance.ejecutar(kernel, comando);        
        comando.setObjeto("STEREO");
        instance.ejecutar(kernel, comando);
        comando.setNombre("SET");
        comando.setObjeto("CHANNEL");
        comando.setParmetro("23");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("SONG");
        comando.setParmetro("2");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("LIGHT");
        comando.setParmetro("70");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("TEMPERATURE");
        comando.setParmetro("23");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("PROFILE");
        comando.setParmetro("FIESTA");
        instance.ejecutar(kernel, comando);
        comando.setNombre("OPEN");
        comando.setObjeto("DOOR");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("WINDOW");
        instance.ejecutar(kernel, comando);
        comando.setNombre("CLOSE");
        comando.setObjeto("DOOR");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("WINDOW");
        instance.ejecutar(kernel, comando);
        
        //ahora se prueba con los comandos incorrectos
        comando.setNombre("OPEN");
        comando.setObjeto("TV");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("STEREO");
        instance.ejecutar(kernel, comando);
        comando.setNombre("CLOSE");
        comando.setObjeto("TV");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("STEREO");
        instance.ejecutar(kernel, comando);
        comando.setNombre("AJUSTAR");
        comando.setObjeto("CHANNEL");
        comando.setParmetro("23");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("SONG");
        comando.setParmetro("2");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("LIGHT");
        comando.setParmetro("70");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("TEMPERATURE");
        comando.setParmetro("23");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("PROFILE");
        comando.setParmetro("FIESTA");
        instance.ejecutar(kernel, comando);
        comando.setNombre("ABRIRR");
        comando.setObjeto("DOOR");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("WINDOW");
        instance.ejecutar(kernel, comando);
        comando.setNombre("CERRAR");
        comando.setObjeto("DOOR");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("WINDOW");
        instance.ejecutar(kernel, comando);
        
        //probando con el objeto incorrecto
        comando.setNombre("TURN ON");
        comando.setObjeto("DOOR");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("WINDOW");
        instance.ejecutar(kernel, comando);
        comando.setNombre("TURN OFF");
        comando.setObjeto("DOOR");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("WINDOW");
        instance.ejecutar(kernel, comando);
        comando.setNombre("SET");
        comando.setObjeto("TV");
        comando.setParmetro("23");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("STEREO");
        comando.setParmetro("2");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("DOOR");
        comando.setParmetro("70");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("ALGO");
        comando.setParmetro("23");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("PROF");
        comando.setParmetro("FIESTA");
        instance.ejecutar(kernel, comando);
        comando.setNombre("OPE");
        comando.setObjeto("DOOR");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("WINDOW");
        instance.ejecutar(kernel, comando);
        comando.setNombre("CLOS");
        comando.setObjeto("DOOR");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("WINDOW");
        instance.ejecutar(kernel, comando);
        
        //probando con los parametros incorrectos
        comando.setNombre("SET");
        comando.setObjeto("CHANNEL");
        comando.setParmetro("aaa");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("SONG");
        comando.setParmetro("bbb");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("LIGHT");
        comando.setParmetro("-33");
        instance.ejecutar(kernel, comando);
        comando.setObjeto("TEMPERATURE");
        comando.setParmetro("150");
        instance.ejecutar(kernel, comando);
    }
}
