/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.implementacion;

import dao.VariablesDao;
import dominio.Variable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author marcelo
 */
public class VariablesDaoImp extends DataManager implements VariablesDao
{
    
    private Statement stmt;
    private Connection con;

    public Variable get(int id)
    {
        Variable variable = new Variable();
        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "SELECT id, nombre FROM variables WHERE id =" + id;
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
            variable.setId(0);
            while (resul.next())
            {
                variable.setId(resul.getInt(1));
                variable.setNombre(resul.getString(2));
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
      return variable;
    }

    public Collection getAll()
    {
        ResultSet resul = null;
        try
        {
            con = super.getConection();
            stmt = con.createStatement();
            String sql = "SELECT id, nombre FROM variables";
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
                Variable v = new Variable();
                v.setId(resul.getInt(1));
                v.setNombre(resul.getString(2));
                co.add(v);
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

}
