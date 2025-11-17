package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.Curso;
import com.example.escuelamusica.model.Estudiante;
import com.example.escuelamusica.model.EvaluacionNivel;
import com.example.escuelamusica.model.Nivel;

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

    public List<EvaluacionNivel> obtenerEvaluacionesDeEstudiante(Estudiante estudiante) {
        List<EvaluacionNivel> r = new ArrayList<>();

        for (EvaluacionNivel e : evaluaciones) {
            if (e.getEstudiante().getIdEstudiante().equals(estudiante.getIdEstudiante())) {
                r.add(e);
            }
        }
        return r;
    }

    public List<EvaluacionNivel> obtenerEvaluacionesDeCurso(Curso curso) {
        List<EvaluacionNivel> r = new ArrayList<>();

        for (EvaluacionNivel e : evaluaciones) {
            if (e.getCurso().getIdCurso().equals(curso.getIdCurso())) {
                r.add(e);
            }
        }
        return r;
    }

    public Nivel nivelFinalEstudiante(Estudiante estudiante) {
        List<EvaluacionNivel> lista = obtenerEvaluacionesDeEstudiante(estudiante);

        if (lista.isEmpty()) {
            return Nivel.PRINCIPIANTE;
        }

        // Tomamos el nivel más alto
        Nivel nivelMax = Nivel.PRINCIPIANTE;

        for (EvaluacionNivel e : lista) {
            if (e.getNivel().ordinal() > nivelMax.ordinal()) {
                nivelMax = e.getNivel();
            }
        }

        return nivelMax;
    }
}
