/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.implementacion;

import dao.CanalDao;
import dominio.Canal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Carolina
 * 
 */

public class CanalDaoImp extends DataManager implements CanalDao {
    
    private Statement stmt;
    private Connection con;

    public void guardar(Canal canal) {
      try {
          con = super.getConection();
          stmt = con.createStatement();
          String sql = "INSERT INTO Canales (nombre , frecuencia) VALUES " + "('"+ canal.getNombreCanal()+ "',"
                  + canal.getFrecuencia()+")" ;
          stmt.executeUpdate(sql);
          this.cerrar();
      }
      catch (SQLException e){
          while (e != null){
              e.printStackTrace();
              e.getNextException();
          }
      }
    }
    
    private void cerrar (){
        try{
            stmt.close();
            con.close();
        }
        catch (SQLException e){
            while (e!= null){
                e.printStackTrace();
                e= e.getNextException();
            }
        }
    }

    public void modificar(Canal canal)
    {
         try {
                con = super.getConection();
                stmt = con.createStatement();
                String sql = " UPDATE canales SET nombre =' " +  canal.getNombreCanal()+"',"
             +" frecuencia = '"+ canal.getFrecuencia()+ "'WHERE id = "+ canal.getCodigo();
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

    public void borrar(Canal canal)
    {
         try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "DELETE FROM canales WHERE id = " + canal.getCodigo();
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

    public Canal get(int id)     
    {
        Canal canal = new Canal();
        ResultSet resul = null;
        try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "SELECT id, nombre, frecuencia FROM canales WHERE id =" + id;
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
            canal.setCodigo(0);
            while(resul.next())
            {
                canal.setCodigo(resul.getInt(1));
                canal.setNombreCanal(resul.getString(2));
                canal.setFrecuencia(resul.getInt(3));
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
        return canal;        
    }

    public Collection getAll() 
    {
        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "SELECT id, nombre, frecuencia FROM canales ";
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
                Canal canal = new Canal();
                canal.setCodigo(resul.getInt(1));
                canal.setNombreCanal(resul.getString(2));
                canal.setFrecuencia(resul.getInt(3));
                co.add(canal);
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

    public Collection getCanalesPerfil(int id)
    {
        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "SELECT canales.id, canales.nombre, canales.frecuencia" +
                    " FROM canales, canales_perfiles" +
                    " WHERE canales_perfiles.id_canal = canales.id AND canales_perfiles.id_perfil = "+id;
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
                Canal canal = new Canal();
                canal.setCodigo(resul.getInt(1));
                canal.setNombreCanal(resul.getString(2));
                canal.setFrecuencia(resul.getInt(3));
                co.add(canal);
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
