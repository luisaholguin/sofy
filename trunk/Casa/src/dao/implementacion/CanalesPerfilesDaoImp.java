/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.implementacion;

import dao.CanalesPerfilesDao;
import dominio.PerfilCanal;
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
public class CanalesPerfilesDaoImp extends DataManager implements CanalesPerfilesDao{

    private Statement stmt;
    private Connection con;

    public void guardar(int codPerfil, int codCanal)
    {
         try {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "INSERT INTO canales_perfiles (id_canal, id_perfil)VALUES" + "(" + codCanal + "," + codPerfil + ")";
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

    public void modificar(int codigo, int codCanal, int codPerfil)
    {
          try 
         {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "UPDATE canales_perfiles SET id_canal =" + codCanal + ",id_perfil ="+ codPerfil +
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
            String sql = "DELETE FROM canales_perfiles WHERE id = " + codigo;
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

    

    public void borrarCanales(int codigoPerfil)
    {
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "DELETE FROM canales_perfiles WHERE id_perfil = " + codigoPerfil;
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

    public Collection getCanalPerfil(int codigoPerfil)
    {
        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql= "SELECT id, id_canal, id_perfil FROM canales_perfiles WHERE id_perfil = "+codigoPerfil;
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
                PerfilCanal r = new PerfilCanal();
                r.setCodigo(resul.getInt(1));
                r.setCodigoCanal(resul.getInt(2));
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

    public Collection getAll()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}