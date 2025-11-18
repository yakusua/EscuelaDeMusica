package co.edu.uniquindio.poo.academiademusica.model;

import co.edu.uniquindio.poo.academiademusica.model.enums.EstadoAsistencia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClaseGrupalTest {

    private ClaseGrupal clase;
    private Estudiante est1;
    private Estudiante est2;
    private Profesor prof;
    private Curso curso;
    private Salon salon;


    @Test
    void obtenerEstudiantesInscritos() {
        List<Estudiante> estudiantes = clase.obtenerEstudiantesInscritos();
        assertEquals(2, estudiantes.size());
        assertTrue(estudiantes.contains(est1));
        assertTrue(estudiantes.contains(est2));
    }

    @Test
    void validarEstudianteInscrito() {
        assertTrue(clase.validarEstudianteInscrito(est1));
        assertFalse(clase.validarEstudianteInscrito(new Estudiante("Luis","l@correo.com","E03",15,null,"Piano",0,0)));
    }

    @Test
    void registrarAsistencia() {
        clase.registrarAsistencia(est1, EstadoAsistencia.PRESENTE);
        assertEquals(1, clase.consultarAsistencias().size());
        assertEquals(est1, clase.consultarAsistencias().get(0).getEstudiante());
    }

    @Test
    void consultarAsistencias() {
        clase.registrarAsistencia(est1, EstadoAsistencia.PRESENTE);
        clase.registrarAsistencia(est2, EstadoAsistencia.AUSENTE);
        assertEquals(2, clase.consultarAsistencias().size());
    }

    @Test
    void consultarAsistenciasEstudiante() {
        clase.registrarAsistencia(est1, EstadoAsistencia.PRESENTE);
        clase.registrarAsistencia(est1, EstadoAsistencia.AUSENTE);
        clase.registrarAsistencia(est2, EstadoAsistencia.PRESENTE);

        List<Asistencia> asistEst1 = clase.consultarAsistenciasEstudiante(est1);
        assertEquals(2, asistEst1.size());

        List<Asistencia> asistEst2 = clase.consultarAsistenciasEstudiante(est2);
        assertEquals(1, asistEst2.size());
    }

    @Test
    void calcularPorcentajeAsistencia() {
        clase.registrarAsistencia(est1, EstadoAsistencia.PRESENTE);
        clase.registrarAsistencia(est2, EstadoAsistencia.AUSENTE);
        double porcentaje = clase.calcularPorcentajeAsistencia();
        assertEquals(100.0, porcentaje); // Porque el método calcula asistencias/estudiantesInscritos * 100
    }

    @Test
    void instrumentoProperty() {
        assertEquals("PIANO", clase.instrumentoProperty().get());
    }

    @Test
    void nivelProperty() {
        assertEquals("1", clase.nivelProperty().get());
    }

    @Test
    void aulaProperty() {
        assertEquals("A101", clase.aulaProperty().get());
    }

    @Test
    void horarioProperty() {
        assertEquals(clase.getHorario().toString(), clase.horarioProperty().get());
    }

    @Test
    void cuposProperty() {
        assertEquals(5, clase.cuposProperty().get());
    }
}
