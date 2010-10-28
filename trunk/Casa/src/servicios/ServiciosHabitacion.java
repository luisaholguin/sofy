/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import contexto.Observer;
import dominio.Posicion;
import abstraccionhardware.Kernel;

/**
 *
 * @author Marcelo
 */
public class ServiciosHabitacion implements Observer
{
    private Kernel kernel;
    private dominio.Perfil perfil = new dominio.Perfil();

    public ServiciosHabitacion(Kernel kernel)
    {
        this.kernel = kernel;
    }

    
    public void update(Posicion p)
    {
        //Actualizar la lista de canales
        this.perfil = this.kernel.getPerfil();
        this.kernel.setCanales(this.perfil.getCanales());
        this.kernel.setIntesidadLuz((int)this.perfil.getIntesidadLuz());
    }

}
