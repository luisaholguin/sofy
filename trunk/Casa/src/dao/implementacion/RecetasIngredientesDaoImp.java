/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.implementacion;

import dao.RecetasIngredientesDao;
import dominio.RecetaIngrediente;
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
public class RecetasIngredientesDaoImp extends DataManager implements RecetasIngredientesDao
{
    private Statement stmt;
    private Connection con;
    
    

    public void guardar(int codReceta, int codIngrediente) {
         try
        {
           con = super.getConection();
            stmt = con.createStatement();
            String sql = "INSERT INTO recetas_ingredientes (id_receta , id_ingrediente) VALUES"+"(" + codReceta + ","+ codIngrediente  + ")";
            System.out.println(sql);
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
    
    

    public void modificar(int codigo, int codReceta, int codIngrediente)
    {
        
         try 
         {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "UPDATE recetas_ingredientes SET id_receta = " + codReceta+ ",id_ingrediente = "+ codIngrediente +
                    " WHERE id = " + codigo ;
            System.out.println(sql);
            stmt.executeUpdate(sql);
            this.cerrar();
        }
         catch (SQLException e) {
            while (e != null) {
                e.printStackTrace();
                e.getNextException();
            }
        }

    }

    public void borrar(int codigo)
    {
         try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "DELETE FROM recetas_ingredientes WHERE id = " + codigo;
            System.out.println(sql);
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

    public int getCodigoIngrediente(int codIngrediente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getCodigoReceta(int CodReceta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Collection getAll()
    {
        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql= "SELECT id, id_receta, id_ingrediente FROM recetas_ingredientes";
            System.out.println(sql);
            resul = stmt.executeQuery(sql);
        }
        catch(SQLException e)
        {
            while (e != null)
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
                RecetaIngrediente r = new RecetaIngrediente();
                r.setCodigo(resul.getInt(1));
                r.setCodigoReceta(resul.getInt(2));
                r.setCodigoIngrediente(resul.getInt(3));
                co.add(r);
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

    
}
