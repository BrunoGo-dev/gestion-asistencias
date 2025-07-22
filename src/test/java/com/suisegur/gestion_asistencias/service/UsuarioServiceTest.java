package com.suisegur.gestion_asistencias.service;

import com.suisegur.gestion_asistencias.model.Usuario;
import com.suisegur.gestion_asistencias.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsuarioServiceTest {

    @Autowired
    private UsuarioService usuarioService;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @Test
    public void testExisteEmail() {
        Usuario usuario = new Usuario();
        usuario.setEmail("test@email.com");
        Mockito.when(usuarioRepository.findByEmail("test@email.com"))
                .thenReturn(Optional.of(usuario));
        assertTrue(usuarioService.existeEmail("test@email.com"));
    }

    @Test
    public void testExisteIdentificacion() {
        Usuario usuario = new Usuario();
        usuario.setIdentificacion("12345678");
        Mockito.when(usuarioRepository.findByIdentificacion("12345678"))
                .thenReturn(Optional.of(usuario));
        assertTrue(usuarioService.existeIdentificacion("12345678"));
    }

    @Test
    public void testNoExisteEmail() {
        Mockito.when(usuarioRepository.findByEmail("noexiste@email.com"))
                .thenReturn(Optional.empty());
        assertFalse(usuarioService.existeEmail("noexiste@email.com"));
    }

    @Test
    public void testNoExisteIdentificacion() {
        Mockito.when(usuarioRepository.findByIdentificacion("00000000"))
                .thenReturn(Optional.empty());
        assertFalse(usuarioService.existeIdentificacion("00000000"));
    }

    @Test
    public void testBuscarPorIdentificacion() {
        Usuario usuario = new Usuario();
        usuario.setIdentificacion("87654321");
        Mockito.when(usuarioRepository.findByIdentificacion("87654321"))
                .thenReturn(Optional.of(usuario));
        assertEquals(usuario, usuarioService.buscarPorIdentificacion("87654321"));
    }
}