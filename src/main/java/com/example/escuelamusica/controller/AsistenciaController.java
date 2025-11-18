package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaController {
    private final List<Asistencia> asistencias = new ArrayList<>();
    private final HorarioController horarioController;
    private final MatriculaController matriculaController; // para verificar existencia de estudiante en el curso

    public AsistenciaController(HorarioController horarioController, MatriculaController matriculaController) {
        this.horarioController = horarioController;
        this.matriculaController = matriculaController;
    }

    // Registrar asistencia: devuelve true si se registró correctamente
    public boolean registrarAsistencia(String claseId, String estudianteId, EstadoAsistencia estado) {
        if (claseId == null || estudianteId == null || estado == null) {
            System.out.println("Aviso: parámetros inválidos para registrar asistencia.");
            return false;
        }
        Clase clase = horarioController.buscarClasePorId(claseId);
        if (clase == null) {
            System.out.println("Aviso: clase no encontrada: " + claseId);
            return false;
        }
        Estudiante estudiante = matriculaController.buscarEstudiantePorId(estudianteId);
        if (estudiante == null) {
            System.out.println("Aviso: estudiante no encontrado: " + estudianteId);
            return false;
        }
        // valida si el estudiante puede registrarse en esa clase
        boolean ok = clase.registrarAsistencia(estudiante, estado);
        if (!ok) {
            System.out.println("Aviso: no se pudo registrar asistencia en la clase (validación local falló).");
            return false;
        }
        // crear y guardar registro de asistencia
        Asistencia a = new Asistencia(java.util.UUID.randomUUID().toString(), LocalDate.now(), estudiante, clase, estado);
        asistencias.add(a);
        System.out.println("Asistencia registrada: clase=" + claseId + " estudiante=" + estudianteId + " estado=" + estado);
        return true;
    }

    // Listar asistencias de una clase
    public List<Asistencia> listarAsistenciasPorClase(String claseId) {
        List<Asistencia> res = new ArrayList<>();
        if (claseId == null) return res;
        for (int i = 0; i < asistencias.size(); i++) {
            Asistencia a = asistencias.get(i);
            if (a.getClase() != null && a.getClase().getId().equals(claseId)) res.add(a);
        }
        return res;
    }

    // Listar asistencias de un estudiante
    public List<Asistencia> listarAsistenciasPorEstudiante(String estudianteId) {
        List<Asistencia> res = new ArrayList<>();
        if (estudianteId == null) return res;
        for (int i = 0; i < asistencias.size(); i++) {
            Asistencia a = asistencias.get(i);
            if (a.getEstudiante() != null && a.getEstudiante().getIdEstudiante().equals(estudianteId)) res.add(a);
        }
        return res;
    }

    // Calcular porcentaje de asistencia de una clase
    public double porcentajeAsistenciaClase(String claseId) {
        if (claseId == null) return 0.0;
        Clase clase = horarioController.buscarClasePorId(claseId);
        if (clase == null) return 0.0;
        return clase.calcularPorcentajeAsistencia();
    }

    // Obtener todas las asistencias
    public List<Asistencia> listarTodasAsistencias() {
        List<Asistencia> copia = new ArrayList<>();
        for (int i = 0; i < asistencias.size(); i++) copia.add(asistencias.get(i));
        return copia;
    }
}

