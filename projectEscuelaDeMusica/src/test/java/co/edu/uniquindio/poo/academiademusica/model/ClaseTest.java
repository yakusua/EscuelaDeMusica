package co.edu.uniquindio.poo.academiademusica.model;

import co.edu.uniquindio.poo.academiademusica.model.enums.EstadoAsistencia;
import co.edu.uniquindio.poo.academiademusica.model.enums.Nivel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClaseTest {

    private Clase clase;
    private Profesor profesor;
    private Curso curso;
    private Salon salon;

    static class ClasePrueba extends Clase {
        public ClasePrueba(String id, int nivel, LocalDateTime horario, int cupo,
                           Profesor profesor, Curso curso, Salon salon) {
            super(id, nivel, horario, cupo, profesor, curso, salon);
        }

        @Override
        public List<Estudiante> obtenerEstudiantesInscritos() {
            List<Estudiante> estudiantes = new ArrayList<>();
            for (Asistencia a : getListAsistencias()) {
                estudiantes.add(a.getEstudiante());
            }
            return estudiantes;
        }

        @Override
        protected boolean validarEstudianteInscrito(Estudiante estudiante) {
            return obtenerEstudiantesInscritos().contains(estudiante);
        }

        @Override
        public void registrarAsistencia(Estudiante estudiante, EstadoAsistencia estado) {

        }

        @Override
        public List<Asistencia> consultarAsistencias() {
            return List.of();
        }

        @Override
        public List<Asistencia> consultarAsistenciasEstudiante(Estudiante estudiante) {
            return List.of();
        }

        @Override
        public double calcularPorcentajeAsistencia() {
            return 0;
        }
    }

    @Test
    void testGetSetId() {
        clase.setId("CL99");
        assertEquals("CL99", clase.getId());
    }

    @Test
    void testGetSetNivel() {
        clase.setNivel(3);
        assertEquals(3, clase.getNivel());
    }

    @Test
    void testGetSetHorario() {
        LocalDateTime nuevoHorario = LocalDateTime.of(2025, 1, 1, 10, 0);
        clase.setHorario(nuevoHorario);
        assertEquals(nuevoHorario, clase.getHorario());
    }

    @Test
    void testGetSetCupo() {
        clase.setCupo(15);
        assertEquals(15, clase.getCupo());
    }

    @Test
    void testGetSetSalon() {
        Salon otroSalon = new Salon("Aula 2", 20, null);
        clase.setSalon(otroSalon);
        assertEquals("Aula 2", clase.getSalon().getNombre());
    }

    @Test
    void testGetSetListAsistencias() {
        List<Asistencia> lista = new ArrayList<>();
        clase.setListAsistencias(lista);
        assertEquals(lista, clase.getListAsistencias());
    }

    @Test
    void testObtenerEstudiantesInscritosYValidar() {
        Estudiante e1 = new Estudiante("Juan", "juan@a.com", "E01", 12,
                Nivel.PRINCIPIANTE, "Piano", 0, 0);
        Asistencia a1 = new Asistencia("A01", LocalDateTime.now().toLocalDate(), e1, clase, EstadoAsistencia.PRESENTE);
        clase.getListAsistencias().add(a1);

        List<Estudiante> estudiantes = clase.obtenerEstudiantesInscritos();
        assertTrue(estudiantes.contains(e1));
        assertTrue(clase.validarEstudianteInscrito(e1));
    }
}
