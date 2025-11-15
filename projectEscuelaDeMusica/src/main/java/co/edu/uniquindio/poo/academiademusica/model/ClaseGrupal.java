package co.edu.uniquindio.poo.academiademusica.model;

import co.edu.uniquindio.poo.academiademusica.model.enums.EstadoAsistencia;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClaseGrupal extends Clase {

    private List<Estudiante> estudiantesInscritos;
    private String instrumento;

    public ClaseGrupal(String id, int nivel, LocalDateTime horario, int cupo,
                       Profesor profesor, Curso curso, Salon salon,
                       String instrumento) {

        super(id, nivel, horario, cupo, profesor, curso, salon);
        this.instrumento = instrumento;
        this.estudiantesInscritos = new ArrayList<>();
    }

    @Override
    public List<Estudiante> obtenerEstudiantesInscritos() {
        return estudiantesInscritos;
    }

    @Override
    protected boolean validarEstudianteInscrito(Estudiante estudiante) {
        return estudiantesInscritos.contains(estudiante);
    }

    @Override
    public void registrarAsistencia(Estudiante estudiante, EstadoAsistencia estado) {
        if (!validarEstudianteInscrito(estudiante)) return;

        String idAsistencia = "A" + (listAsistencias.size() + 1);
        LocalDate fecha = LocalDate.now();

        Asistencia asistencia = new Asistencia(
                idAsistencia,
                fecha,
                estudiante,
                this,
                estado
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
        if (estudiantesInscritos.isEmpty()) return 0;

        return (listAsistencias.size() * 100.0) / estudiantesInscritos.size();
    }
}

