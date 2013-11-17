/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.bean;

import java.sql.Date;

/**
 *
 * @author davis
 */
public class BSalon_Tutor {
    private int idSalon;
    private int idTutor;
    private Date fechaAsignacion;
    private Date fechaFin;

    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
