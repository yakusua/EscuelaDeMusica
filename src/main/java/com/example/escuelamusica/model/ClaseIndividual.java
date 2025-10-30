package com.example.escuelamusica.model;

import java.util.ArrayList;
import java.util.List;
//verificar si es subclase o Enum
public class ClaseIndividual extends Clase{

    private Estudiante estudiante;

    public ClaseIndividual(String id, String horario,int cupo, Profesor profesor, Curso curso, Salon salon, Estudiante estudiante) {
        super(id,horario,cupo,profesor,curso,salon);

        this.estudiante = estudiante;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public List<Estudiante> obtenerEstudiantesInscritos() {
        List<Estudiante> lista = new ArrayList<>();
        if (estudiante != null) {
            lista.add(estudiante);
        }
        return lista;
    }

    @Override
    protected boolean validarEstudianteInscrito(Estudiante estudiante) {
        return this.estudiante != null && this.estudiante.equals(estudiante);
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
        return 0.0;
    }
}
