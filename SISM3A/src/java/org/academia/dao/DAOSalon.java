/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.academia.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import org.academia.bean.BSalon;
import org.academia.ds.DSConexion;

/**
 *
 * @author ABEL-LP
 */
public class DAOSalon {

    public synchronized int crearSalon(BSalon oBSalon) {
        
        Connection cn = null;
        CallableStatement call = null;
        try {
            String sql = "{CALL crearSalon(?,?,?,?,?) }";

            cn = new DSConexion().getConectar();
            call = cn.prepareCall(sql);

            call.registerOutParameter(1, Types.INTEGER);
            call.setString(2, oBSalon.getDenominacion());
            call.setInt(3, oBSalon.getCapacidad());
            call.setInt(4, oBSalon.getCantidadActual());
            call.setBoolean(5, oBSalon.isEstado());

            call.executeUpdate();
            //recuperamos el idTutor           
            oBSalon.setIdSalon(call.getInt(1));
            return oBSalon.getIdSalon();

        } catch (Exception e) {
            System.out.println("Error al Registrar Tutor: " + e);
            return 0;
        }
        
    }
    
}
