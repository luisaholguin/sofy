/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import shell.Kernel;
import dominio.Comando;
import dominio.Objeto;
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
public class ServiceCoordinatorTest 
{
    private static ServiceCoordinator instance;
    
    public ServiceCoordinatorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception 
    {
        instance = new ServiceCoordinator(new Kernel());
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
     * Test of run method, of class ServiceCoordinator.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Objeto obj = null;
        Comando comando = new Comando();
        comando.setNombre("ENCENDER");  
        comando.setObjeto("TV");
        instance.run(obj, comando);
    }
}
