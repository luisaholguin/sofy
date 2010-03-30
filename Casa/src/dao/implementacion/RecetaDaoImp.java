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
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public class RecetaDaoImp extends DataManager implements RecetaDao {
    private Statement stmt;
    private Connection con;
    

    public void guardar(Receta receta) {
        int registros = 0;
        try
        {
            con= super.getConection();
            stmt = con.createStatement();
            String sql = "INSERT INTO recetas (nombre, instrucciones, tiempo_preparacion,porciones , calorias) VALUES " +
                    "('"+ receta.getNombre()+ "','"+ receta.getInstrucciones()+  "','" + receta.gettiempoPreparado() +"',"
                    + receta.getPorciones()+ ","+receta.getCalorias()+ ")";
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
                        "porciones =" + receta.getPorciones()+ ", calorias = " + receta.getCalorias() + " WHERE id = "+ receta.getCodigo();
                System.out.println(sql);
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

    public Receta get(int id) 
    {
        Receta receta = new Receta();
        ResultSet resul = null;
        try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "SELECT id, nombre, instrucciones, tiempo_preparacion, porciones, calorias FROM recetas WHERE id =" + id;
            System.out.println(sql);
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

    public Collection getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

}
