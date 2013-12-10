/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import org.academia.bean.BCicloAcademico;
import org.academia.bean.BTutor;
import org.academia.ds.DSConexion;

/**
 *
 * @author davis
 */
public class DAOCicloAcademico {

    public static synchronized int registrarCicloAcademico(BCicloAcademico oBCicloAcademico) {
        Connection cn = null;
        CallableStatement call = null;
//        boolean rpta = false;

        try {
            //nombre del procedimiento almacenado y como espera parametros
            // le ponemos los parametros
            String sql = "{CALL ps_registrar_ciclo_academico(?,?,?,?,?)}";
            //obtenemos la conexion
            cn = DSConexion.getConectar();
            //decidimos que vamos a crear una transaccion
            cn.setAutoCommit(false);
            //preparamos la sentencia
            call = cn.prepareCall(sql);
            //el siguiente parametro del procedimiennto almacenado es el nombre

            call.registerOutParameter(1, Types.INTEGER);
            call.setString(2, oBCicloAcademico.getTipoCiclo());
            call.setDate(3, oBCicloAcademico.getFechaInicio());
            call.setDate(4, oBCicloAcademico.getFechaFin());
            call.setDouble(5, oBCicloAcademico.getCosto());
            // ejecutamos  la sentencia y si nos devuelven el valor 
            //de 1 es porque el registro de forma correcta los datos
            call.executeUpdate();
            cn.commit();
            
            oBCicloAcademico.setIdCiclo(call.getInt(1));
            return oBCicloAcademico.getIdCiclo();

        } catch (Exception e) {
            e.printStackTrace();
            DSConexion.rollBack(cn);
            DSConexion.closeCall(call);
            DSConexion.closeConnection(cn);
            return 0;
        }

    }
    
     public synchronized String mostrarCicloAcademico(int codigoCicloAcademico) {

        Connection cn = null;
        CallableStatement call = null;
        ResultSet rs = null;

        BCicloAcademico oBCicloAcademico = new BCicloAcademico();
        try {
            String sql = "{CALL ps_mostrarCicloAcademico(?)}";

            cn = new DSConexion().getConectar();
            call = cn.prepareCall(sql);
            call.setInt(1,codigoCicloAcademico);
            
            rs = call.executeQuery();
            while (rs.next()) {

                oBCicloAcademico.setTipoCiclo(rs.getString(1));

            }
            
            return oBCicloAcademico.getTipoCiclo();

        } catch (Exception e) {
            System.out.println("Error en mostrar ciclo" + e);
            return null;
        }
    }

    public synchronized int listarCicloA() {
        Connection cn = null;
        CallableStatement call = null;
        ResultSet rs = null;

        
        try {
            String sql = "{CALL listarCicloA()}";

            cn = new DSConexion().getConectar();
            call = cn.prepareCall(sql);
            rs = call.executeQuery();
            BCicloAcademico OBCicloAcad = new BCicloAcademico();
            while (rs.next()) {

                
                OBCicloAcad.setIdCiclo(rs.getInt(1));
               

                
            }

            return OBCicloAcad.getIdCiclo();

        } catch (Exception e) {
            System.out.println("Error en listar ciclo Academico" + e);
            return 0;
        }
    }

}
