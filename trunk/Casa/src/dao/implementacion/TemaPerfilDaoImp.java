/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.implementacion;

import dao.TemaPerfilDao;
import dominio.PerfilTema;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Marcelo
 */
public class TemaPerfilDaoImp extends DataManager implements TemaPerfilDao
{
    private Statement stmt;
    private Connection con;

    public void guardar(int codigoPerfil, int codigoTema)
    {
        try
        {
           con = super.getConection();
            stmt = con.createStatement();
            String sql = "INSERT INTO temas_perfiles (id_perfil , id_tema) VALUES"+"(" + codigoPerfil + ","+ codigoTema+ ")";
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


    public void borrarTemas(int codigoPerfil)
    {
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "DELETE FROM temas_perfiles WHERE id_perfil = " + codigoPerfil;
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

    private void cerrar()
    {
        try
        {
            stmt.close();
            con.close();
        }
        catch(SQLException e)
        {
            while (e!= null)
            {
                e.printStackTrace();
                e.getNextException();
            }
        }
    }

    public void modificar(int codigo, int codigoPerfil, int codigoTema)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void borrar(int codigo)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Devuelve una coleccion con todos los temas relacionados con un perfil
     * @param codigoPerfil
     * @return
     */
    public Collection getTemaPerfil(int codigoPerfil)
    {
        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql= "SELECT id, id_tema, id_perfil FROM temas_perfiles WHERE id_perfil = "+codigoPerfil;
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
                PerfilTema r = new PerfilTema();
                r.setCodigo(resul.getInt(1));
                r.setIdTema(resul.getInt(2));
                r.setIdPerfil(resul.getInt(3));
                co.add(r);
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

    public Collection getAll()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
