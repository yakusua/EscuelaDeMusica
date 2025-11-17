package com.example.escuelamusica.controller;

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
            if (p.getIdprofesor().equals(id)) return p;
        }
        return null;
    }

    public void actualizar(Profesor actualizado) {
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getIdprofesor().equals(actualizado.getIdprofesor())) {
                profesores.set(i, actualizado);
            }
        }
    }

    public void eliminar(String id) {
        profesores.removeIf(p -> p.getIdprofesor().equals(id));
    }
}
