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
import org.academia.bean.BTipoCobro;
import org.academia.ds.DSConexion;

/**
 *
 * @author davis
 */
public class DAOTipoCobro {

    public static synchronized boolean registrarTipoCobro(BTipoCobro oTipoCobro) {
        Connection cn = null;
        CallableStatement call = null;
        boolean rpta = false;

        try {
            //nombre del procedimiento almacenado y como espera parametros
            // le ponemos los parametros
            String sql = "{CALL ps_registrar_tipo_cobro(?,?,?,?)}";
            //obtenemos la conexion
            cn = DSConexion.getConectar();
            //decidimos que vamos a crear un usuario
            cn.setAutoCommit(false);
            //preparamos la sentencia
            call = cn.prepareCall(sql);
            //el siguiente parametro del procedimeinto almacenado es el nombre

            call.registerOutParameter(1, Types.INTEGER);
            call.setString(2, oTipoCobro.getDenominacion());
            call.setDouble(3, oTipoCobro.getMonto());
            call.setInt(4, oTipoCobro.getIdCiclo());
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

    public synchronized ArrayList<BTipoCobro> listarTipoCobro() {
        Connection cn = null;
        CallableStatement call = null;
        ResultSet rs = null;

        try {
            String sql = "{CALL listarTipoCobro()}";

            cn = new DSConexion().getConectar();
            call = cn.prepareCall(sql);
            rs = call.executeQuery();

            ArrayList<BTipoCobro> lstBTipoCobros = new ArrayList<BTipoCobro>();
            while (rs.next()) {
                BTipoCobro oBTipoCobro = new BTipoCobro();
                
                oBTipoCobro.setIdTipoCobro(rs.getInt(1));
                oBTipoCobro.setDenominacion(rs.getString(2));
                oBTipoCobro.setMonto(rs.getDouble(3));
                oBTipoCobro.setIdCiclo(rs.getInt(4));
                
                lstBTipoCobros.add(oBTipoCobro);
            }

            return lstBTipoCobros;

        } catch (Exception e) {
            System.out.println("Error en listar ciclo Academico" + e);
            return null;
        }
    }
}
