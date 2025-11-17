package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.Matricula;

import java.util.ArrayList;
import java.util.List;

public class MatriculaController {
    private List<Matricula> matriculas = new ArrayList<>();

    public void crear(Matricula m) {
        matriculas.add(m);
    }

    public List<Matricula> listar() {
        return matriculas;
    }

    public Matricula buscarPorId(String id) {
        for (Matricula m : matriculas) {
            if (m.getIdMatricula().equals(id)) return m;
        }
        return null;
    }

    public void actualizar(Matricula actualizado) {
        for (int i = 0; i < matriculas.size(); i++) {
            if (matriculas.get(i).getIdMatricula().equals(actualizado.getIdMatricula())) {
                matriculas.set(i, actualizado);
            }
        }
    }

    public void eliminar(String id) {
        matriculas.removeIf(m -> m.getIdMatricula().equals(id));
    }
}
