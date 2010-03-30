/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementacion;

import dao.RecetasPerfilesDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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

    public void modificar(int codigo, int codReceta, int codPerfil)
    {
         try 
         {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "UPDATE recetas_perfiles SET id_perfil =" + codPerfil + ",id_receta ="+ codReceta +
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
            String sql = "DELETE FROM recetas_perfiles WHERE id = " + codigo;
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

    public int getCodigoPerfil(int codPerfil) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getCodigoReceta(int CodReceta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Collection getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
