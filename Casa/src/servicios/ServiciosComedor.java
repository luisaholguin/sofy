/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import contexto.Observer;
import dominio.Posicion;
import habstraccionhardware.Kernel;

/**
 *
 * @author Marcelo
 */
public class ServiciosComedor implements Observer
{
    private Kernel kernel;
    private dominio.Perfil perfil = new dominio.Perfil();

    public ServiciosComedor(Kernel kernel)
    {
        this.kernel = kernel;
    }
    


    public void update(Posicion p)
    {
        System.out.println("Servicio no implementado");
    }

}
