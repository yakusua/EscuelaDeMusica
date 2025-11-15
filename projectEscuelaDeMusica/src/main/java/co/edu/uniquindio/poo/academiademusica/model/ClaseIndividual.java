package co.edu.uniquindio.poo.academiademusica.model;

import co.edu.uniquindio.poo.academiademusica.model.enums.EstadoAsistencia;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClaseIndividual extends Clase {

    private Estudiante estudiante;
    private String instrumento;

    public ClaseIndividual(String id, int nivel, LocalDateTime horario, int cupo,
                           Profesor profesor, Curso curso, Salon salon,
                           String instrumento) {

        super(id, nivel, horario, cupo, profesor, curso, salon);
        this.instrumento = instrumento;
    }

    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }

    @Override
    public List<Estudiante> obtenerEstudiantesInscritos() {
        List<Estudiante> lista = new ArrayList<>();
        if (estudiante != null) lista.add(estudiante);
        return lista;
    }

    @Override
    protected boolean validarEstudianteInscrito(Estudiante estudiante) {
        return this.estudiante != null && this.estudiante.equals(estudiante);
    }

    @Override
    public void registrarAsistencia(Estudiante estudiante, EstadoAsistencia estado) {
        if (!validarEstudianteInscrito(estudiante)) return;

        Asistencia asistencia = new Asistencia(
                "idAsistencia",     // id simple
                LocalDate.now(),    // fecha actual
                estudiante,          // estudiante
                this,                // clase actual
                estado               // estado
        );

        listAsistencias.add(asistencia);
    }



    @Override
    public List<Asistencia> consultarAsistencias() {
        return listAsistencias;
    }

    @Override
    public List<Asistencia> consultarAsistenciasEstudiante(Estudiante estudiante) {

        List<Asistencia> resultado = new ArrayList<>();

        for (Asistencia asistencia : listAsistencias) {
            if (asistencia.getEstudiante().equals(estudiante)) {
                resultado.add(asistencia);
            }
        }

        return resultado;
    }

    @Override
    public double calcularPorcentajeAsistencia() {
        if (estudiante == null) return 0;
        if (listAsistencias.isEmpty()) return 0;

        int asistio = 0;

        for (Asistencia asistencia : listAsistencias) {
            if (asistencia.getEstadoAsistencia() == EstadoAsistencia.PRESENTE) {
                asistio++;
            }
        }

        return (asistio * 100.0) / listAsistencias.size();
    }
}

