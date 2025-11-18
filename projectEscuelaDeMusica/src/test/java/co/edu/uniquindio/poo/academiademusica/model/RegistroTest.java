package co.edu.uniquindio.poo.academiademusica.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroTest {

    @Test
    void nombreProperty() {
        Registro r = new Registro("Miguel", "80%", "50%");
        assertEquals("Miguel", r.nombreProperty().get());
    }

    @Test
    void asistenciaProperty() {
        Registro r = new Registro("Miguel", "80%", "50%");
        assertEquals("80%", r.asistenciaProperty().get());
    }

    @Test
    void progresoProperty() {
        Registro r = new Registro("Miguel", "80%", "50%");
        assertEquals("50%", r.progresoProperty().get());
    }

    @Test
    void getNombre() {
        Registro r = new Registro("Miguel", "80%", "50%");
        assertEquals("Miguel", r.getNombre());
    }

    @Test
    void getAsistencia() {
        Registro r = new Registro("Miguel", "80%", "50%");
        assertEquals("80%", r.getAsistencia());
    }

    @Test
    void getProgreso() {
        Registro r = new Registro("Miguel", "80%", "50%");
        assertEquals("50%", r.getProgreso());
    }

    @Test
    void setAsistencia() {
        Registro r = new Registro("Miguel", "80%", "50%");
        r.setAsistencia("90%");
        assertEquals("90%", r.getAsistencia());
    }

    @Test
    void setProgreso() {
        Registro r = new Registro("Miguel", "80%", "50%");
        r.setProgreso("60%");
        assertEquals("60%", r.getProgreso());
    }
}
