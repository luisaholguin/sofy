/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstraccionhardware;

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
public class EmisorAudioTest {
    
    public EmisorAudioTest() {
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
     * Test of emitirMensaje method, of class EmisorAudio.
     */
    @Test
    public void testEmitirMensaje() {
        System.out.println("emitirMensaje");
        String mensaje = "this is a test";
        EmisorAudio instance = new EmisorAudio();
        instance.emitirMensaje(mensaje);
    }

    /**
     * Test of emitirSonido method, of class EmisorAudio.
     */
    @Test
    public void testEmitirSonido() {
        System.out.println("emitirSonido");
        int mensaje = 0;
        EmisorAudio instance = new EmisorAudio();
        instance.emitirSonido(mensaje);
    }

    /**
     * Test of errorMessage method, of class EmisorAudio.
     */
    @Test
    public void testErrorMessage() {
        System.out.println("errorMessage");
        String s = "mensaje de error";
        EmisorAudio instance = new EmisorAudio();
        instance.errorMessage(s);
    }
}
