/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.academia.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import org.academia.bean.BSecretario;
import org.academia.ds.DSConexion;

/**
 *
 * @author ABEL-LP
 */
public class DAOSecretario {
    public synchronized int crearSecretario(BSecretario oBSecretario) {

        Connection cn = null;
        CallableStatement call = null;
        try {
            String sql = "{CALL ps_crearSecretario(?,?,?,?,?,?,?) }";

            cn = new DSConexion().getConectar();
            call = cn.prepareCall(sql);

            call.registerOutParameter(1, Types.INTEGER);
            call.setInt(2, oBSecretario.getIdUsuario());
            call.setString(3, oBSecretario.getDni());
            call.setString(4, oBSecretario.getNombre());
            call.setString(5, oBSecretario.getApellidoPaterno());
            call.setString(6, oBSecretario.getApellidoMaterno());
            call.setString(7, oBSecretario.getDireccion());

            call.executeUpdate();
            //recuperamos el idSecretario          
            oBSecretario.setIdSecretario(call.getInt(1));
            return oBSecretario.getIdSecretario();

        } catch (Exception e) {
            System.out.println("Error al Registrar Tutor: " + e);
            return 0;
        }
    }
}
