package com.suisegur.gestion_asistencias.service;

import com.suisegur.gestion_asistencias.model.Permiso;
import com.suisegur.gestion_asistencias.repository.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermisoService {

    @Autowired
    private PermisoRepository permisoRepository;

    public List<Permiso> listar() {
        return permisoRepository.findAll();
    }

    public Permiso guardar(Permiso permiso) {
        return permisoRepository.save(permiso);
    }

    public Optional<Permiso> obtenerPorId(Integer id) {
        return permisoRepository.findById(id);
    }

    public void eliminar(Integer id) {
        permisoRepository.deleteById(id);
    }

}
