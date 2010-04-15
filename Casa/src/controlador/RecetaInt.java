/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import dominio.Receta;
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public interface RecetaInt {
    public void guardar ( Receta receta);//guarda un objeto receta
    public void modificar (Receta receta);
    public void borrar (Receta receta);
    //public int getCodigoIngrediente (int codIngredient e);
    public int getCodigoReceta (int CodReceta);
    public Collection getAll();


}
