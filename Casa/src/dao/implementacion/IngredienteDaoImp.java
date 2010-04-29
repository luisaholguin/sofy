/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.implementacion;

import dao.IngredienteDao;
import dominio.Elemento;
import dominio.Ingrediente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public class IngredienteDaoImp extends DataManager implements IngredienteDao {
    private Statement stmt;
    private Connection con;

    public void guardar(Ingrediente ingrediente) {
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "INSERT INTO ingredientes (id_elemento,cucharadas, taza, peso, unidades, seleccion)VALUES"+
                    "(" + ingrediente.getElemento().getCodigo()+ ","+ ingrediente.getCucharadas()+ ","+ingrediente.getTazas()+ ","+ingrediente.getPeso()+ ","+ingrediente.getUnidades()+ ","+ingrediente.getSeleccion()+ ")";
            stmt.executeUpdate(sql);
            this.cerrar();
            
        }
        catch(SQLException e)
        {
            while (e != null)
            {
               e.printStackTrace();
               e.getNextException();
            }
        }
    }
    private void cerrar()
    {
        try 
        {
            stmt.close();
            con.close();
        }
        catch(SQLException e)
        {
            while (e!= null)
            {
                e.printStackTrace();
                e.getNextException();
            }
        }
    }

    public void modificar(Ingrediente ingrediente)
    {
         try {
                con = super.getConection();
                stmt = con.createStatement();
                String sql = " UPDATE ingredientes SET id_elemento = " +  ingrediente.getElemento().getCodigo() + ","
             + " cucharadas = "+ ingrediente.getCucharadas()+ ",taza =" +ingrediente.getTazas()+ ", " +
                        "peso =" +ingrediente.getPeso()+ ", unidades = " + ingrediente.getUnidades()+ " ,seleccion = "+
                        ingrediente.getSeleccion()+" WHERE id = "+ ingrediente.getCodigo();
                stmt.executeUpdate(sql);
                this.cerrar();
            }
            catch(SQLException e)
            {
                while (e != null){
                   e.printStackTrace();
                   e.getNextException();
                }                  
             }
    }

    public void borrar(Ingrediente ingrediente) 
    {
         try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "DELETE FROM ingredientes WHERE id = " + ingrediente.getCodigo();
            stmt.executeUpdate(sql);
            this.cerrar();
        }
                
        catch (SQLException e)
        {
            while (e != null)
            {
                e.printStackTrace();
                e.getNextException();
            }
        }
    }

    public Ingrediente get(int id)
    {
        Ingrediente ingrediente = new Ingrediente();
        Elemento elemento = new Elemento();
        ResultSet resul = null;
        try 
        {            
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "SELECT ingredientes.id, ingredientes.cucharadas, ingredientes.taza, ingredientes.peso, ingredientes.unidades, ingredientes.seleccion, elementos.id, elementos.nombre, elementos.tipo " +
                    "FROM ingredientes, elementos " +
                    "WHERE ingredientes.id_elemento = elementos.id AND ingredientes.id = "+ id;
            resul = stmt.executeQuery(sql);
        }
        catch( SQLException e) 
        {
             while (e != null)
            {
                e.printStackTrace();
                e.getNextException();
            }            
        }
        try
        {
            ingrediente.setCodigo(0);
            while(resul.next())
            {
                ingrediente.setCodigo(resul.getInt(1));
                ingrediente.setCucharadas(resul.getInt(2));
                ingrediente.setTazas(resul.getDouble(3));
                ingrediente.setPeso(resul.getDouble(4));
                ingrediente.setUnidades(resul.getInt(5));
                ingrediente.setSeleccion(resul.getInt(6));
                elemento.setCodigo(resul.getInt(7));
                elemento.setNombre(resul.getString(8));
                elemento.setTipo(resul.getString(9));
                ingrediente.setElemento(elemento);
            }
            this.cerrar();
            resul.close();      
        }
        catch (SQLException e)
        {
             while (e != null)
            {
                e.printStackTrace();
                e.getNextException();
            }            
        }                
        return ingrediente; 
    }


    /**
     * Este metodo trae todos los ingredientes de una receta
     * @param idReceta
     * @return
     */
    public Collection getIngredientesReceta(int idReceta)
    {
        
        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "SELECT ingredientes.id, ingredientes.cucharadas, ingredientes.taza, ingredientes.peso, ingredientes.unidades, ingredientes.seleccion, elementos.id, elementos.nombre, elementos.tipo " +
                    "FROM ingredientes, elementos, recetas_ingredientes " +
                    "WHERE ingredientes.id_elemento = elementos.id AND ingredientes.id = recetas_ingredientes.id_ingrediente AND recetas_ingredientes.id_receta = "+ idReceta;
            resul = stmt.executeQuery(sql);
        }
        catch( SQLException e)
        {
             while (e != null)
            {
                e.printStackTrace();
                e.getNextException();
            }
        }
        Collection ingredientes = new ArrayList();
        try
        {
            while(resul.next())
            {
                Ingrediente ingrediente = new Ingrediente();
                Elemento elemento = new Elemento();
                ingrediente.setCodigo(resul.getInt(1));
                ingrediente.setCucharadas(resul.getInt(2));
                ingrediente.setTazas(resul.getDouble(3));
                ingrediente.setPeso(resul.getDouble(4));
                ingrediente.setUnidades(resul.getInt(5));
                ingrediente.setSeleccion(resul.getInt(6));
                elemento.setCodigo(resul.getInt(7));
                elemento.setNombre(resul.getString(8));
                elemento.setTipo(resul.getString(9));
                ingrediente.setElemento(elemento);
                ingredientes.add(ingrediente);
            }
            this.cerrar();
            resul.close();
        }
        catch (SQLException e)
        {
             while (e != null)
            {
                e.printStackTrace();
                e.getNextException();
            }
        }
        return ingredientes;
    }

    public Collection getAll()
    {
        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "SELECT ingredientes.id, ingredientes.cucharadas, ingredientes.taza, ingredientes.peso, ingredientes.unidades, ingredientes.seleccion, elementos.id, elementos.nombre, elementos.tipo " +
                    "FROM ingredientes, elementos" +
                    "WHERE ingredientes.id_elemento = elementos.id";
            resul = stmt.executeQuery(sql);
        }
        catch (SQLException e)
        {
            while (e!= null)
            {
                e.printStackTrace();
                e.getNextException();
            }
        }
        Collection co = new ArrayList();
        try
        {
            while (resul.next())
            {
                Ingrediente ingrediente = new Ingrediente();
                Elemento elemento = new Elemento();
                ingrediente.setCodigo(resul.getInt(1));
                ingrediente.setCucharadas(resul.getInt(2));
                ingrediente.setTazas(resul.getDouble(3));
                ingrediente.setPeso(resul.getDouble(4));
                ingrediente.setUnidades(resul.getInt(5));
                ingrediente.setSeleccion(resul.getInt(6));
                elemento.setCodigo(resul.getInt(7));
                elemento.setNombre(resul.getString(8));
                elemento.setTipo(resul.getString(9));
                ingrediente.setElemento(elemento);
                co.add(ingrediente);
            }
            this.cerrar();
            resul.close();
        }
        catch (SQLException e)
        {
             while (e != null)
            {
                e.printStackTrace();
                e.getNextException();
            }
        }
        return co;
    }
      public int getCodigo()
    {
        int codigo = 0;
        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql= "SELECT MAX(id)FROM ingredientes";
            resul = stmt.executeQuery(sql);
            resul.next();
            codigo = resul.getInt(1);
        }
        catch(SQLException e)
        {
            while (e != null)
            {
                e.printStackTrace();
                e.getNextException();
            }
        }
        return codigo;
    }
}
