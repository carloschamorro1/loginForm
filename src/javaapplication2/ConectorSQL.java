/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class ConectorSQL {
    
    private static Connection con = null;
    private String driver;
    private String url;
   
    
    private ConectorSQL() throws SQLException{
       String url = "jdbc:sqlserver://CARLOS:1433;"
               + "databaseName=TechD;user=carlos.chamorro;"
               + "password=12345";
       String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
       
       try{
       Class.forName(driver);
       con = DriverManager.getConnection(url);
       } catch(ClassNotFoundException | SQLException e){
                e.printStackTrace();
        }
    }
    
    public static Connection obtenerConexion() throws SQLException{
        if (con == null){
            ConectorSQL conectorSQL = new ConectorSQL(); 
        }
        return con;
    }  
}
