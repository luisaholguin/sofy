/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contexto;

import dominio.Contexto;
import dominio.Posicion;
import habstraccionhardware.Kernel;

/**
 *
 * @author Marcelo
 */
public class ContextoHabitacion extends Contexto implements Observer
{

    private Kernel kernel;

    public ContextoHabitacion()
    {
    }

    public ContextoHabitacion(Kernel kernel)
    {
        this.kernel = kernel;
    }

    

    public void update(Posicion p)
    {
        if((p.getCoordenadaX() >= super.getCoordenada_xn()) && (p.getCoordenadaX() <= super.getCoordenada_xs()))
            if((p.getCoordenadaY() >= super.getCoordenada_yn()) && (p.getCoordenadaY() <= super.getCoordenada_ys()))
                this.kernel.mostrarTelevisor(true);
            else
                this.kernel.mostrarTelevisor(false);
        else
            this.kernel.mostrarTelevisor(false);
    }

}
