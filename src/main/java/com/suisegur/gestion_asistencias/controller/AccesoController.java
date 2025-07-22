package com.suisegur.gestion_asistencias.controller;

import com.suisegur.gestion_asistencias.model.Acceso;
import com.suisegur.gestion_asistencias.model.Usuario;
import com.suisegur.gestion_asistencias.service.AccesoService;
import com.suisegur.gestion_asistencias.dto.AccesoCreateRequest;
import com.suisegur.gestion_asistencias.dto.AccesoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/accesos")
@CrossOrigin(origins = "*")
public class AccesoController {

    @Autowired
    private AccesoService accesoService;

    @GetMapping
    public List<AccesoDTO> listarAccesos() {
        List<Acceso> accesos = accesoService.listar();
        return accesos.stream().map(AccesoDTO::new).toList();
    }

    @PostMapping
    public ResponseEntity<?> crearAcceso(@RequestBody AccesoCreateRequest request) {
        Usuario usuario = accesoService.buscarUsuarioPorIdentificacion(request.getIdentificacion());
        if (usuario == null) {
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }

        Acceso acceso = new Acceso();
        acceso.setUsuario(usuario);
        acceso.setTipoAcceso(request.getTipoAcceso());
        acceso.setFecha(LocalDate.now());
        acceso.setHora(LocalTime.now());

        Acceso guardado = accesoService.guardar(acceso);
        return ResponseEntity.ok(new AccesoDTO(guardado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acceso> obtenerAccesoPorId(@PathVariable Long id) {
        return accesoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        accesoService.eliminar(id);
    }
}
