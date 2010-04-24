/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dominio.Contexto;
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public interface ContextoDao {
    public void guardar (Contexto contexto);
    public void modificar (Contexto contexto);
    public void borrar (Contexto contexto);
    public Contexto get (int id);
    public Contexto get(String nombre);
    public Collection getAll();
    

}
