/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dominio.Receta;
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public interface RecetaDao {

    public void guardar(Receta receta);
    public void modificar (Receta receta);
    public void borrar(Receta receta);
    public Receta get(int id);
    public Collection getRecetasPerfil(int id);
    public Collection getAll();
    public int getCodigo();


}
