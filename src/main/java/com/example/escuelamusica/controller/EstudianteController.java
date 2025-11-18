package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.Asistencia;
import com.example.escuelamusica.model.ClaseGrupal;
import com.example.escuelamusica.model.Curso;
import com.example.escuelamusica.model.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class EstudianteController {
    private final List<Estudiante> estudiantes = new ArrayList<>();

    public EstudianteController() { }

    public boolean guardarEstudiante(Estudiante e) {
        if (e == null) {
            System.out.println("Aviso: estudiante nulo. No se guarda.");
            return false;
        }
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getIdEstudiante().equals(e.getIdEstudiante())) {
                estudiantes.set(i, e);
                System.out.println("Estudiante actualizado: " + e.getIdEstudiante());
                return true;
            }
        }
        estudiantes.add(e);
        System.out.println("Estudiante agregado: " + e.getIdEstudiante());
        return true;
    }

    public Estudiante buscarEstudiantePorId(String id) {
        if (id == null) return null;
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getIdEstudiante().equals(id)) return estudiantes.get(i);
        }
        return null;
    }

    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> copia = new ArrayList<>();
        for (int i = 0; i < estudiantes.size(); i++) copia.add(estudiantes.get(i));
        return copia;
    }

    public boolean eliminarEstudiante(String id) {
        if (id == null) return false;
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getIdEstudiante().equals(id)) {
                estudiantes.remove(i);
                System.out.println("Estudiante eliminado: " + id);
                return true;
            }
        }
        System.out.println("Aviso: estudiante no encontrado: " + id);
        return false;
    }

    // marcar curso como aprobado localmente (usa métodos del modelo Estudiante)
    public boolean marcarAprobado(String estudianteId, Curso curso) {
        Estudiante e = buscarEstudiantePorId(estudianteId);
        if (e == null) {
            System.out.println("Aviso: estudiante no encontrado: " + estudianteId);
            return false;
        }
        if (curso == null) {
            System.out.println("Aviso: curso nulo.");
            return false;
        }
        boolean ok = e.aprobarCursoLocal(curso);
        if (ok) {
            guardarEstudiante(e);
            System.out.println("Curso marcado como aprobado: " + curso.getIdCurso() + " para estudiante " +
                    estudianteId);
        }
        return ok;
    }

    public boolean haAprobadoCurso(String estudianteId, Curso curso) {
        Estudiante e = buscarEstudiantePorId(estudianteId);
        if (e == null || curso == null) return false;
        return e.haAprobadoCursoLocal(curso);
    }
}

