package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.EvaluacionNivel;

import java.util.ArrayList;
import java.util.List;

public class EvaluacionController {
    private List<EvaluacionNivel> evaluaciones = new ArrayList<>();

    public void crear(EvaluacionNivel e) {
        evaluaciones.add(e);
    }

    public List<EvaluacionNivel> listar() {
        return evaluaciones;
    }

    public EvaluacionNivel buscarPorId(String id) {
        for (EvaluacionNivel e : evaluaciones) {
            if (e.getIdEvaluacionNivel().equals(id)) return e;
        }
        return null;
    }

    public void actualizar(EvaluacionNivel actualizado) {
        for (int i = 0; i < evaluaciones.size(); i++) {
            if (evaluaciones.get(i).getIdEvaluacionNivel().equals(actualizado.getIdEvaluacionNivel())) {
                evaluaciones.set(i, actualizado);
            }
        }
    }

    public void eliminar(String id) {
        evaluaciones.removeIf(ev -> ev.getIdEvaluacionNivel().equals(id));
    }
}
