/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sonidos;

import java.net.URL;

/**
 *
 * @author Administrador
 */
public class Sonidos
{

    public Sonidos() {
    }

    public URL getUrl(String nombre)
    {
        return this.getClass().getResource(nombre);
    }

}
