/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import org.academia.bean.BUsuario;
import org.academia.ds.DSConexion;

/**
 *
 * @author davis
 */
public class DAOUsuario {
    public static synchronized boolean crearUsario(BUsuario oUsuario){
        Connection cn=null;
        CallableStatement call= null;
        boolean rpta=false;
        
        try {
            //nombre del procedimiento almacenado y como espera parametros
            // le ponemos los parametros
            String sql="{CALL ps_usuario_crear(?,?,?,?)}";
            //obtenemos la conexion
            cn=DSConexion.getConectar();
            //decidimos que vamos a crear un usuario
            cn.setAutoCommit(false);
            //preparamos la sentencia
            call=cn.prepareCall(sql);
            //el siguiente parametro del procedimeinto almacenado es el nombre
            
             call.registerOutParameter(1, Types.INTEGER);
             call.setInt(2, oSalon.getCodigoTutor());
            
        } catch (Exception e) {
        }
    }
    
}
