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
    private boolean adentro = false;

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
//                System.out.println("Coordena x - "+p.getCoordenadaX() + " ... coordenada y - "+p.getCoordenadaY());
                if(!this.activo)
                {
                    this.kernel.setTemas(this.kernel.getPerfil().getMusica());
                    this.activo = true;
                    this.kernel.armarListaObjetosComedor();
                }
                if(!this.adentro)
                {
                    if((p.getCoordenadaX() >= 289) && (p.getCoordenadaX() < 362))
                        this.kernel.entrarComedor();
                }
                    
                adentro = true;
            }
//                this.kernel.mostrarTemas(true);
            else
            {
                this.activo = false;
                adentro = false;
            }
                
//                this.kernel.mostrarTemas(false);
        else
        {
            this.activo = false;
            adentro = false;
        }
            
//            this.kernel.mostrarTemas(false);
    }

}
