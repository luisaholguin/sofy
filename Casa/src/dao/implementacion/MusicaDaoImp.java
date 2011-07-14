/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.implementacion;

import dao.MusicaDao;
import dominio.Cancion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;
import vista.util.Utils;

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
    public void guardar(Cancion tema)
    {
        try
        {
            Utils u = new Utils();
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "INSERT INTO temas (nombre, genero, artista, path) VALUES" + "('"+ tema.getNombre()+"','"
                    + tema.getGenero()+"', '"+tema.getArtista().trim()+"', '"+u.reemplazarAzterisco(tema.getPath())+"')";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            this.cerrar();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "No se guardaron los datos","Error de Almacenamiento",JOptionPane.WARNING_MESSAGE);
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

    public void modificar(Cancion tema)
    {
        try {
                con = super.getConection();
                stmt = con.createStatement();
                String sql = " UPDATE temas SET nombre =' " +  tema.getNombre()+"',"
             +" genero = '"+ tema.getGenero()+ "', artista = '"+tema.getArtista().trim()+"', path = '"+tema.getPath().trim()
             +"' WHERE id = "+ tema.getCodigo();
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

    public void borrar(Cancion tema)
    {
         try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "DELETE FROM temas WHERE id = " + tema.getCodigo();
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

    public Cancion get(int id)
    {
        Cancion musica = new Cancion();
        ResultSet resul = null;
        try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "SELECT id, nombre, genero, artista, path FROM temas WHERE id = "+ id;
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
                musica.setArtista(resul.getString(4));
                musica.setPath(resul.getString(5));
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
            String sql = "SELECT id, nombre, genero, artista, path FROM temas ";
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
                Cancion musica = new Cancion();
                musica.setCodigo(resul.getInt(1));
                musica.setNombre(resul.getString(2));
                musica.setGenero(resul.getString(3));
                musica.setArtista(resul.getString(4));
                musica.setPath(resul.getString(5));
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

    public Collection getTemasPerfil(int id)
    {
        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();

            String sql = "SELECT temas.id, temas.nombre, temas.genero, temas.artista, temas.path" +
                    " FROM temas, temas_perfiles" +
                    " WHERE temas_perfiles.id_tema = temas.id AND temas_perfiles.id_perfil = "+id;
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
                Cancion musica = new Cancion();
                musica.setCodigo(resul.getInt(1));
                musica.setNombre(resul.getString(2));
                musica.setGenero(resul.getString(3));
                musica.setArtista(resul.getString(4));
                musica.setPath(resul.getString(5));
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
