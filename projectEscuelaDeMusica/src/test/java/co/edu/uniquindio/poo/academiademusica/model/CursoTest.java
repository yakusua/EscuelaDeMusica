package co.edu.uniquindio.poo.academiademusica.model;

import co.edu.uniquindio.poo.academiademusica.model.enums.Instrumento;
import co.edu.uniquindio.poo.academiademusica.model.enums.Nivel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CursoTest {

    @Test
    void getCapacidad() {
        Curso curso = new Curso(10, Instrumento.PIANO, Nivel.PRINCIPIANTE);
        assertEquals(10, curso.getCapacidad());
    }

    @Test
    void setCapacidad() {
        Curso curso = new Curso(5, Instrumento.GUITARRA, Nivel.INTERMEDIO);
        curso.setCapacidad(15);
        assertEquals(15, curso.getCapacidad());
    }

    @Test
    void getListClases() {
        Curso curso = new Curso(10, Instrumento.VIOLIN, Nivel.AVANZADO);
        assertNotNull(curso.getListClases());
        assertTrue(curso.getListClases().isEmpty());
    }

    @Test
    void setListClases() {
        Curso curso = new Curso(10, Instrumento.VIOLIN, Nivel.AVANZADO);
        List<Clase> clases = new ArrayList<>();
        curso.setListClases(clases);
        assertEquals(clases, curso.getListClases());
    }

    @Test
    void getNivel() {
        Curso curso = new Curso(10, Instrumento.PIANO, Nivel.PRINCIPIANTE);
        assertEquals(Nivel.PRINCIPIANTE, curso.getNivel());
    }

    @Test
    void setNivel() {
        Curso curso = new Curso(10, Instrumento.PIANO, Nivel.PRINCIPIANTE);
        curso.setNivel(Nivel.AVANZADO);
        assertEquals(Nivel.AVANZADO, curso.getNivel());
    }

    @Test
    void getInstrumento() {
        Curso curso = new Curso(10, Instrumento.GUITARRA, Nivel.INTERMEDIO);
        assertEquals(Instrumento.GUITARRA, curso.getInstrumento());
    }

    @Test
    void setInstrumento() {
        Curso curso = new Curso(10, Instrumento.GUITARRA, Nivel.INTERMEDIO);
        curso.setInstrumento(Instrumento.GUITARRA);
        assertEquals(Instrumento.GUITARRA, curso.getInstrumento());
    }

    @Test
    void getIdCurso() {
        Curso curso = new Curso(10, Instrumento.PIANO, Nivel.PRINCIPIANTE);
        // Actualmente retorna null
        assertNull(curso.getIdCurso());
    }
}
