/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.ds;

import java.sql.Connection;
import java.sql.DriverManager;

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

    }
      return cn;
  }
    
}
