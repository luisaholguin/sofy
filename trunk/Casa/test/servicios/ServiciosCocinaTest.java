/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dominio.Posicion;
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
public class ServiciosCocinaTest {
    
    public ServiciosCocinaTest() {
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
     * Test of update method, of class ServiciosCocina.
     */
    @Test
    public void testUpdate() {
        System.out.println("mostrando la reseta");
        Posicion p = null;
        ServiciosCocina instance = new ServiciosCocina();
        instance.update(p);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of updateContenedor method, of class ServiciosCocina.
     */
    @Test
    public void testUpdateContenedor() {
        System.out.println("actualizando el contenido del Contenedor");
        ServiciosCocina instance = new ServiciosCocina();
        instance.updateContenedor();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
