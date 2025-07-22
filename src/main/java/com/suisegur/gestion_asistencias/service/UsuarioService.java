package com.suisegur.gestion_asistencias.service;

import com.suisegur.gestion_asistencias.model.Usuario;
import com.suisegur.gestion_asistencias.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario guardarUsuario(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> obtenerUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public boolean existeEmail(String email) {
        return usuarioRepository.findByEmail(email).isPresent();
    }

    public boolean existeIdentificacion(String identificacion) {
        return usuarioRepository.findByIdentificacion(identificacion).isPresent();
    }

    public Usuario buscarPorIdentificacion(String identificacion) {
        return usuarioRepository.findByIdentificacion(identificacion).orElse(null);
    }

    public Optional<Usuario> loginUsuario(String email, String password) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
        if (usuarioOpt.isPresent() && passwordEncoder.matches(password, usuarioOpt.get().getPassword())) {
            return usuarioOpt;
        }
        return Optional.empty();
    }

}
