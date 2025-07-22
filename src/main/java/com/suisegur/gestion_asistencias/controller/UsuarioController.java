package com.suisegur.gestion_asistencias.controller;

import com.suisegur.gestion_asistencias.model.Usuario;
import com.suisegur.gestion_asistencias.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Usuario usuario) {
        if (usuarioService.existeEmail(usuario.getEmail())) {
            return ResponseEntity.badRequest().body("El email ya está registrado.");
        }
        if (usuarioService.existeIdentificacion(usuario.getIdentificacion())) {
            return ResponseEntity.badRequest().body("La identificación ya está registrada.");
        }
        Usuario guardado = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok(guardado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtener(@PathVariable Integer id) {
        return usuarioService.obtenerUsuarioPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarUsuario(@PathVariable Integer id, @RequestBody Usuario usuarioActualizado) {
        Usuario usuarioExistente = usuarioService.obtenerUsuarioPorId(id).orElse(null);
        if (usuarioExistente == null) {
            return ResponseEntity.notFound().build();
        }
        if (!usuarioExistente.getEmail().equals(usuarioActualizado.getEmail()) &&
                usuarioService.existeEmail(usuarioActualizado.getEmail())) {
            return ResponseEntity.badRequest().body("El email ya está registrado.");
        }
        if (!usuarioExistente.getIdentificacion().equals(usuarioActualizado.getIdentificacion()) &&
                usuarioService.existeIdentificacion(usuarioActualizado.getIdentificacion())) {
            return ResponseEntity.badRequest().body("La identificación ya está registrada.");
        }

        usuarioExistente.setTipoUsuario(usuarioActualizado.getTipoUsuario());
        usuarioExistente.setNombre(usuarioActualizado.getNombre());
        usuarioExistente.setApellido(usuarioActualizado.getApellido());
        usuarioExistente.setIdentificacion(usuarioActualizado.getIdentificacion());
        usuarioExistente.setEmail(usuarioActualizado.getEmail());
        usuarioExistente.setTelefono(usuarioActualizado.getTelefono());
        usuarioExistente.setPassword(usuarioActualizado.getPassword());
        usuarioExistente.setEstado(usuarioActualizado.getEstado());

        Usuario actualizado = usuarioService.guardarUsuario(usuarioExistente);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        usuarioService.eliminarUsuario(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return usuarioService.loginUsuario(loginRequest.getEmail(), loginRequest.getPassword())
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).body("No autorizado: credenciales incorrectas"));
    }

    public static class LoginRequest {
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
