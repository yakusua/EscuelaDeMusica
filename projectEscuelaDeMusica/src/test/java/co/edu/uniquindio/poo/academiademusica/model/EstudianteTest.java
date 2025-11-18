package co.edu.uniquindio.poo.academiademusica.model;

import co.edu.uniquindio.poo.academiademusica.model.enums.Nivel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstudianteTest {

    @Test
    void getIdEstudiante() {
        Estudiante e = new Estudiante("Juan", "juan@a.com", "E01", 15, Nivel.PRINCIPIANTE, "Piano", 0, 0);
        assertEquals("E01", e.getIdEstudiante());
    }

    @Test
    void setIdEstudiante() {
        Estudiante e = new Estudiante("Ana", "ana@a.com", "E02", 14, Nivel.INTERMEDIO, "Guitarra", 0, 0);
        e.setIdEstudiante("E99");
        assertEquals("E99", e.getIdEstudiante());
    }

    @Test
    void getEdad() {
        Estudiante e = new Estudiante("Juan", "juan@a.com", "E01", 15, Nivel.PRINCIPIANTE, "Piano", 0, 0);
        assertEquals(15, e.getEdad());
    }

    @Test
    void setEdad() {
        Estudiante e = new Estudiante("Ana", "ana@a.com", "E02", 14, Nivel.INTERMEDIO, "Guitarra", 0, 0);
        e.setEdad(20);
        assertEquals(20, e.getEdad());
    }

    @Test
    void getNivel() {
        Estudiante e = new Estudiante("Juan", "juan@a.com", "E01", 15, Nivel.PRINCIPIANTE, "Piano", 0, 0);
        assertEquals(Nivel.PRINCIPIANTE, e.getNivel());
    }

    @Test
    void setNivel() {
        Estudiante e = new Estudiante("Ana", "ana@a.com", "E02", 14, Nivel.INTERMEDIO, "Guitarra", 0, 0);
        e.setNivel(Nivel.AVANZADO);
        assertEquals(Nivel.AVANZADO, e.getNivel());
    }

    @Test
    void getAsistencia() {
        Estudiante e = new Estudiante("Juan", "juan@a.com", "E01", 15, Nivel.PRINCIPIANTE, "Piano", 85, 0);
        assertEquals(85, e.getAsistencia());
    }

    @Test
    void setAsistencia() {
        Estudiante e = new Estudiante("Ana", "ana@a.com", "E02", 14, Nivel.INTERMEDIO, "Guitarra", 0, 0);
        e.setAsistencia(90);
        assertEquals(90, e.getAsistencia());
    }

    @Test
    void getProgreso() {
        Estudiante e = new Estudiante("Juan", "juan@a.com", "E01", 15, Nivel.PRINCIPIANTE, "Piano", 0, 50);
        assertEquals(50, e.getProgreso());
    }

    @Test
    void setProgreso() {
        Estudiante e = new Estudiante("Ana", "ana@a.com", "E02", 14, Nivel.INTERMEDIO, "Guitarra", 0, 0);
        e.setProgreso(75);
        assertEquals(75, e.getProgreso());
    }

    @Test
    void getCurso() {
        Estudiante e = new Estudiante("Juan", "juan@a.com", "E01", 15, Nivel.PRINCIPIANTE, "Piano", 0, 0);
        assertEquals("Piano", e.getCurso());
    }

    @Test
    void setCurso() {
        Estudiante e = new Estudiante("Ana", "ana@a.com", "E02", 14, Nivel.INTERMEDIO, "Guitarra", 0, 0);
        e.setCurso("Violin");
        assertEquals("Violin", e.getCurso());
    }

    @Test
    void getListCursosAprobados() {
        Estudiante e = new Estudiante("Juan", "juan@a.com", "E01", 15, Nivel.PRINCIPIANTE, "Piano", 0, 0);
        assertNotNull(e.getListCursosAprobados());
        assertTrue(e.getListCursosAprobados().contains(Nivel.PRINCIPIANTE));
    }
}
