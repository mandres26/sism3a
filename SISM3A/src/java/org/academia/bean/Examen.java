/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.bean;

import java.sql.Date;

/**
 *
 * @author ABEL-LP
 */
public class Examen {
    private int idExamen;
    private String tipoExamen;
    private Date fecha;
    private double nota;

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
