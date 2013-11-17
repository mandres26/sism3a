/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.ds;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author davis
 */
public class DSConexion {
   private static  String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
   private static  String url="jdbc:sqlserver://ALONE\\local:1433;databaseName=BD.SISM3A";
   private static  String user="sa";
   private static  String password="123456";
    
  public  static  synchronized  Connection getConectar(){

      Connection cn=null;
      try {
          Class.forName(driver).newInstance();
          cn=DriverManager.getConnection(url, user, password);
          System.out.println("Conexion exitosa");
      }
      catch (Exception e) {
           cn=null;
           System.out.println("Error de conexion");

    }
      return cn;
  }
  
   public synchronized void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar conexion"+e);
        }
    }
   
    public synchronized void closeCall(CallableStatement call){
        try {
            call.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar call"+e);
        }
    }
    
     public synchronized void closeResultset(ResultSet rs){
        try {
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar resultset"+e);
        }
     }
     
         public synchronized void rollBack(Connection cn){
        try {
            cn.rollback();
        } catch (Exception e) {
            System.out.println("Error al hacer rollback"+e);
        }
    }
        
    
}
