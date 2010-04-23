/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package principal;

import habstraccionhardware.VentanaPrincipal;
import habstraccionhardware.VentanaResultados;
import habstraccionhardware.VentanaSensor;

/**
 *
 * @author Marcelo
 */
public class Kernel
{
    private VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
    private VentanaResultados ventanaResultados = new VentanaResultados();
    private VentanaSensor ventanaSensor = new VentanaSensor();

    public Kernel()
    {

    }

    public void inicializar()
    {

        ventanaPrincipal.setVisible(true);
        ventanaResultados.setVisible(true);
        ventanaSensor.setVisible(true);
    }

}
