/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dominio.Elemento;
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public interface ElementoDao {
    public void guardar(Elemento elemento);
    public void modificar(Elemento elemento);
    public void borrar(Elemento elemento);
    public Elemento get(int id);
    public Collection getAll();


}
