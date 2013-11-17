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
public class CicloAcademico {
    private int idCiclo;
    private int idTipoCobro;
    private String tipoCiclo;
    private Date fechaInicio;
    private Date fechaFin ;
    private double costo;

    public int getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(int idCiclo) {
        this.idCiclo = idCiclo;
    }

    public int getIdTipoCobro() {
        return idTipoCobro;
    }

    public void setIdTipoCobro(int idTipoCobro) {
        this.idTipoCobro = idTipoCobro;
    }

    public String getTipoCiclo() {
        return tipoCiclo;
    }

    public void setTipoCiclo(String tipoCiclo) {
        this.tipoCiclo = tipoCiclo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

}
