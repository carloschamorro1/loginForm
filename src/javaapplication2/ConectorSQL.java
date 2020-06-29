/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class ConectorSQL {
    
    private String url;
    private String driver;
    private static Connection conn = null;
    
   private ConectorSQL() throws SQLException{
       String url = "jdbc:sqlserver://CARLOS:1433;databaseName=TechD;user=carlos.chamorro;password=12345";
       String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
       try{
           Class.forName(driver);
           conn = DriverManager.getConnection(url);
       } catch(ClassNotFoundException | SQLException e){
           JOptionPane.showMessageDialog(null,e,"Error al conectar" + e.getMessage(),JOptionPane.ERROR_MESSAGE);
             e.printStackTrace();
        }
   }
   
   public static Connection getConnection() throws SQLException{
  
        if (conn == null){
            ConectorSQL conectorSQL = new ConectorSQL();
        }

        return conn;
           } // Fin getConnection
   
   
       /*
    
    public void conexion(){
    Connection conexion = null;
    try{
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       String url = "jdbc:sqlserver://CARLOS:1433;databaseName=TechD;user=carlos.chamorro;password=12345";
       conexion = DriverManager.getConnection(url);
       JOptionPane.showMessageDialog(null,"Conectado exitosamente");
    }catch(Exception e){
            JOptionPane.showMessageDialog(null,e,"Error al conectar" + e.getMessage(),JOptionPane.ERROR_MESSAGE);
        }
    }
    
     
   /*
    public void conexion() throws ClassNotFoundException, SQLException{
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    String ruta = "jdbc:sqlserver://CARLOS:1433;databaseName=TechD;user=carlos.chamorro;password=12345";
    Connection con = DriverManager.getConnection(ruta);
        System.out.println("Conexion correcta");
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("select * from Login");
    }
    
    */
}
    
