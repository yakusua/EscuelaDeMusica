package com.example.escuelamusica.model;

import java.util.ArrayList;
import java.util.List;

public class ClaseGrupal extends Clase {
    private List<Estudiante> estudiantesInscritos;

    public ClaseGrupal(String id, String horario, int cupo, Profesor profesor, Curso curso, Salon salon) {
        super(id, horario, cupo, profesor, curso, salon);
        this.estudiantesInscritos = new ArrayList<>();
    }

    public List<Estudiante> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }

    public void setEstudiantesInscritos(List<Estudiante> estudiantesInscritos) {
        this.estudiantesInscritos = estudiantesInscritos;
    }

    @Override
    public List<Estudiante> obtenerEstudiantesInscritos() {
        return new ArrayList<>(estudiantesInscritos);
    }

    @Override
    protected boolean validarEstudianteInscrito(Estudiante estudiante) {
        return estudiantesInscritos.contains(estudiante);
    }

    @Override
    public void registrarAsistencia(Estudiante estudiante, EstadoAsistencia estadoAsistencia) {

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
        return 0.0;
    }
}