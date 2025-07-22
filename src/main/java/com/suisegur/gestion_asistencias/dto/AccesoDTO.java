package com.suisegur.gestion_asistencias.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import com.suisegur.gestion_asistencias.model.Acceso;

public class AccesoDTO {
    private Long idAcceso;
    private String usuario; // nombre completo
    private String identificacion;
    private LocalDate fecha;
    private LocalTime hora;
    private String tipoAcceso;

    public AccesoDTO() {
    }

    public AccesoDTO(Acceso acceso) {
        this.idAcceso = acceso.getIdAcceso();
        if (acceso.getUsuario() != null) {
            this.usuario = acceso.getUsuario().getNombre() + " " + acceso.getUsuario().getApellido();
            this.identificacion = acceso.getUsuario().getIdentificacion();
        } else {
            this.usuario = null;
            this.identificacion = null;
        }
        this.fecha = acceso.getFecha();
        this.hora = acceso.getHora();
        this.tipoAcceso = acceso.getTipoAcceso();
    }

    public Long getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(Long idAcceso) {
        this.idAcceso = idAcceso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
