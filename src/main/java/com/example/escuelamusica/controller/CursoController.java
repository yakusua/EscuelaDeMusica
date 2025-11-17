package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.Clase;
import com.example.escuelamusica.model.Curso;
import com.example.escuelamusica.model.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class CursoController {
    private List<Curso> cursos = new ArrayList<>();

    public void crear(Curso c) {
        cursos.add(c);
    }

    public List<Curso> listar() {
        return cursos;
    }

    public Curso buscarPorId(String id) {
        for (Curso c : cursos) {
            if (c.getIdCurso().equals(id)) return c;
        }
        return null;
    }

    public void actualizar(Curso actualizado) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getIdCurso().equals(actualizado.getIdCurso())) {
                cursos.set(i, actualizado);
            }
        }
    }

    public void eliminar(String id) {
        cursos.removeIf(c -> c.getIdCurso().equals(id));
    }

    // Inscribir estudiante
    public boolean inscribirEstudiante(Estudiante estudiante, Curso curso) {
        List<Estudiante> inscritos = curso.getEstudiantesInscritos();

        for (Estudiante e : inscritos) {
            if (e.getIdEstudiante().equals(estudiante.getIdEstudiante())) {
                System.out.println("El estudiante ya está inscrito en el curso.");
                return false;
            }
        }

        if (inscritos.size() >= curso.getCapacidad()) {
            System.out.println("No hay cupo disponible.");
            return false;
        }

        inscritos.add(estudiante);
        System.out.println("Estudiante inscrito.");
        return true;
    }

    // Desinscribir estudiante
    public boolean desinscribirEstudiante(Estudiante estudiante, Curso curso) {
        List<Estudiante> inscritos = curso.getEstudiantesInscritos();

        return inscritos.removeIf(e ->
                e.getIdEstudiante().equals(estudiante.getIdEstudiante())
        );
    }

    // Listar estudiantes
    public List<Estudiante> listarEstudiantesDeCurso(Curso curso) {
        return curso.getEstudiantesInscritos();
    }

    // Agregar clase al curso
    public boolean agregarClase(Curso curso, Clase clase) {
        List<Clase> clases = curso.getListClases();

        for (Clase c : clases) {
            if (c.getId().equals(clase.getId())) {
                System.out.println("Clase ya asociada.");
                return false;
            }
        }

        clases.add(clase);
        return true;
    }

    // Eliminar clase del curso
    public boolean eliminarClase(Curso curso, Clase clase) {
        return curso.getListClases().removeIf(c ->
                c.getId().equals(clase.getId())
        );
    }

    // Listar clases
    public List<Clase> listarClases(Curso curso) {
        return curso.getListClases();
    }

}
