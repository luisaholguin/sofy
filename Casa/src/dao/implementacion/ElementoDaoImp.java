/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.implementacion;

import dao.ElementoDao;
import dominio.Elemento;
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
public class ElementoDaoImp extends DataManager implements ElementoDao
{
    
    private Statement stmt;
    private Connection con;
            
          
    public void guardar(Elemento elemento)
    {
            int registtros = 0;
            try
            {
                con = super.getConection();
                stmt = con.createStatement();
                String sql = " INSERT INTO elementos (nombre, tipo) VALUES "+ "('"+elemento.getNombre()+ 
                        "','"+ elemento.getTipo()+ "')";
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
    private void cerrar() {
        
    
   try  {
        stmt.close();
        con.close();
        
    }
    catch (SQLException e)
    {
        while (e!= null){
            e.printStackTrace();
            e.getNextException();
        }
    }
    }
    public void modificar (Elemento elemento) 
    {
         try {
                con = super.getConection();
                stmt = con.createStatement();
                String sql = " UPDATE elementos SET nombre =' " +  elemento.getNombre()+"',"
             +" tipo = '"+ elemento.getTipo()+ "'WHERE id = "+ elemento.getCodigo();
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
        
    

    public void borrar(Elemento elemento) 
    {
         try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "DELETE FROM elementos WHERE id = " + elemento.getCodigo();
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

    public Elemento get(int id)
    {
        Elemento elemento = new Elemento();
        ResultSet resul = null;
        try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql= "SELECT id, nombre, tipo FROM elementos WHERE id =" + id;
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
        try 
        {
            elemento.setCodigo(0);
            while (resul.next())
            {
                elemento.setCodigo(resul.getInt(1));
                elemento.setNombre(resul.getString(2));
                elemento.setTipo(resul.getString(3));
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
        return elemento;
                
        
    }

    public Collection getAll() 
    {
        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql= "SELECT id, nombre, tipo FROM elementos";
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
                Elemento elemento = new Elemento();
                elemento.setCodigo(resul.getInt(1));
                elemento.setNombre(resul.getString(2));
                elemento.setTipo(resul.getString(3));
                co.add(elemento);
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
    

