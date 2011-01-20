/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import contexto.Observer;
import dominio.Posicion;
import shell.Kernel;

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
        this.perfil = this.kernel.getPerfil();
        this.kernel.setTemas(this.perfil.getMusica());
        this.kernel.setIntesidadLuz((int)this.perfil.getIntesidadLuz());
    }

}
