/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.ds;

import java.sql.Connection;
import org.academia.bean.BTutor;
import org.academia.bean.BUsuario;
import org.academia.dao.DAOTutor;
import org.academia.dao.DAOUsuario;

/**
 *
 * @author davis
 */
public class Test {
    public static void main(String[] args) {
        DSConexion con = new DSConexion();
        con.getConectar();
        
//        BTelefono oBTelefono= new BTelefono();
//        oBTelefono.setIdTelefono(751);
//        oBTelefono.setIdTitular(1);
//        oBTelefono.setTipoTelefono("Nextel");
//        oBTelefono.setNumero("9666327");
//        oBTelefono.setEstado(true);       
//        new DAOTelefono().insertarTelefono(oBTelefono);
// 
       BTutor oBTutor = new BTutor();
       oBTutor.setIdTutor(1);
//        oBTutor.setIdTutor(12345);
//        oBTutor.setNombre("Christian");
//        oBTutor.setApellidoPaterno("Altamirano");
//        oBTutor.setApellidoMaterno("Ayala");
//        oBTutor.setDni("70173243");
//        oBTutor.setDireccion("Av Huanta 2322 sin numero jjeje");
//        oBTutor.setEstado(true);
         
        new DAOTutor().desHabilitarTutor(oBTutor);
    }
}
