/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import dominio.Ingrediente;
import java.util.Collection;

/**
 *
 * @author Marcelo
 */
public interface IngredienteInt
{
    public void guardar(Ingrediente ingrediente);
    public void modificar(Ingrediente ingrediente);
    public void borrar(Ingrediente ingrediente);
    public Ingrediente get(int id);
    public Collection getAll();
}
