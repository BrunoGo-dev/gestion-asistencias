package com.suisegur.gestion_asistencias.repository;

import com.suisegur.gestion_asistencias.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmailAndPassword(String email, String password);

    Optional<Usuario> findByIdentificacion(String identificacion);

    Optional<Usuario> findByEmail(String email);

}
