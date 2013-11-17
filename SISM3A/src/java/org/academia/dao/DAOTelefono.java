/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.academia.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import org.academia.bean.BTelefono;
import org.academia.ds.DSConexion;

/**
 *
 * @author ABEL-LP
 */
public class DAOTelefono {
    public synchronized boolean insertarTelefono(BTelefono oBTelefono){
        CallableStatement call = null;
        Connection cn=null;
        try {
            String sql="{CALL insertarCobro(?,?,?,?) }";
            
            cn = new DSConexion().getConectar();
            call=cn.prepareCall(sql);
            
            call.registerOutParameter(1, Types.INTEGER);
            call.setInt(2, oBTelefono.getIdTitular());
            call.setString(3, oBTelefono.getTipoTelefono());
            call.setString(4, oBTelefono.getNumero());
            call.setBoolean(4, oBTelefono.isEstado());
            
             call.executeUpdate();
            //recuperamos el codigoCobro            
            oBTelefono.setIdTelefono(call.getInt(1));
            return true;
            
        } catch (Exception e) {
            System.out.println("Error en insertar cobro "+e);
            return false;
        }
    
    }
}
