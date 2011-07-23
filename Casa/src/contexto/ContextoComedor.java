/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contexto;

import dominio.Contexto;
import dominio.Posicion;
import shell.Kernel;

/**
 *
 * @author Marcelo
 */
public class ContextoComedor extends Contexto implements Observer
{
    private Kernel kernel;
    private boolean activo = false;

    public ContextoComedor()
    {
    }

    public ContextoComedor(Kernel kernel)
    {
        this.kernel = kernel;
    }

    

    public void update(Posicion p)
    {
        if((p.getCoordenadaX() >= super.getCoordenada_xn()) && (p.getCoordenadaX() <= super.getCoordenada_xs()))
            if((p.getCoordenadaY() >= super.getCoordenada_yn()) && (p.getCoordenadaY() <= super.getCoordenada_ys()))
            {
                if(!this.activo)
                {
                    this.kernel.setTemas(this.kernel.getPerfil().getMusica());
                    this.activo = true;
                }
            }
//                this.kernel.mostrarTemas(true);
            else
                this.activo = false;
//                this.kernel.mostrarTemas(false);
        else
            this.activo = false;
//            this.kernel.mostrarTemas(false);
    }

}
