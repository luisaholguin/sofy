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
//                if(p.getCoordenadaY() == 135)
//                {
//                    System.out.println("Entro o salio de la cocina");
//                    this.kernel.entrarSalirCocina();
//                    if(!this.adentro)
//                    {
                if((p.getCoordenadaY() <= 135)&&(p.getCoordenadaY()>= 132))
                {
                    this.kernel.entrarCocina();
                    this.kernel.mostrarHeladera(true);
                    this.kernel.armarListaObjetosCocina();
                    this.adentro = true;
                }
                
//                    }
//                    else
//                        this.adentro = false;
//                    
//                }
                    
//                this.kernel.mostrarHeladera(true);
//                this.kernel.armarListaObjetosCocina();
//                System.out.println("Se armo la lista de objetos para cocina");
            }
                
            else
            {
                this.kernel.mostrarHeladera(false);
                if((p.getCoordenadaY() > 135) && (p.getCoordenadaY() <251))
                    this.kernel.salirCocina();
            }
                
        else
        {
            this.kernel.mostrarHeladera(false);
            if((p.getCoordenadaY() > 135) && (p.getCoordenadaY() <251))
                    this.kernel.salirCocina();
        }
            
                
    }
}
