/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dominio.Musica;
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public interface MusicaDao {

    public void guardar(Musica tema);
    public void modificar(Musica tema);
    public void borrar(Musica tema);
    public Musica get(int id);
    public Collection getAll();

}
