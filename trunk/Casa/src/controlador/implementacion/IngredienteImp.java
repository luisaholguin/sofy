/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.implementacion;

import controlador.IngredienteInt;
import dao.ElementoDao;
import dao.IngredienteDao;
import dao.implementacion.ElementoDaoImp;
import dao.implementacion.IngredienteDaoImp;
import dominio.Elemento;
import dominio.Ingrediente;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Marcelo
 */
public class IngredienteImp implements IngredienteInt
{

    public void guardar(Ingrediente ingrediente)
    {
        IngredienteDao sql = new IngredienteDaoImp();
        sql.guardar(ingrediente);
    }

    public void modificar(Ingrediente ingrediente)
    {
        IngredienteDao sql = new IngredienteDaoImp();
        sql.modificar(ingrediente);
    }

    public void borrar(Ingrediente ingrediente)
    {
        IngredienteDao sql = new IngredienteDaoImp();
        sql.borrar(ingrediente);
    }

    public Ingrediente get(int id)
    {
        IngredienteDao sql = new IngredienteDaoImp();
        Ingrediente ingrediente = sql.get(id);
//        Elemento e = ingrediente.getElemento();
//        ElementoDao sqlElemento = new ElementoDaoImp();
//        ingrediente.setElemento(sqlElemento.get(e.getCodigo()));
        return ingrediente;
    }

    public Collection getAll()
    {
        Collection ingredientes = new ArrayList();
        IngredienteDao sqlIngrediente = new IngredienteDaoImp();
//        ElementoDao sqlElemento = new ElementoDaoImp();
        ingredientes = sqlIngrediente.getAll();
//        Iterator it = temp.iterator();
//        while(it.hasNext())
//        {
//            Ingrediente i = (Ingrediente)it.next();
//            i.setElemento(sqlElemento.get(i.getElemento().getCodigo()));
//            ingredientes.add(i);
//            i = null;
//        }
        return ingredientes;
    }

    public Collection getIngredientesReceta(int idReceta)
    {
        IngredienteDao sql = new IngredienteDaoImp();
        return sql.getIngredientesReceta(idReceta);
    }

}
