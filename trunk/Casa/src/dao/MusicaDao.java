/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dominio.Cancion;
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public interface MusicaDao {

    public void guardar(Cancion tema);
    public void modificar(Cancion tema);
    public void borrar(Cancion tema);
    public Cancion get(int id);
    public Collection getTemasPerfil(int id);
    public Collection getAll();

}
