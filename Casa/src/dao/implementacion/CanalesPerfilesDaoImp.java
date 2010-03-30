/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.implementacion;

import dao.CanalesPerfilesDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public class CanalesPerfilesDaoImp extends DataManager implements CanalesPerfilesDao{

    private Statement stmt;
    private Connection con;

    public void guardar(int codCanal, int codPerfil) 
    {
         try {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "INSERT INTO canales_perfiles (id_canal, id_perfil)VALUES" + "(" + codCanal + "," + codPerfil + ")";
            System.out.println(sql);
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
            System.out.println(sql);
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

    public int getCodigoCanal(int codCanal) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getCodigoPerfil(int CodPerfil) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Collection getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

     


