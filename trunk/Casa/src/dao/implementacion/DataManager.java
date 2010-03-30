/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.implementacion;

import java.sql.*;
//import java.io.*;
import javax.swing.JOptionPane;

/** Esta clase es la responsable de establecer la conexion con la base de datos y brindar
 * el statemen para poder interactuar con ella.
 *
 * @author Marcelo
 */

public class DataManager 
{
    private String driver;
    private Connection conn;
    public Statement st;
    private String dsn = "";
    
  /** getConection() devuelve la conexion a la base de datos
 */
public void defDriver()
{
    //Defino el tipo de driver con el nombre y nada mas
    this.driver= "org.postgresql.Driver";
}
    
 public Connection  getConection()
 {
    defDriver();
//    dsn = "jdbc:postgresql://192.168.1.3:5432/sat1?";
    
//    dsn = "jdbc:postgresql://192.168.81.100:5432/sat2?";
//    dsn = "jdbc:postgresql://127.0.0.1:5432/Despensa?";
    dsn = "jdbc:postgresql://localhost:5432/casa?";
    try
    {
      /** creo la conexion para el caso de usar una base de datos Postgres */
        Class.forName(driver);
      conn = DriverManager.getConnection(dsn+"user=postgres&password=postgres");
//      conn = DriverManager.getConnection(dsn+"user=usuario&password=usuario");
    }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo conectar a la Base de Datos","Error de Conexión...",JOptionPane.WARNING_MESSAGE);
//        System.out.println("Error conexion");
//        System.out.println("dentro del catch "+ex.getMessage());
    }
    return conn;
 }
 
 
 
/** getStat(Connection co) devuelve el statement para poder empezar a ejecutar
 * sentencias SQL
 */
 public Statement getStat(Connection co)
 {
   try
    {
      // creo el Statement
      Statement stmt = co.createStatement();
      st = stmt;
    }
  catch (SQLException sqle)
  {
    sqle.printStackTrace();
  }
   return st;
 }
 
}
    