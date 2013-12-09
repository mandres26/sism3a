/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import org.academia.bean.BTutor;
import org.academia.ds.DSConexion;

/**
 *
 * @author ABEL-LP
 */
public class DAOTutor {

    public synchronized int registrarTutor(BTutor oBTutor) {

        Connection cn = null;
        CallableStatement call = null;
        try {
            String sql = "{CALL registrarTutor(?,?,?,?,?,?,?) }";

            cn = new DSConexion().getConectar();
            call = cn.prepareCall(sql);

            call.registerOutParameter(1, Types.INTEGER);
            call.setString(2, oBTutor.getDni());
            call.setString(3, oBTutor.getNombre());
            call.setString(4, oBTutor.getApellidoPaterno());
            call.setString(5, oBTutor.getApellidoMaterno());
            call.setString(6, oBTutor.getDireccion());
            call.setBoolean(7, oBTutor.isEstado());

            call.executeUpdate();
            //recuperamos el idTutor           
            oBTutor.setIdTutor(call.getInt(1));
            return oBTutor.getIdTutor();

        } catch (Exception e) {
            System.out.println("Error al Registrar Tutor: " + e);
            return 0;
        }
    }

    public synchronized boolean habilitarTutor(BTutor oBTutor) {
        CallableStatement call = null;
        Connection cn = null;
        try {
            String sql = "{CALL habilitarTutor(?) }";

            cn = new DSConexion().getConectar();
            call = cn.prepareCall(sql);

            call.setInt(1, oBTutor.getIdTutor());

            call.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al habilitar Tutor: " + e);
            return false;
        }
    }

    public synchronized boolean desHabilitarTutor(BTutor oBTutor) {
        CallableStatement call = null;
        Connection cn = null;
        try {
            String sql = "{CALL ps_Tutor_desHabilitarTutor(?)}";

            cn = new DSConexion().getConectar();
            call = cn.prepareCall(sql);

            call.setInt(1, oBTutor.getIdTutor());

            call.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al desHabilitar Tutor: " + e);
            return false;
        }
    }

    public synchronized ArrayList<BTutor> listarTutor() {

        Connection cn = null;
        CallableStatement call = null;
        ResultSet rs = null;

        ArrayList<BTutor> lstBTutors = new ArrayList<BTutor>();
        try {
            String sql = "{CALL ps_listarTutor()}";

            cn = new DSConexion().getConectar();
            call = cn.prepareCall(sql);
            rs = call.executeQuery();
            while (rs.next()) {

                BTutor oBTutor = new BTutor();
                oBTutor.setIdTutor(rs.getInt(1));
                oBTutor.setDni(rs.getString(2));
                oBTutor.setNombre(rs.getString(3));
                oBTutor.setApellidoPaterno(rs.getString(4));
                oBTutor.setApellidoMaterno(rs.getString(5));
                oBTutor.setDireccion(rs.getString(6));
                oBTutor.setEstado(rs.getBoolean(7));

                lstBTutors.add(oBTutor);
            }

            return lstBTutors;

        } catch (Exception e) {
            System.out.println("Error en listar Tutores" + e);
            return null;
        }
    }

    public synchronized ArrayList<String> detalleTutor(BTutor oBTutor) {
        Connection cn = null;
        CallableStatement call = null;
        ResultSet rs = null;
        ArrayList<String> detalleTutor = new ArrayList<String>();
        try {
            String sql = "{CALL ps_detalleTutor(?)}";

            cn = new DSConexion().getConectar();
            call = cn.prepareCall(sql);
            call.setInt(1, oBTutor.getIdTutor());

            rs = call.executeQuery();

            while (rs.next()) {
                String direccion = new String();
                direccion=String.valueOf(rs.getString(1));
                detalleTutor.add(direccion);
                
                String estado = new String();
                estado=String.valueOf(rs.getBoolean(2));
                detalleTutor.add(estado);
                
                String numero = new String();
                numero=String.valueOf(rs.getString(3));
                detalleTutor.add(numero);
                
                String denominacion = new String();
                denominacion=String.valueOf(rs.getString(4));
                detalleTutor.add(denominacion);
                
            }
        } catch (Exception e) {
            System.out.println("ErrorDA" + e);
            return null;
        }
        return detalleTutor;
    }
}
