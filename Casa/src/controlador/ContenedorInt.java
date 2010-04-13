/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import dominio.Contenedor;
import java.util.Collection;

/**
 *
 * @author Marcelo
 */
public interface ContenedorInt
{

    public void guardar(Contenedor contenedor);
    public void modificar(Contenedor contenedor);
    public void borrar(Contenedor contenedor);
    public Contenedor get(int id);
    public Collection getAll();

}
