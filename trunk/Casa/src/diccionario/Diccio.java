/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package diccionario;

import java.net.URL;

/**
 *
 * @author Administrador
 */
public class Diccio
{

    public Diccio() {
    }

    public URL getUrl(String nombre)
    {
        return this.getClass().getResource(nombre);
    }

}
