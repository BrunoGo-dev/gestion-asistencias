package com.suisegur.gestion_asistencias.dto;

import java.time.LocalDate;

public class PermisoCreateRequest {
    private String identificacion;
    private String nivelAutorizacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String descripcion;

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNivelAutorizacion() {
        return nivelAutorizacion;
    }

    public void setNivelAutorizacion(String nivelAutorizacion) {
        this.nivelAutorizacion = nivelAutorizacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
