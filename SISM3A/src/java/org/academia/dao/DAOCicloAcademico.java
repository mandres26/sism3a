/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import org.academia.bean.BCicloAcademico;
import org.academia.ds.DSConexion;

/**
 *
 * @author davis
 */
public class DAOCicloAcademico {
        public static synchronized boolean registrarCicloAcademico(BCicloAcademico oBCicloAcademico) {
        Connection cn = null;
        CallableStatement call = null;
        boolean rpta = false;

        try {
            //nombre del procedimiento almacenado y como espera parametros
            // le ponemos los parametros
            String sql = "{CALL ps_registrar_ciclo_academico(?,?,?,?,?,?)}";
            //obtenemos la conexion
            cn = DSConexion.getConectar();
            //decidimos que vamos a crear una transaccion
            cn.setAutoCommit(false);
            //preparamos la sentencia
            call = cn.prepareCall(sql);
            //el siguiente parametro del procedimiennto almacenado es el nombre

            call.registerOutParameter(1, Types.INTEGER);
            call.setInt(2, oBCicloAcademico.getIdTipoCobro());
            call.setString(3, oBCicloAcademico.getTipoCiclo());
            call.setDate(4, oBCicloAcademico.getFechaInicio());
            call.setDate(5, oBCicloAcademico.getFechaFin());
            call.setDouble(6, oBCicloAcademico.getCosto());
            // ejecutamos  la sentencia y si nos devuelven el valor 
            //de 1 es porque el registro de forma correcta los datos
            rpta = call.executeUpdate() == 1 ? true : false;
            if (rpta) {
                //confirmamos la transaccion
                cn.commit();
            } else {
                //negamos la insercion
                DSConexion.rollBack(cn);
            }
            DSConexion.closeCall(call);
            DSConexion.closeConnection(cn);

        } catch (Exception e) {
            e.printStackTrace();
            DSConexion.rollBack(cn);
            DSConexion.closeCall(call);
            DSConexion.closeConnection(cn);
        }

        return rpta;
    }
    
}
