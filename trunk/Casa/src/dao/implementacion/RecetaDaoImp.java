/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.implementacion;

import dao.RecetaDao;
import dominio.Receta;
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
public class RecetaDaoImp extends DataManager implements RecetaDao {
    private Statement stmt;
    private Connection con;
    

    public void guardar(Receta receta) {
        try
        {
            con= super.getConection();
            stmt = con.createStatement();
            String sql = "INSERT INTO recetas (nombre, instrucciones, tiempo_preparacion,porciones , calorias,categoria ) VALUES " +
                    "('"+ receta.getNombre()+ "','"+ receta.getInstrucciones()+  "','" + receta.gettiempoPreparado() +"',"
                    + receta.getPorciones()+ ","+receta.getCalorias() + ",'"+ receta.getCategoria()+"')";
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

    private void cerrar ()
    {
        try
        {
            stmt.close();
            con.close();
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
            

    public void modificar(Receta receta)
    {
         try {
                con = super.getConection();
                stmt = con.createStatement();
                String sql = " UPDATE recetas SET nombre = '" +  receta.getNombre() + "',"
             + " instrucciones = '"+ receta.getInstrucciones()+ "', tiempo_preparacion = '" + receta.gettiempoPreparado()+ "', " +
             "porciones =" + receta.getPorciones()+ ", calorias = " + receta.getCalorias() +", categoria = '"+ receta.getCategoria()+"' WHERE id = "+ receta.getCodigo();
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

    public void borrar(Receta receta) 
    {
         try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "DELETE FROM recetas WHERE id = " + receta.getCodigo();
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

    public Receta get(int id) 
    {
        Receta receta = new Receta();
        ResultSet resul = null;
        try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "SELECT id, nombre, instrucciones, tiempo_preparacion, porciones, calorias, categoria FROM recetas WHERE id =" + id;
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
            receta.setCodigo(0);
            while(resul.next())
            {
                receta.setCodigo(resul.getInt(1));
                receta.setNombre(resul.getString(2));
                receta.setInstrucciones(resul.getString(3));
                receta.settiempoPreparado(resul.getString(4));
                receta.setPorciones(resul.getInt(5));
                receta.setCalorias(resul.getInt(6));
                receta.setCategoria(resul.getString(7));
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
                return receta;
    }

    public Collection getAll()
    {
        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql= "SELECT id, nombre, instrucciones, tiempo_preparacion, porciones, calorias, categoria FROM recetas";
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
                Receta receta = new Receta();
                receta.setCodigo(resul.getInt(1));
                receta.setNombre(resul.getString(2));
                receta.setInstrucciones(resul.getString(3));
                receta.settiempoPreparado(resul.getString(4));
                receta.setPorciones(resul.getInt(5));
                receta.setCalorias(resul.getInt(6));
                receta.setCategoria(resul.getString(7));
                co.add(receta);
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
            String sql= "SELECT MAX(id)FROM recetas";
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
    


