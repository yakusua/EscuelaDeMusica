package co.edu.uniquindio.poo.academiademusica.model;

import co.edu.uniquindio.poo.academiademusica.model.enums.Instrumento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfesorTest {

    @Test
    void getIdProfesor() {
        Profesor p = new Profesor("Ana", "ana@a.com", "P01", Instrumento.PIANO, "Clásico");
        assertEquals("P01", p.getIdProfesor());
    }

    @Test
    void setIdProfesor() {
        Profesor p = new Profesor("Ana", "ana@a.com", "P01", Instrumento.PIANO, "Clásico");
        p.setIdProfesor("P99");
        assertEquals("P99", p.getIdProfesor());
    }

    @Test
    void getInstrumento() {
        Profesor p = new Profesor("Ana", "ana@a.com", "P01", Instrumento.GUITARRA, "Moderno");
        assertEquals(Instrumento.GUITARRA, p.getInstrumento());
    }

    @Test
    void setInstrumento() {
        Profesor p = new Profesor("Ana", "ana@a.com", "P01", Instrumento.VIOLIN, "Clásico");
        p.setInstrumento(Instrumento.BATERIA);
        assertEquals(Instrumento.BATERIA, p.getInstrumento());
    }

    @Test
    void getEspecialidad() {
        Profesor p = new Profesor("Ana", "ana@a.com", "P01", Instrumento.PIANO, "Jazz");
        assertEquals("Jazz", p.getEspecialidad());
    }

    @Test
    void setEspecialidad() {
        Profesor p = new Profesor("Ana", "ana@a.com", "P01", Instrumento.PIANO, "Jazz");
        p.setEspecialidad("Rock");
        assertEquals("Rock", p.getEspecialidad());
    }

    @Test
    void gestionarHorario() {
        Profesor p = new Profesor("Ana", "ana@a.com", "P01", Instrumento.PIANO, "Clásico");
        assertDoesNotThrow(p::gestionarHorario);
    }

    @Test
    void registrarAsistencia() {
        Profesor p = new Profesor("Ana", "ana@a.com", "P01", Instrumento.PIANO, "Clásico");
        assertDoesNotThrow(() -> p.registrarAsistencia("Carlos"));
    }

    @Test
    void crearClase() {
        Profesor p = new Profesor("Ana", "ana@a.com", "P01", Instrumento.PIANO, "Clásico");
        assertDoesNotThrow(() -> p.crearClase("Piano Básico"));
    }
}
