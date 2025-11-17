package com.example.escuelamusica.controller;

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
}
