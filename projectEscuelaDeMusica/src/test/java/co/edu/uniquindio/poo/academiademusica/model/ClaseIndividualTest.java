package co.edu.uniquindio.poo.academiademusica.model;

import co.edu.uniquindio.poo.academiademusica.model.enums.EstadoAsistencia;
import co.edu.uniquindio.poo.academiademusica.model.enums.Instrumento;
import co.edu.uniquindio.poo.academiademusica.model.enums.Nivel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClaseIndividualTest {

    private ClaseIndividual clase;
    private Estudiante est;
    private Profesor prof;
    private Curso curso;
    private Salon salon;

    @BeforeEach
    void setUp() {
        prof = new Profesor("Pedro","P@1","P01", Instrumento.CANTO,"Voz");
        curso = new Curso(12,Instrumento.PIANO, Nivel.INTERMEDIO);
        salon = new Salon("A101", 1, null);
        clase = new ClaseIndividual("CL01", 1, LocalDateTime.now(), 1, prof, curso, salon, "Piano");

        est = new Estudiante("Juan", "juan@correo.com", "E01", 12, null, "Piano", 0, 0);
        clase.setEstudiante(est);
    }

    @Test
    void getEstudiante() {
        assertEquals(est, clase.getEstudiante());
    }

    @Test
    void setEstudiante() {
        Estudiante nuevo = new Estudiante("Ana","ana@correo.com","E02",14,null,"Piano",0,0);
        clase.setEstudiante(nuevo);
        assertEquals(nuevo, clase.getEstudiante());
    }

    @Test
    void getInstrumento() {
        assertEquals("Piano", clase.getInstrumento());
    }

    @Test
    void setInstrumento() {
        clase.setInstrumento("Guitarra");
        assertEquals("Guitarra", clase.getInstrumento());
    }

    @Test
    void obtenerEstudiantesInscritos() {
        List<Estudiante> inscritos = clase.obtenerEstudiantesInscritos();
        assertEquals(1, inscritos.size());
        assertEquals(est, inscritos.get(0));
    }

    @Test
    void registrarAsistencia() {
        clase.registrarAsistencia(est, EstadoAsistencia.PRESENTE);
        List<Asistencia> asistencias = clase.consultarAsistencias();
        assertEquals(1, asistencias.size());
        assertEquals(est, asistencias.get(0).getEstudiante());
    }

    @Test
    void consultarAsistencias() {
        clase.registrarAsistencia(est, EstadoAsistencia.PRESENTE);
        clase.registrarAsistencia(est, EstadoAsistencia.AUSENTE);
        List<Asistencia> asistencias = clase.consultarAsistencias();
        assertEquals(2, asistencias.size());
    }

    @Test
    void consultarAsistenciasEstudiante() {
        clase.registrarAsistencia(est, EstadoAsistencia.PRESENTE);
        List<Asistencia> asistenciasEst = clase.consultarAsistenciasEstudiante(est);
        assertEquals(1, asistenciasEst.size());
        assertEquals(est, asistenciasEst.get(0).getEstudiante());
    }

    @Test
    void calcularPorcentajeAsistencia() {
        clase.registrarAsistencia(est, EstadoAsistencia.PRESENTE);
        clase.registrarAsistencia(est, EstadoAsistencia.AUSENTE);
        double porcentaje = clase.calcularPorcentajeAsistencia();
        assertEquals(50.0, porcentaje); // 1 presente de 2 asistencias
    }
}
