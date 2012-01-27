/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contexto;

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
public class ContextoCocinaTest {
    
    public ContextoCocinaTest() {
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
     * Test of update method, of class ContextoCocina.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Posicion p = new Posicion(); //cocina
        p.setCoordenadaX(100);
        p.setCoordenadaY(53);
        ContextoCocina instance = new ContextoCocina();
        instance.update(p);
    }
}
