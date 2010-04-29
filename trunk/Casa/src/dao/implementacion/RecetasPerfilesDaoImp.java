/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementacion;

import dao.RecetasPerfilesDao;
import dominio.PerfilReceta;
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
public class RecetasPerfilesDaoImp extends DataManager implements RecetasPerfilesDao {

    private Statement stmt;
    private Connection con;

    public void guardar(int codReceta, int codPerfil)
    {
        try {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "INSERT INTO recetas_perfiles (id_perfil, id_receta)VALUES" + "(" + codPerfil + "," + codReceta + ")";
            stmt.executeUpdate(sql);
            this.cerrar();
        } catch (SQLException e) {
            while (e != null) {
                e.printStackTrace();
                e.getNextException();
            }
        }

    }

    private void cerrar() {
        try {
            stmt.close();
            con.close();
        } catch (SQLException e) {
            while (e != null) {
                e.printStackTrace();
                e.getNextException();
            }
        }
    }

    public void modificar(int codigo, int codReceta, int codPerfil)
    {
         try 
         {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "UPDATE recetas_perfiles SET id_perfil =" + codPerfil + ",id_receta ="+ codReceta +
                    " WHERE id = "+ codigo ;
            stmt.executeUpdate(sql);
            this.cerrar();
        }
         catch (SQLException e) {
            while (e != null) {
                e.printStackTrace();
                e.getNextException();
            }
        }

    }


    public void borrar(int codigo) 
    {
         try 
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "DELETE FROM recetas_perfiles WHERE id = " + codigo;
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

    

    public void borrarRecetas(int codigoPerfil)
    {
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "DELETE FROM recetas_perfiles WHERE id_perfil = " + codigoPerfil;
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

    /**
     * Este metodo devuelve una coleccion con todos los codigo de recetas asociadas a un perfil
     * @param codPerfil
     * @return
     */
    public Collection getRecetasPerfil(int codPerfil)
    {
        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql= "SELECT id, id_receta, id_perfil FROM recetas_perfiles WHERE id_perfil = "+codPerfil;
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
                PerfilReceta r = new PerfilReceta();
                r.setCodigo(resul.getInt(1));
                r.setCodigoReceta(resul.getInt(2));
                r.setCodigoPerfil(resul.getInt(3));
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

    public int getCodigoReceta(int CodReceta)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Collection getAll()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Collection getRecetasPerfil(int codPerfil, String algo)
    {
        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql= "SELECT id, id_receta, id_perfil FROM recetas_perfiles WHERE id_perfil = "+codPerfil;
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
                PerfilReceta r = new PerfilReceta();
                r.setCodigo(resul.getInt(1));
                r.setCodigoReceta(resul.getInt(2));
                r.setCodigoPerfil(resul.getInt(3));
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
}
