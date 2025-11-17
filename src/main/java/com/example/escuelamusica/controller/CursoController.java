package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.Curso;

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
}
