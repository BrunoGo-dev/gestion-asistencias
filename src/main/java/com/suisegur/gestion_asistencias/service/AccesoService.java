package com.suisegur.gestion_asistencias.service;

import com.suisegur.gestion_asistencias.model.Acceso;
import com.suisegur.gestion_asistencias.model.Usuario;
import com.suisegur.gestion_asistencias.repository.AccesoRepository;
import com.suisegur.gestion_asistencias.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccesoService {

    @Autowired
    private AccesoRepository accesoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarUsuarioPorIdentificacion(String identificacion) {
        return usuarioRepository.findByIdentificacion(identificacion).orElse(null);
    }

    public List<Acceso> listar() {
        return accesoRepository.findAll();
    }

    public Acceso guardar(Acceso acceso) {
        return accesoRepository.save(acceso);
    }

    public Optional<Acceso> buscarPorId(Long id) {
        return accesoRepository.findById(id);
    }

    public void eliminar(Long id) {
        accesoRepository.deleteById(id);
    }
}
