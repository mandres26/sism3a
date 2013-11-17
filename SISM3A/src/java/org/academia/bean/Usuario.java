/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.bean;

/**
 *
 * @author davis
 */
public class Usuario {
    private int idUsuario; 
    private String usuario; 
    private String contrasenia; 
    private boolean estado ;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
