/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.academia.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import org.academia.bean.BSalon_Tutor;
import org.academia.ds.DSConexion;

/**
 *
 * @author ABEL-LP
 */
public class DAOSalon_Tutor {
    public synchronized boolean registrarSalonTutor(BSalon_Tutor oBSalon_Tutor){
          
        Connection cn = null;
        CallableStatement call = null;
        try {
            String sql = "{CALL registrarSalonTutor(?,?) }";

            cn = new DSConexion().getConectar();
            call = cn.prepareCall(sql);

            call.setInt(1, oBSalon_Tutor.getIdSalon());
            call.setInt(2, oBSalon_Tutor.getIdTutor());

            call.executeUpdate();
            //recuperamos el idTutor           
            return true;

        } catch (Exception e) {
            System.out.println("Error al Registrar Salon_Tutor: " + e);
            return false;
        }
    }
            
}
