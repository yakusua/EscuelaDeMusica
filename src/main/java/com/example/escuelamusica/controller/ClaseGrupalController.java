package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.ClaseGrupal;

import java.util.ArrayList;
import java.util.List;

public class ClaseGrupalController {
    private List<ClaseGrupal> clases = new ArrayList<>();

    public void crear(ClaseGrupal cg) {
        clases.add(cg);
    }

    public List<ClaseGrupal> listar() {
        return clases;
    }

    public ClaseGrupal buscarPorId(String id) {
        for (ClaseGrupal cg : clases) {
            if (cg.getId().equals(id)) return cg;
        }
        return null;
    }

    public void actualizar(ClaseGrupal actualizado) {
        for (int i = 0; i < clases.size(); i++) {
            if (clases.get(i).getId().equals(actualizado.getId())) {
                clases.set(i, actualizado);
            }
        }
    }

    public void eliminar(String id) {
        clases.removeIf(cg -> cg.getId().equals(id));
    }

    public List<ClaseGrupal> listarClases() {
        return clases;
    }
}
