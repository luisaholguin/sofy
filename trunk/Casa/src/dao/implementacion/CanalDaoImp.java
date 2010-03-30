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
      int registros = 0;
      try {
          con = super.getConection();
          stmt = con.createStatement();
          String sql = "INSERT INTO Canales (nombre , frecuencia) VALUES " + "('"+ canal.getNombre()+ "',"
                  + canal.getFrecuencia()+")" ;
          System.out.println(sql);
          registros = stmt.executeUpdate(sql);
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
                String sql = " UPDATE canales SET nombre =' " +  canal.getNombre()+"',"
             +" frecuencia = '"+ canal.getFrecuencia()+ "'WHERE id = "+ canal.getCodigo();
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

    public void borrar(Canal canal)
    {
         try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "DELETE FROM canales WHERE id = " + canal.getCodigo();
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

    public Canal get(int id)     
    {
        Canal canal = new Canal();
        ResultSet resul = null;
        try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "SELECT id, nombre, frecuencia FROM canales WHERE id =" + id;
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
            canal.setCodigo(0);
            while(resul.next())
            {
                canal.setCodigo(resul.getInt(1));
                canal.setNombre(resul.getString(2));
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

    public Collection getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
