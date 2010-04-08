/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.implementacion;

import dominio.EstadoAnimo;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import dao.EstadoAnimDao;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Carolina
 */
public class EstadoAnimoDaoImp extends DataManager implements EstadoAnimDao {

    private Statement stmt;
    private Connection con;
    public void guardar (EstadoAnimo estadoAnimo)
    {
    
     try
     {
         con = super.getConection();
         stmt = con.createStatement();
         String sql = "INSERT INTO estados_animo (nombre, temp_max, temp_min) VALUES"+ "('"+ estadoAnimo.getNombre()+ "',"
                 + estadoAnimo.getTempMax()+ ","+ estadoAnimo.getTempMin()+ ")";
         System.out.println(sql);
         stmt.executeUpdate(sql);
         this.cerrar();
     }
     catch (SQLException e)     {
         while ( e != null)
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
        catch (SQLException e)
        {
          while (e != null)
          {
              e.printStackTrace();
              e.getNextException();
              
          }
        }
    }

    public void modificar(EstadoAnimo estadoAnimo) 
    {
         try {
                con = super.getConection();
                stmt = con.createStatement();
                String sql = " UPDATE estados_animo SET nombre = '" + estadoAnimo.getNombre()+ "',"
             + " temp_max = "+ estadoAnimo.getTempMax() + " ," + "temp_min = " + estadoAnimo.getTempMin()+
                        " WHERE id = " + estadoAnimo.getCodigo();
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

    public void borrar(EstadoAnimo estadoAnimo)
    {
         try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "DELETE FROM estados_animo WHERE id = " + estadoAnimo.getCodigo();
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

    public EstadoAnimo get(int id)
    {
        EstadoAnimo estadoAnimo = new EstadoAnimo();
        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "SELECT id, nombre, temp_max, temp_min FROM estados_animo WHERE id =" + id;
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
            estadoAnimo.setCodigo(0);
            while (resul.next())
            {
                estadoAnimo.setCodigo(resul.getInt(1));
                estadoAnimo.setNombre(resul.getString(2));
                estadoAnimo.setTempMax(resul.getDouble(3));
                estadoAnimo.setTempMin(resul.getDouble(4));
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
             return estadoAnimo;
    }
    
    public Collection getAll() 
    {

        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "SELECT id, nombre, temp_max, temp_min FROM estados_animo ";
            System.out.println();
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
        Collection co = new ArrayList();
         try
        {
            while(resul.next())
            {
                EstadoAnimo estadoAnimo = new EstadoAnimo();
                estadoAnimo.setCodigo(resul.getInt(1));
                estadoAnimo.setNombre(resul.getString(2));
                estadoAnimo.setTempMax(resul.getDouble(3));
                estadoAnimo.setTempMin(resul.getDouble(4));
                co.add(estadoAnimo);

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
