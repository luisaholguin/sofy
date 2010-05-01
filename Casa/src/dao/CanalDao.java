/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dominio.Canal;
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public interface CanalDao {
    
    public void guardar(Canal canal);
    public void modificar(Canal canal);
    public void borrar(Canal canal);
    public Canal get(int id);
    public Collection getCanalesPerfil(int id);
    public Collection getAll();

}
