package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.Asistencia;
import com.example.escuelamusica.model.Clase;
import com.example.escuelamusica.model.Estudiante;

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


    public void eliminar(String id) {
        asistencias.removeIf(a -> a.getIdAsistencia().equals(id));
    }

    public List<Asistencia> obtenerAsistenciasDeEstudiante(Estudiante e) {
        List<Asistencia> r = new ArrayList<>();

        for (Asistencia a : asistencias) {
            if (a.getEstudiante().getIdEstudiante().equals(e.getIdEstudiante())) {
                r.add(a);
            }
        }
        return r;
    }

    public List<Asistencia> obtenerAsistenciasDeClase(Clase clase) {
        List<Asistencia> r = new ArrayList<>();

        for (Asistencia a : asistencias) {
            if (a.getClase().getId().equals(clase.getId())) {
                r.add(a);
            }
        }
        return r;
    }
}
