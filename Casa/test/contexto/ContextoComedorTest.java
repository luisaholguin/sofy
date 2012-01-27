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
public class ContextoComedorTest {
    
    public ContextoComedorTest() {
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
     * Test of update method, of class ContextoComedor.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Posicion p = new Posicion();
        p.setCoordenadaX(200); //comedor
        p.setCoordenadaY(300);
        ContextoComedor instance = new ContextoComedor();
        instance.update(p);
    }
}
