/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.implementacion;

import dao.TemasPerfilesDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

/**
 *
 * @author Carolina
 */
public class TemasPerfilesDaoImp extends DataManager implements TemasPerfilesDao {
      private Statement stmt;
       private Connection con;


    public void guardar(int codPerfil, int codTema) {
        int registros = 0;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "INSERT INTO temas_perfiles (id_perfil, id_tema) VALUES "+ "(" + codPerfil +","+  codTema +")";
            stmt.executeUpdate(sql);
            System.out.println(sql);
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
        catch (SQLException e)
        {  
            while (e!= null) {
            e.printStackTrace();
            e.getNextException();
            }
        }
    }

    
    public void modificar(int codigo, int codPerfil, int codTema) 
    {
         try 
         {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "UPDATE temas_perfiles SET id_perfil =" + codPerfil + ",id_tema ="+ codTema +
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
            String sql = "DELETE FROM temas_perfiles WHERE id = " + codigo;
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

    public int getCodigoPerfil(int codperfil) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getCodigoTema(int CodTema) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Collection getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

}
