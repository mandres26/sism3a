/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import org.academia.bean.BMatricula;
import org.academia.ds.DSConexion;

/**
 *
 * @author davis
 */
public class DAOMatricula {

    public static synchronized boolean registrarAlumno(BMatricula oBMatricula) {
        Connection cn = null;
        CallableStatement call = null;
//        boolean rpta = false;

        try {
            //nombre del procedimiento almacenado y como espera parametros
            // le ponemos los parametros
            String sql = "{CALL ps_registrarMatricula(?,?,?,?,?)}";
            //obtenemos la conexion
            cn = DSConexion.getConectar();
            //decidimos que vamos a crear una transaccion
            cn.setAutoCommit(false);
            //preparamos la sentencia
            call = cn.prepareCall(sql);
            //el siguiente parametro del procedimiennto almacenado es el nombre

            call.setInt(1, oBMatricula.getIdAlumno());
            call.setInt(2, oBMatricula.getIdCiclo());
            call.setInt(3, oBMatricula.getIdSecretario());
            call.setString(4, oBMatricula.getEscuela());
            call.setDouble(5, oBMatricula.getMonto());
            //de 1 es porque el registro de forma correcta los datos
            call.executeUpdate();
            cn.commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            DSConexion.rollBack(cn);
            DSConexion.closeCall(call);
            DSConexion.closeConnection(cn);
            return false;
        }

    }

}
