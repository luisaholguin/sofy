/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.implementacion;

import dao.PerfilDao;
import dominio.EstadoAnimo;
import dominio.Perfil;
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
public class PerfilDaoImp extends DataManager implements PerfilDao{
    private Statement stmt;
    private Connection con;
    
    

    public void guardar(Perfil perfil) {
           int registros = 0;
        try {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "INSERT INTO perfiles (id_animo, nombre, intensidad_luz,categoria) VALUES "+ 
                    "("+perfil.getEstadoAnimo().getCodigo()+",'"+perfil.getNombre()+ "',"+ perfil.getIntesidadLuz()
                    + ",'"+ perfil.getCategoria()+ "' )";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            this.cerrar();
        }
         catch (SQLException e)
         {
              while (e != null){
                e.printStackTrace();
                e.getNextException();
            }
             
         }   
        }
       
     private void cerrar(){
        try {
            stmt.close();
            con.close();
        }
        catch (SQLException e){
            while (e != null){
                e.printStackTrace();
                e.getNextException();
            }
        }
     }

    public void modificar(Perfil perfil)
    {
         try {
                con = super.getConection();
                stmt = con.createStatement();
                String sql = " UPDATE perfiles SET id_animo =' " + perfil.getEstadoAnimo().getCodigo()+"',"
             +" nombre = '"+ perfil.getNombre()+"',"
             +" intensidad_luz = "+ perfil.getIntesidadLuz()+", categoria = '"+ perfil.getCategoria()+ "' WHERE id = "+ perfil.getCodigo();
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

    public void borrar(Perfil perfil)
    {
         try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "DELETE FROM perfiles WHERE id = " + perfil.getCodigo();
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

    public Perfil get(int id)
    {
        Perfil perfil = new Perfil();
        EstadoAnimo estadoAnimo = new EstadoAnimo();
        ResultSet resul = null;
        try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "SELECT id, id_animo, nombre, intensidad_luz, categoria FROM perfiles WHERE id = "+ id;
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
         try 
        {
            perfil.setCodigo(0);
            while(resul.next())
            {
                perfil.setCodigo(resul.getInt(1));
                estadoAnimo.setCodigo(resul.getInt(2));
                perfil.setEstadoAnimo(estadoAnimo);
                perfil.setNombre(resul.getString(3));
                perfil.setIntesidadLuz(resul.getDouble(4));
                perfil.setCategoria(resul.getString(5));
               
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
        return perfil;
                
    }

    public Collection getAll()
    {
        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "SELECT id, id_animo, nombre, intensidad_luz, categoria FROM perfiles";
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
        Collection co = new ArrayList();
         try
        {
            while(resul.next())
            {
                Perfil perfil = new Perfil();
                EstadoAnimo estadoAnimo = new EstadoAnimo();
                perfil.setCodigo(resul.getInt(1));
                estadoAnimo.setCodigo(resul.getInt(2));
                perfil.setEstadoAnimo(estadoAnimo);
                perfil.setNombre(resul.getString(3));
                perfil.setIntesidadLuz(resul.getDouble(4));
                perfil.setCategoria(resul.getString(5));
                co.add(perfil);

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
            String sql= "SELECT MAX(id)FROM perfiles";
            System.out.println(sql);
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
