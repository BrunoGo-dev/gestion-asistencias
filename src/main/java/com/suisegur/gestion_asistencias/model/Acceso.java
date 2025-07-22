package com.suisegur.gestion_asistencias.model;

import jakarta.persistence.*;
// import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "accesos")

public class Acceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAcceso;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private LocalDate fecha;
    private LocalTime hora;
    private String tipoAcceso;

    public Acceso() {
    }

    public Acceso(Long idAcceso, Usuario usuario, LocalDate fecha, LocalTime hora, String tipoAcceso) {
        this.idAcceso = idAcceso;
        this.usuario = usuario;
        this.fecha = fecha;
        this.hora = hora;
        this.tipoAcceso = tipoAcceso;
    }

    public Long getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(Long idAcceso) {
        this.idAcceso = idAcceso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getTipoAcceso() {
        return tipoAcceso;
    }

    public void setTipoAcceso(String tipoAcceso) {
        this.tipoAcceso = tipoAcceso;
    }
}
