/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.implementacion;

import controlador.RecetaInt;
import dao.IngredienteDao;
import dao.RecetaDao;
import dao.RecetasIngredientesDao;
import dao.implementacion.IngredienteDaoImp;
import dao.implementacion.RecetaDaoImp;
import dao.implementacion.RecetasIngredientesDaoImp;
import dominio.Ingrediente;
import dominio.Receta;
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

    public Collection getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
