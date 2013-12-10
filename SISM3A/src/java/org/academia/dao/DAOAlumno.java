/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.academia.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import org.academia.bean.BAlumno;
import org.academia.ds.DSConexion;

/**
 *
 * @author davis
 */
public class DAOAlumno {
        public static synchronized int registrarAlumno(BAlumno oBAlumno ) {
        Connection cn = null;
        CallableStatement call = null;
//        boolean rpta = false;

        try {
            //nombre del procedimiento almacenado y como espera parametros
            // le ponemos los parametros
            String sql = "{CALL ps_registrarAlumno(?,?,?,?,?,?,?,?,?)}";
            //obtenemos la conexion
            cn = DSConexion.getConectar();
            //decidimos que vamos a crear una transaccion
            cn.setAutoCommit(false);
            //preparamos la sentencia
            call = cn.prepareCall(sql);
            //el siguiente parametro del procedimiennto almacenado es el nombre

            call.registerOutParameter(1, Types.INTEGER);
            call.setInt(2,    oBAlumno.getIdSalon());
            call.setInt(3,    oBAlumno.getIdExamen());
            call.setString(4, oBAlumno.getDni());
            call.setString(5, oBAlumno.getNombre());
            call.setString(6, oBAlumno.getApellidoPaterno());
            call.setString(7, oBAlumno.getApellidoMaterno());
            call.setString(8, oBAlumno.getDireccion());
            call.setBoolean(9, oBAlumno.isEstado());
            // ejecutamos  la sentencia y si nos devuelven el valor 
            //de 1 es porque el registro de forma correcta los datos
            call.executeUpdate();
            cn.commit();
            
            oBAlumno.setIdAlumno(call.getInt(1));
            return oBAlumno.getIdAlumno();

        } catch (Exception e) {
            e.printStackTrace();
            DSConexion.rollBack(cn);
            DSConexion.closeCall(call);
            DSConexion.closeConnection(cn);
            return 0;
        }

    }
}
