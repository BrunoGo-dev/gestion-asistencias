package com.suisegur.gestion_asistencias.dto;

import java.time.LocalDate;

import com.suisegur.gestion_asistencias.model.Permiso;

// import lombok.Data;

public class PermisoDTO {

    private Long idPermiso;
    private String usuario; // nombre completo
    private String identificacion;// identificacion del usuario
    private String nivelAutorizacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String descripcion;

    public PermisoDTO() {
    }

    public PermisoDTO(Permiso permiso) {
        this.idPermiso = permiso.getIdPermiso();
        if (permiso.getUsuario() != null) {
            this.usuario = permiso.getUsuario().getNombre() + " " + permiso.getUsuario().getApellido();
            this.identificacion = permiso.getUsuario().getIdentificacion();
        } else {
            this.usuario = null;
            this.identificacion = null;
        }
        this.nivelAutorizacion = permiso.getNivelAutorizacion();
        this.fechaInicio = permiso.getFechaInicio();
        this.fechaFin = permiso.getFechaFin();
        this.descripcion = permiso.getDescripcion();
    }

    public Long getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Long idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

}
