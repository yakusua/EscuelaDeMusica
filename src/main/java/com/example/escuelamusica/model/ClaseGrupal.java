package com.example.escuelamusica.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ClaseGrupal extends Clase {
    private List<Estudiante> estudiantesInscritos;

    public ClaseGrupal(String id, LocalDate fecha, LocalTime hora, int cupo, Profesor profesor, Curso curso, Salon salon) {
        super(id, fecha, hora, cupo, profesor, curso, salon);
        this.estudiantesInscritos = new ArrayList<>();
    }

    public List<Estudiante> getEstudiantesInscritos() { return estudiantesInscritos; }

    @Override
    public List<Estudiante> obtenerEstudiantesInscritos() {
        List<Estudiante> copia = new ArrayList<>();
        for (int i = 0; i < estudiantesInscritos.size(); i++) copia.add(estudiantesInscritos.get(i));
        return copia;
    }

    @Override
    protected boolean validarEstudianteInscrito(Estudiante estudiante) {
        if (estudiante == null) return false;
        for (int i = 0; i < estudiantesInscritos.size(); i++) {
            if (estudiantesInscritos.get(i).equals(estudiante)) return true;
        }
        return false;
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
            System.out.println("Aviso: estudiante no inscrito en esta clase.");
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
        int totalEsperado = estudiantesInscritos.size();
        if (totalEsperado == 0) return 0.0;
        List<Estudiante> presentes = new ArrayList<>();
        for (int i = 0; i < this.listAsistencias.size(); i++) {
            Asistencia a = this.listAsistencias.get(i);
            if (a.getEstadoAsistencia() == EstadoAsistencia.PRESENTE) {
                boolean ya = false;
                for (int j = 0; j < presentes.size(); j++) {
                    if (presentes.get(j).equals(a.getEstudiante())) { ya = true; break; }
                }
                if (!ya) presentes.add(a.getEstudiante());
            }
        }
        return (presentes.size() * 100.0) / totalEsperado;
    }

    public boolean puedeInscribirLocal() { return estudiantesInscritos.size() < this.cupo; }

    public boolean inscribirLocal(Estudiante estudiante) {
        if (estudiante == null) {
            System.out.println("Aviso: estudiante nulo. No se inscribe.");
            return false;
        }
        if (!puedeInscribirLocal()) {
            System.out.println("Aviso: no hay cupo.");
            return false;
        }
        for (int i = 0; i < estudiantesInscritos.size(); i++) {
            if (estudiantesInscritos.get(i).equals(estudiante)) {
                System.out.println("Aviso: estudiante ya inscrito.");
                return false;
            }
        }
        return estudiantesInscritos.add(estudiante);
    }
}
