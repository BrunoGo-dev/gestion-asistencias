package com.suisegur.gestion_asistencias.repository;

import com.suisegur.gestion_asistencias.model.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Integer> {
}
