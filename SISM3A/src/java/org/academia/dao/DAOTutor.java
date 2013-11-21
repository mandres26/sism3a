/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.academia.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import org.academia.bean.BTutor;
import org.academia.ds.DSConexion;

/**
 *
 * @author ABEL-LP
 */
public class DAOTutor {
    public synchronized boolean registrarTutor(BTutor oBTutor){
        CallableStatement call = null;
        Connection cn=null;
        try {
            String sql="{CALL registrarTutor(?,?,?,?,?,?,?) }";
            
            cn = new DSConexion().getConectar();
            call=cn.prepareCall(sql);
            
            call.registerOutParameter(1, Types.INTEGER);
            call.setString(2, oBTutor.getDni());
            call.setString(3, oBTutor.getNombre());
            call.setString(4, oBTutor.getApellidoPaterno());
            call.setString(5, oBTutor.getApellidoMaterno());
            call.setString(6, oBTutor.getDireccion());
            call.setBoolean(7, oBTutor.isEstado());
            
             call.executeUpdate();
            //recuperamos el codigoCobro            
            oBTutor.setIdTutor(call.getInt(1));
            return true;            
            
        } catch (Exception e) {
            System.out.println("Error al Registrar Tutor: "+e);
            return false;
        }    
    }
    public synchronized boolean habilitarTutor(BTutor oBTutor){
        CallableStatement call = null;
        Connection cn=null;
        try {
            String sql="{CALL habilitarTutor(?) }";
            
           cn = new DSConexion().getConectar();
            call = cn.prepareCall(sql);

            call.setInt(1, oBTutor.getIdTutor());

            call.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al habilitar Tutor: "+e);
            return false;
        }    
    }
}
