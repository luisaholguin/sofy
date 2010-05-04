/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contexto;

import dominio.Contexto;
import dominio.Posicion;
import abstraccionhardware.Kernel;

/**
 *
 * @author Marcelo
 */
public class ContextoCocina extends Contexto implements Observer
{
    private Kernel kernel;

    public ContextoCocina()
    {
    }

    public ContextoCocina(Kernel kernel)
    {
        this.kernel = kernel;
    }



    public void update(Posicion p)
    {
        if((p.getCoordenadaX() >= super.getCoordenada_xn()) && (p.getCoordenadaX() <= super.getCoordenada_xs()))
            if((p.getCoordenadaY() >= super.getCoordenada_yn()) && (p.getCoordenadaY() <= super.getCoordenada_ys()))
                this.kernel.mostrarHeladera(true);
            else
                this.kernel.mostrarHeladera(false);
        else
            this.kernel.mostrarHeladera(false);
                
    }
}
