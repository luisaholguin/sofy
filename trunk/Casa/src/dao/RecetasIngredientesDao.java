/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.Collection;

/**
 *
 * @author Carolina
 */
public interface RecetasIngredientesDao {
    
    public void guardar ( int codReceta, int codIngredientes);
    public void modificar (int codigo, int codReceta, int codIngrediente);
    public void borrar (int codigo);
    public Collection getIngredientesReceta(int codigoReceta);// este metodo trae solo los ingredientes de una receta
    public int getCodigoReceta (int CodReceigoReceta);
    public Collection getAll();
    public void borrarIngredientes(int codigoReceta);

}
