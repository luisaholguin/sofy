/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.implementacion;

import dao.ContenedorDao;
import dominio.Contenedor;
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
public class ContenedorDaoImp extends DataManager implements ContenedorDao {

     private Statement stmt;
     private Connection con;
     
    public void guardar(Contenedor contenedor) {
        try {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "INSERT INTO contenedor (nombre, cantidad, id_elemento) VALUES "+ "('"+contenedor.getNombre().trim()+"',"
                    + contenedor.getCantidad()+"," +contenedor.getElemento().getCodigo()+ ")";
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

    public void modificar(Contenedor contenedor)
    {
        try {
                con = super.getConection();
                stmt = con.createStatement();
                String sql = " UPDATE contenedor SET nombre = '" +  contenedor.getElemento().getNombre().trim()+"', cantidad = " +
                        contenedor.getCantidad()+ ", id_elemento = " + contenedor.getElemento().getCodigo() + " WHERE id = "+ contenedor.getCodigo();
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

    public void borrar(Contenedor contenedor)
    {
         try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "DELETE FROM contenedor WHERE id = " + contenedor.getCodigo();
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

    public Contenedor get(int id) 
    {
       Contenedor contenedor  = new Contenedor();
       Elemento elemento = new Elemento();
       ResultSet resul = null;
       try
       {
           con = super.getConection();
           stmt = con.createStatement();
           String sql = "SELECT id, nombre, cantidad, id_elemento FROM contenedor WHERE id =" + id;
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
           contenedor.setCodigo(0);
           while(resul.next())
           {
           contenedor.setCodigo(resul.getInt(1));
           contenedor.setNombre(resul.getString(2));
           contenedor.setCantidad(resul.getDouble(3));
           elemento.setCodigo(resul.getInt(4));
           contenedor.setElemento(elemento);
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
        return contenedor;
    }



    public Contenedor get(String nombre)
    {
       Contenedor contenedor  = new Contenedor();
       Elemento elemento = new Elemento();
       ResultSet resul = null;
       try
       {
           con = super.getConection();
           stmt = con.createStatement();
           String sql = "SELECT id, nombre, cantidad, id_elemento FROM contenedor WHERE nombre = '" + nombre.trim()+"'";
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
           contenedor.setCodigo(0);
           while(resul.next())
           {
           contenedor.setCodigo(resul.getInt(1));
           contenedor.setNombre(resul.getString(2));
           contenedor.setCantidad(resul.getDouble(3));
           elemento.setCodigo(resul.getInt(4));
           contenedor.setElemento(elemento);
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
        return contenedor;
    }





    public Collection getAll() 
    {
        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "SELECT id, nombre, cantidad, id_elemento FROM contenedor ";
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
        Collection co = new ArrayList ();
        try
        {
            while ( resul.next())
            {
                Contenedor contenedor = new Contenedor();
                Elemento elemento = new Elemento();
                contenedor.setCodigo(resul.getInt(1));
                contenedor.setNombre(resul.getString(2));
                contenedor.setCantidad(resul.getDouble(3));
                elemento.setCodigo(resul.getInt(4));
                elemento.setNombre(contenedor.getNombre());
                contenedor.setElemento(elemento);
                co.add(contenedor);
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
