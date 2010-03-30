/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dominio.Posicion;
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public interface PosicionDao {
    public void guardar(Posicion posicion);
    public void modificar(Posicion posicion);
    public void borrar(Posicion posicion);
    public Posicion get(int id);
    public Collection getAll();


}
