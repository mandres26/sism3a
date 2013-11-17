/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.ds;

import java.sql.Connection;
import org.academia.bean.BUsuario;
import org.academia.dao.DAOUsuario;

/**
 *
 * @author davis
 */
public class Test {
    public static void main(String[] args) {
        DSConexion con = new DSConexion();
        con.getConectar();
        
        BUsuario oBUsuario= new BUsuario();
        oBUsuario.setIdUsuario(4);
        oBUsuario.setUsuario("abel");
        oBUsuario.setContrasenia("abel");
        oBUsuario.setEstado(true);
        
        new DAOUsuario().crearUsario(oBUsuario);
    }
}
