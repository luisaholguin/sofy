/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.implementacion;

import controlador.IngredienteInt;
import controlador.RecetaInt;
import dao.IngredienteDao;
import dao.RecetaDao;
import dao.RecetasIngredientesDao;
import dao.implementacion.IngredienteDaoImp;
import dao.implementacion.RecetaDaoImp;
import dao.implementacion.RecetasIngredientesDaoImp;
import dominio.Ingrediente;
import dominio.Receta;
import dominio.RecetaIngrediente;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Carolina
 */
public class RecetaImp implements RecetaInt
{

    public void guardar(Receta receta)
    {
      Collection ingredientes = receta.getIngrediente();//creo una coleccion del tipo ingrediente y y le asigno la coleccion de ingredientes que esta en receta
      RecetasIngredientesDao sqlTea = new RecetasIngredientesDaoImp();// instancio un objeto de RecetaIngredienteDao para poder guardar datos en la tea RecetaIngrdiente
      //primero se guarda la receta
      RecetaDao sqlReceta = new RecetaDaoImp();
      sqlReceta.guardar(receta);
      receta.setCodigo(sqlReceta.getCodigo());
      Iterator it = ingredientes.iterator();
      IngredienteDao sqlIngrediente = new IngredienteDaoImp();
      while (it.hasNext())//mientras haya ingredientes
      {
          Ingrediente ingrediente = (Ingrediente)it.next();
          sqlIngrediente.guardar(ingrediente);
          ingrediente.setCodigo(sqlIngrediente.getCodigo());
          sqlTea.guardar(receta.getCodigo(), ingrediente.getCodigo());


      }
    }
    public void modificar(Receta receta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void borrar(Receta receta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getCodigoReceta(int CodReceta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Collection getAll()
    {
        RecetaDao sqlRecetas = new RecetaDaoImp();
        RecetasIngredientesDao sql = new RecetasIngredientesDaoImp();
        IngredienteInt sqlIngredientes = new IngredienteImp();

        Collection tea = sql.getAll();
        Collection recetasTemp = sqlRecetas.getAll();
        Collection recetas = new ArrayList();

        Iterator it = recetasTemp.iterator();

        while(it.hasNext())
        {
            Receta receta = (Receta)it.next();
            Iterator i = tea.iterator();
            Collection ingredientes = new ArrayList();
            while(i.hasNext())
            {
                RecetaIngrediente r = (RecetaIngrediente)i.next();
                if(r.getCodigoReceta() == receta.getCodigo())
                {
                    Ingrediente in = sqlIngredientes.get(r.getCodigoIngrediente());
                    ingredientes.add(in);
                    in = null;
                }
                r = null;
            }
            receta.setIngrediente(ingredientes);
            recetas.add(receta);
            //quito los objetos temporales
            i = null;
            ingredientes = null;
            receta = null;
        }
        return recetas;
    }

}
