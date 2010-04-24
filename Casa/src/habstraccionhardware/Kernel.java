/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package habstraccionhardware;

import sensado.Lectura;
import sensado.Perfil;
import sensado.Peso;
import sensado.SensingConsern;
import sensado.Ubicacion;


/**
 *
 * @author Marcelo
 */
public class Kernel
{
    private VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(this);
    private VentanaResultados ventanaResultados = new VentanaResultados();
    private VentanaSensor ventanaSensor = new VentanaSensor();
    private SensingConsern sensingConsern = new SensingConsern();

    public Kernel()
    {

    }

    public void inicializar()
    {
        ventanaPrincipal.setVisible(true);
        ventanaResultados.setVisible(true);
        ventanaSensor.setVisible(true);
    }

    public void cambiarPosicion(int x, int y)
    {
        sensingConsern.setPosicion(x, y);
    }

}
