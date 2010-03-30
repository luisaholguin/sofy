/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dominio.Peso;
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public interface PesoDao {
    public void guardar(Peso peso);
    public void modificar(Peso peso);
    public void borrar(Peso peso);
    public Peso get(int id);
    public Collection getAll();


}
