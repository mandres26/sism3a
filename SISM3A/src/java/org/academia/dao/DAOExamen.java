/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import org.academia.bean.BExamen;
import org.academia.bean.BUsuario;
import org.academia.ds.DSConexion;

public class DAOExamen {
        public static synchronized boolean registrarExamen(BExamen oBExamen) {
        Connection cn = null;
        CallableStatement call = null;
        boolean rpta = false;

        try {
            //nombre del procedimiento almacenado y como espera parametros
            // le ponemos los parametros
            String sql = "{CALL ps_registrarExamen(?,?,?,?)}";
            //obtenemos la conexion
            cn = DSConexion.getConectar();
            //decidimos que vamos a crear un usuario
            cn.setAutoCommit(false);
            //preparamos la sentencia
            call = cn.prepareCall(sql);
            //el siguiente parametro del procedimeinto almacenado es el nombre

            call.registerOutParameter(1, Types.INTEGER);
            call.setString(2, oBExamen.getTipoExamen());
            call.setDate(3, oBExamen.getFecha());
            call.setDouble(4, oBExamen.getNota());
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
        
        public static synchronized ArrayList<BExamen> listarExamen(){
            ArrayList<BExamen> listaExamen= new ArrayList<BExamen>();
            Connection cn=null;
            CallableStatement cl=null;
            ResultSet rs=null;
            
            try {
                String call= "{CALL ps_listarExamen()}";
                cn=DSConexion.getConectar();
                cl=cn.prepareCall(call);
                rs=cl.executeQuery();
                
                while (rs.next()) {
                    BExamen oBExamen= new BExamen();
                    oBExamen.setIdExamen(rs.getInt("idExamen"));
                    oBExamen.setTipoExamen(rs.getString("tipoExamen"));
                    oBExamen.setFecha(rs.getDate("fecha"));
                    oBExamen.setNota(rs.getInt("nota"));
                    listaExamen.add(oBExamen);
                }
                DSConexion.closeCall(cl);
                DSConexion.closeConnection(cn);
            } catch (SQLException e) {
                e.printStackTrace();
                DSConexion.closeCall(cl);
                DSConexion.closeConnection(cn);
            }
            return listaExamen;
                    
        }
}
