package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.Asistencia;
import com.example.escuelamusica.model.ClaseGrupal;
import com.example.escuelamusica.model.Curso;
import com.example.escuelamusica.model.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class EstudianteController {
    private List<Estudiante> estudiantes = new ArrayList<>();

    public void crear(Estudiante e) {
        estudiantes.add(e);
    }

    public List<Estudiante> listar() {
        return estudiantes;
    }

    public void actualizar(Estudiante eActualizado) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getIdEstudiante().equals(eActualizado.getIdEstudiante())) {
                estudiantes.set(i, eActualizado);
            }
        }
    }

    public void eliminar(String id) {
        estudiantes.removeIf(e -> e.getIdEstudiante().equals(id));
    }

    // Cursos donde está inscrito
    public List<Curso> listarCursosDeEstudiante(Estudiante estudiante, List<Curso> cursos) {
        List<Curso> resultado = new ArrayList<>();

        for (Curso c : cursos) {
            for (Estudiante e : c.getEstudiantesInscritos()) {
                if (e.getIdEstudiante().equals(estudiante.getIdEstudiante())) {
                    resultado.add(c);
                }
            }
        }
        return resultado;
    }

    // Evaluaciones del estudiante
    public List<Evaluacion> listarEvaluacionesEstudiante(Estudiante estudiante, List<Evaluacion> evaluaciones) {
        List<Evaluacion> resultado = new ArrayList<>();

        for (Evaluacion e : evaluaciones) {
            if (e.getEstudiante().getIdEstudiante().equals(estudiante.getIdEstudiante())) {
                resultado.add(e);
            }
        }

        return resultado;
    }

    // Asistencias del estudiante
    public List<Asistencia> listarAsistenciasEstudiante(Estudiante estudiante, List<Asistencia> asistencias) {
        List<Asistencia> r = new ArrayList<>();

        for (Asistencia a : asistencias) {
            if (a.getEstudiante().getIdEstudiante().equals(estudiante.getIdEstudiante())) {
                r.add(a);
            }
        }

        return r;
    }
}
