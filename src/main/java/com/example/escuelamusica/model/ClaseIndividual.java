package com.example.escuelamusica.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ClaseIndividual extends Clase {
    private Estudiante estudiante;

    public ClaseIndividual(String id, LocalDate fecha, LocalTime hora, int cupo, Profesor profesor, Curso curso, Salon salon, Estudiante estudiante) {
        super(id, fecha, hora, cupo, profesor, curso, salon);
        this.estudiante = estudiante;
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
        if (this.estudiante == null || estudiante == null) return false;
        return this.estudiante.equals(estudiante);
    }

    @Override
    public boolean registrarAsistencia(Estudiante estudiante, EstadoAsistencia estadoAsistencia) {
        if (estudiante == null) {
            System.out.println("Aviso: estudiante nulo. No se registra asistencia.");
            return false;
        }
        if (estadoAsistencia == null) {
            System.out.println("Aviso: estado nulo. No se registra asistencia.");
            return false;
        }
        if (!validarEstudianteInscrito(estudiante)) {
            System.out.println("Aviso: estudiante no corresponde a la clase individual.");
            return false;
        }
        Asistencia a = new Asistencia(java.util.UUID.randomUUID().toString(), this.fecha, estudiante, this, estadoAsistencia);
        this.listAsistencias.add(a);
        return true;
    }

    @Override
    public List<Asistencia> consultarAsistencias() {
        List<Asistencia> res = new ArrayList<>();
        for (int i = 0; i < this.listAsistencias.size(); i++) res.add(this.listAsistencias.get(i));
        return res;
    }

    @Override
    public List<Asistencia> consultarAsistenciasEstudiante(Estudiante estudiante) {
        List<Asistencia> res = new ArrayList<>();
        if (estudiante == null) return res;
        for (int i = 0; i < this.listAsistencias.size(); i++) {
            Asistencia a = this.listAsistencias.get(i);
            if (a.getEstudiante() != null && a.getEstudiante().equals(estudiante)) res.add(a);
        }
        return res;
    }

    @Override
    public double calcularPorcentajeAsistencia() {
        if (this.estudiante == null)
            return 0.0;
        boolean presente = false;
        for (int i = 0; i < this.listAsistencias.size(); i++) {
            Asistencia a = this.listAsistencias.get(i);
            if (a.getEstudiante() != null && a.getEstudiante().equals(this.estudiante)
                    && a.getEstadoAsistencia() == EstadoAsistencia.PRESENTE) {
                presente = true;
                break;
            }
        }
        return presente ? 100.0 : 0.0;
    }
}

