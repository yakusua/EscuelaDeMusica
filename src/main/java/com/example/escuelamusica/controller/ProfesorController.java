package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.Curso;
import com.example.escuelamusica.model.Profesor;

import java.util.ArrayList;
import java.util.List;

public class ProfesorController {
    private List<Profesor> profesores = new ArrayList<>();

    public void crear(Profesor p) {
        profesores.add(p);
    }

    public List<Profesor> listar() {
        return profesores;
    }

    public Profesor buscarPorId(String id) {
        for (Profesor p : profesores) {
            if (p.getIdProfesor().equals(id)) return p;
        }
        return null;
    }

    public void actualizar(Profesor actualizado) {
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getIdProfesor().equals(actualizado.getIdProfesor())) {
                profesores.set(i, actualizado);
            }
        }
    }

    public void eliminar(String id) {
        profesores.removeIf(p -> p.getIdProfesor().equals(id));
    }

    public void asignarProfesorACurso(Profesor profesor, Curso curso) {
        curso.setProfesor(profesor);
    }

    public void quitarProfesorDeCurso(Curso curso) {
        curso.setProfesor(null);
    }

    public List<Curso> listarCursosDictados(Profesor profesor, List<Curso> cursos) {
        List<Curso> resultado = new ArrayList<>();

        for (Curso c : cursos) {
            if (c.getProfesor() != null && c.getProfesor().getIdProfesor().equals(profesor.getIdProfesor())) {
                resultado.add(c);
            }
        }

        return resultado;
    }
}
