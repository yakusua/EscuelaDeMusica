package co.edu.uniquindio.poo.academiademusica.model;

import co.edu.uniquindio.poo.academiademusica.model.enums.EstadoAsistencia;
import co.edu.uniquindio.poo.academiademusica.model.enums.Nivel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AsistenciaTest {

    private Estudiante estudiante;
    private Clase clase;
    private Asistencia asistencia;

    @BeforeEach
    void setUp() {
        // Crear un estudiante
        estudiante = new Estudiante("Juan", "juan@a.com", "Estu01", 12,
                Nivel.PRINCIPIANTE, "Piano", 0, 0);

        // Crear una clase
        clase = new ClaseIndividual("C01", 1, LocalDate.now().atStartOfDay(), 1,
                null, null, null, "Piano");

        // Crear una asistencia
        asistencia = new Asistencia("A01", LocalDate.now(), estudiante, clase, EstadoAsistencia.PRESENTE);
    }

    @Test
    void constructorNullEstudiante() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Asistencia("A02", LocalDate.now(), null, clase, EstadoAsistencia.PRESENTE);
        });
        assertEquals("El estudiante no puede ser nulo", exception.getMessage());
    }

    @Test
    void constructorNullClase() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Asistencia("A02", LocalDate.now(), estudiante, null, EstadoAsistencia.PRESENTE);
        });
        assertEquals("La clase no puede ser nula", exception.getMessage());
    }

    @Test
    void constructorNullEstado() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Asistencia("A02", LocalDate.now(), estudiante, clase, null);
        });
        assertEquals("El estado no puede ser nulo", exception.getMessage());
    }

    @Test
    void getSetId() {
        asistencia.setId("A99");
        assertEquals("A99", asistencia.getId());
    }

    @Test
    void getSetFecha() {
        LocalDate nuevaFecha = LocalDate.of(2025, 1, 1);
        asistencia.setFecha(nuevaFecha);
        assertEquals(nuevaFecha, asistencia.getFecha());
    }

    @Test
    void getSetEstudiante() {
        Estudiante otro = new Estudiante("Ana", "ana@a.com", "Estu02", 14,
                Nivel.INTERMEDIO, "Guitarra", 0, 0);
        asistencia.setEstudiante(otro);
        assertEquals("Ana", asistencia.getEstudiante().getNombre());
    }

    @Test
    void getSetClase() {
        Clase otraClase = new ClaseIndividual("C02", 2, LocalDate.now().atStartOfDay(), 2,
                null, null, null, "Guitarra");
        asistencia.setClase(otraClase);
        assertEquals("C02", asistencia.getClase().getId());
    }

    @Test
    void getSetEstadoAsistencia() {
        asistencia.setEstadoAsistencia(EstadoAsistencia.AUSENTE);
        assertEquals(EstadoAsistencia.AUSENTE, asistencia.getEstadoAsistencia());
    }

    @Test
    void testToString() {
        String texto = asistencia.toString();
        assertTrue(texto.contains("A01"));
        assertTrue(texto.contains("Juan"));
        assertTrue(texto.contains("C01"));
        assertTrue(texto.contains("PRESENTE"));
    }
}
