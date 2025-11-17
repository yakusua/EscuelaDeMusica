package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.Asistencia;

import java.util.ArrayList;
import java.util.List;

public class AsistenciaController {
    private List<Asistencia> asistencias = new ArrayList<>();

    public void registrar(Asistencia a) {
        asistencias.add(a);
    }

    public List<Asistencia> listar() {
        return asistencias;
    }

    public Asistencia buscarPorId(String id) {
        for (Asistencia a : asistencias) {
            if (a.getIdAsistencia().equals(id)) return a;
        }
        return null;
    }

    public void actualizar(Asistencia actualizado) {
        for (int i = 0; i < asistencias.size(); i++) {
            if (asistencias.get(i).getIdAsistencia().equals(actualizado.getIdAsistencia())) {
                asistencias.set(i, actualizado);
            }
        }
    }

    public void eliminar(String id) {
        asistencias.removeIf(a -> a.getIdAsistencia().equals(id));
    }
}
