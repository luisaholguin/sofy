/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dominio.Contenedor;
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public interface ContenedorDao
{
    public void guardar(Contenedor contenedor);
    public void modificar(Contenedor contenedor);
    public void borrar(Contenedor contenedor);
    public Contenedor get(int id);
    public Contenedor get(String nombre);
    public Collection getAll();
}
