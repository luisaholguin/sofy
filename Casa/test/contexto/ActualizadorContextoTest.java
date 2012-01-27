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
public class ActualizadorContextoTest 
{
    private static ActualizadorContexto instance;
    private static Observer observadorCocina;
    private static Observer observadorComedor;
    private static Observer observadorHabitacion;
    
    public ActualizadorContextoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception 
    {
        instance = new ActualizadorContexto();
        observadorCocina = new ContextoCocina();
        observadorComedor = new ContextoComedor();
        observadorHabitacion = new ContextoHabitacion();
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
     * Test of addObserver method, of class ActualizadorContexto.
     */
    @Test
    public void testAddObserver() {
        System.out.println("addObserver");
        
        instance.addObserver(observadorCocina);
        
        instance.addObserver(observadorComedor);
        
        instance.addObserver(observadorHabitacion);
    }
    
    /**
     * Test of notifyObserver method, of class ActualizadorContexto.
     */
    @Test
    public void testNotifyObserver() {
        System.out.println("notifyObserver");
        Posicion p = new Posicion(); //cocina
        p.setCoordenadaX(100);
        p.setCoordenadaY(53);
        instance.notifyObserver(p);
        p.setCoordenadaX(200); //comedor
        p.setCoordenadaY(300);
        instance.notifyObserver(p);
        p.setCoordenadaX(500);// habitacion
        p.setCoordenadaY(350);
        instance.notifyObserver(p);
    }

    /**
     * Test of removeObserver method, of class ActualizadorContexto.
     */
    @Test
    public void testRemoveObserver() {
        System.out.println("removeObserver");
        instance.removeObserver(observadorCocina);
        
        instance.removeObserver(observadorComedor);
        
        instance.removeObserver(observadorHabitacion);
    }

    
}
