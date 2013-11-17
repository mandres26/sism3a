/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.ds;

import java.sql.Connection;

/**
 *
 * @author davis
 */
public class Test {
    public static void main(String[] args) {
        DSConexion con = new DSConexion();
        con.getConectar();
    }
}
