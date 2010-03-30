/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.implementacion;

import dao.MusicaDao;
import dominio.Musica;
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
public class MusicaDaoImp extends DataManager implements MusicaDao {
    private Statement stmt;
    private Connection con;

    /**
     * Es un metodo para almacenar un tema en la BD
     * @param tema
     */
    public void guardar(Musica tema) 
    {
        
        int registros = 0;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "INSERT INTO musicas (nombre, genero) VALUES" + "('"+ tema.getNombre()+"','"
                    + tema.getGenero()+"')";
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
        catch (SQLException e)
        {
            while (e != null)
            {
                e.printStackTrace();
                e.getNextException();
                
            }
        }
    }

    public void modificar(Musica tema)
    {
       
        try {
                con = super.getConection();
                stmt = con.createStatement();
                String sql = " UPDATE musicas SET nombre =' " +  tema.getNombre()+"',"
             +" genero = '"+ tema.getGenero()+ "'WHERE id = "+ tema.getCodigo();
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

    public void borrar(Musica tema)
    {
         try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "DELETE FROM musicas WHERE id = " + tema.getCodigo();
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

    public Musica get(int id)
    {
        Musica musica = new Musica();
        ResultSet resul = null;
        try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "SELECT id, nombre, genero FROM musicas WHERE id = "+ id;
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
            musica.setCodigo(0);
            while(resul.next())
            {
                musica.setCodigo(resul.getInt(1));
                musica.setNombre(resul.getString(2));
                musica.setGenero(resul.getString(3));
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
        return musica;        
    }

        
        
    

    public Collection getAll()
    {
        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "SELECT id, nombre, genero FROM musicas ";
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
                Musica musica = new Musica();
                musica.setCodigo(resul.getInt(1));
                musica.setNombre(resul.getString(2));
                musica.setGenero(resul.getString(3));
                co.add(musica);
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
