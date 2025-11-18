package co.edu.uniquindio.poo.academiademusica.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HorarioTest {

    @Test
    void getDia() {
        Horario h = new Horario("Lunes", "10:00");
        assertEquals("Lunes", h.getDia());
    }

    @Test
    void setDia() {
        Horario h = new Horario("Lunes", "10:00");
        h.setDia("Martes");
        assertEquals("Martes", h.getDia());
    }

    @Test
    void diaProperty() {
        Horario h = new Horario("Lunes", "10:00");
        assertNotNull(h.diaProperty());
        assertEquals("Lunes", h.diaProperty().get());
    }

    @Test
    void getHora() {
        Horario h = new Horario("Lunes", "10:00");
        assertEquals("10:00", h.getHora());
    }

    @Test
    void setHora() {
        Horario h = new Horario("Lunes", "10:00");
        h.setHora("14:30");
        assertEquals("14:30", h.getHora());
    }

    @Test
    void horaProperty() {
        Horario h = new Horario("Lunes", "10:00");
        assertNotNull(h.horaProperty());
        assertEquals("10:00", h.horaProperty().get());
    }
}
