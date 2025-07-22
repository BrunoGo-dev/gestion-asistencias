package com.suisegur.gestion_asistencias.repository;

import com.suisegur.gestion_asistencias.model.Acceso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccesoRepository extends JpaRepository<Acceso, Long> {
}
