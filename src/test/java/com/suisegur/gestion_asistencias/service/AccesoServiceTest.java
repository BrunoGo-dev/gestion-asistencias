package com.suisegur.gestion_asistencias.service;

import com.suisegur.gestion_asistencias.model.Acceso;
import com.suisegur.gestion_asistencias.model.Usuario;
import com.suisegur.gestion_asistencias.repository.AccesoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccesoServiceTest {

    @Autowired
    private AccesoService accesoService;

    @MockBean
    private AccesoRepository accesoRepository;

    @Test
    public void testListarAccesos() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        Acceso acceso1 = new Acceso(1L, usuario, LocalDate.now(), LocalTime.now(), "Entrada");
        Acceso acceso2 = new Acceso(2L, usuario, LocalDate.now(), LocalTime.now(), "Salida");
        Mockito.when(accesoRepository.findAll()).thenReturn(Arrays.asList(acceso1, acceso2));
        List<Acceso> accesos = accesoService.listar();
        assertEquals(2, accesos.size());
    }

    @Test
    public void testGuardarAcceso() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        Acceso acceso = new Acceso(null, usuario, LocalDate.now(), LocalTime.now(), "Entrada");
        Mockito.when(accesoRepository.save(acceso)).thenReturn(acceso);
        Acceso guardado = accesoService.guardar(acceso);
        assertNotNull(guardado);
        assertEquals("Entrada", guardado.getTipoAcceso());
    }

}