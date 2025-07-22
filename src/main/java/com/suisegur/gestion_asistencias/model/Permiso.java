package com.suisegur.gestion_asistencias.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "permisos")
public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPermiso;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private String nivelAutorizacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String descripcion;

    public Long getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Long idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
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
}
