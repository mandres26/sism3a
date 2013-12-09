/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import org.academia.bean.BUsuario;
import org.academia.ds.DSConexion;

/**
 *
 * @author davis
 */
public class DAOUsuario {

    public static synchronized int crearUsario(BUsuario oUsuario) {
        Connection cn = null;
        CallableStatement call = null;
      

        try {
            //nombre del procedimiento almacenado y como espera parametros
            // le ponemos los parametros
            String sql = "{CALL ps_usuario_crear(?,?,?,?)}";
            cn = new DSConexion().getConectar();
            call = cn.prepareCall(sql);
            
            call.registerOutParameter(1, Types.INTEGER);
            call.setString(2, oUsuario.getUsuario());
            call.setString(3, oUsuario.getContrasenia());
            call.setBoolean(4, oUsuario.isEstado());
            // ejecutamos  la sentencia y si nos devuelven el valor 
            //de 1 es porque el registro de forma correcta los datos
             call.executeUpdate();
            
            oUsuario.setIdUsuario(call.getInt(1));
            return oUsuario.getIdUsuario();
            
            

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

        
    }

    public static synchronized void autentificarUsuario(BUsuario OBUsuario) {
        Connection cn = null;
        CallableStatement call = null;
        ResultSet rs = null;
        String pw = null;
        try {
            String sql = "{ CALL ps_autentificarUsuario(?)}";
            cn = DSConexion.getConectar();
            call = cn.prepareCall(sql);
            call.setString(1, OBUsuario.getUsuario());
            rs = call.executeQuery();

            while (rs.next()) {
                pw = rs.getString("contrasenia");
               if (OBUsuario.getContrasenia().equals(pw)) {
                    OBUsuario.setExiste(1);
                } else {
                    OBUsuario.setExiste(0);
                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }


    }
}
