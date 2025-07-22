package com.suisegur.gestion_asistencias.controller;

import com.suisegur.gestion_asistencias.model.Permiso;
import com.suisegur.gestion_asistencias.model.Usuario;
import com.suisegur.gestion_asistencias.service.PermisoService;
import com.suisegur.gestion_asistencias.service.UsuarioService;
import com.suisegur.gestion_asistencias.dto.PermisoCreateRequest;
import com.suisegur.gestion_asistencias.dto.PermisoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permisos")
@CrossOrigin(origins = "*")
public class PermisoController {

    @Autowired
    private PermisoService permisoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<PermisoDTO> listar() {
        return permisoService.listar().stream().map(PermisoDTO::new).toList();
    }

    @PostMapping
    public ResponseEntity<?> crearPermiso(@RequestBody PermisoCreateRequest request) {
        Usuario usuario = usuarioService.buscarPorIdentificacion(request.getIdentificacion());
        if (usuario == null) {
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }

        Permiso permiso = new Permiso();
        permiso.setUsuario(usuario);
        permiso.setNivelAutorizacion(request.getNivelAutorizacion());
        permiso.setFechaInicio(request.getFechaInicio());
        permiso.setFechaFin(request.getFechaFin());
        permiso.setDescripcion(request.getDescripcion());

        Permiso guardado = permisoService.guardar(permiso);
        return ResponseEntity.ok(new PermisoDTO(guardado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermisoDTO> obtener(@PathVariable Integer id) {
        return permisoService.obtenerPorId(id)
                .map(permiso -> ResponseEntity.ok(new PermisoDTO(permiso)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        permisoService.eliminar(id);
    }
}