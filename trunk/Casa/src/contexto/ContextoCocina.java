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
public class ContextoCocina extends Contexto implements Observer
{
    private Kernel kernel;
    private boolean adentro = false;

    public ContextoCocina()
    {
    }

    public ContextoCocina(Kernel kernel)
    {
        this.kernel = kernel;
    }



    public void update(Posicion p)
    {
//        System.out.println("El punto y vale "+p.getCoordenadaY());
        if((p.getCoordenadaX() >= super.getCoordenada_xn()) && (p.getCoordenadaX() <= super.getCoordenada_xs()))
            if((p.getCoordenadaY() >= super.getCoordenada_yn()) && (p.getCoordenadaY() <= super.getCoordenada_ys()))
            {
//                System.out.println("El punto y vale "+p.getCoordenadaY());
                    if((p.getCoordenadaY() <= 135)&&(p.getCoordenadaY()>= 132))
                    {
                        if(!this.adentro)
                        {
                            this.kernel.armarListaObjetosCocina();
                            this.kernel.mostrarHeladera(true);
                            this.kernel.entrarCocina();
                        }
                    }
                this.adentro = true;
            }
                
            else
            {
                this.adentro = false;
                this.kernel.mostrarHeladera(false);
                if((p.getCoordenadaY() > 135) && (p.getCoordenadaY() <251))
                    this.kernel.salirCocina();
            }
                
        else
        {
            this.adentro = false;
            this.kernel.mostrarHeladera(false);
            if((p.getCoordenadaY() > 135) && (p.getCoordenadaY() <251))
                    this.kernel.salirCocina();
        }
            
                
    }
}
