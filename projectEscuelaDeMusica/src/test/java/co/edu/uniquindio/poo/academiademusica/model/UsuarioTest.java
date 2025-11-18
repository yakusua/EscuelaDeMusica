package co.edu.uniquindio.poo.academiademusica.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void getNombre() {
        Usuario usuario = new UsuarioPrueba("Miguel", "miguel@test.com", "Estudiante");
        assertEquals("Miguel", usuario.getNombre());
    }

    @Test
    void setNombre() {
        Usuario usuario = new UsuarioPrueba("Miguel", "miguel@test.com", "Estudiante");
        usuario.setNombre("Carlos");
        assertEquals("Carlos", usuario.getNombre());
    }

    @Test
    void getEmail() {
        Usuario usuario = new UsuarioPrueba("Miguel", "miguel@test.com", "Estudiante");
        assertEquals("miguel@test.com", usuario.getEmail());
    }

    @Test
    void setEmail() {
        Usuario usuario = new UsuarioPrueba("Miguel", "miguel@test.com", "Estudiante");
        usuario.setEmail("nuevo@test.com");
        assertEquals("nuevo@test.com", usuario.getEmail());
    }

    @Test
    void getRol() {
        Usuario usuario = new UsuarioPrueba("Miguel", "miguel@test.com", "Estudiante");
        assertEquals("Estudiante", usuario.getRol());
    }

    @Test
    void setRol() {
        Usuario usuario = new UsuarioPrueba("Miguel", "miguel@test.com", "Estudiante");
        usuario.setRol("Admin");
        assertEquals("Admin", usuario.getRol());
    }

    @Test
    void registrar() {
        Usuario usuario = new UsuarioPrueba("Miguel", "miguel@test.com", "Estudiante");
        assertDoesNotThrow(usuario::registrar);
    }

    @Test
    void actualizar() {
        Usuario usuario = new UsuarioPrueba("Miguel", "miguel@test.com", "Estudiante");
        assertDoesNotThrow(usuario::actualizar);
    }

    static class UsuarioPrueba extends Usuario {
        public UsuarioPrueba(String n, String e, String r) {
            super(n, e, r);
        }
    }
}
