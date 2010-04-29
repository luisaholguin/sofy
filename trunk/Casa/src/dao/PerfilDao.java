/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dominio.Perfil;
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public interface PerfilDao {

    public void guardar(Perfil perfil);
    public void modificar(Perfil perfil);
    public void borrar(Perfil perfil);
    public Perfil get(int id);
    public Collection getAll();
    public int getCodigo();
    public Perfil get(String nombre);
}
