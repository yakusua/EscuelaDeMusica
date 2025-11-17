package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.Salon;

import java.util.ArrayList;
import java.util.List;

public class SalonController {
    private List<Salon> salones = new ArrayList<>();

    public void crear(Salon a) {
        salones.add(a);
    }

    public List<Salon> listar() {
        return salones;
    }

    public Salon buscarPorId(String id) {
        for (Salon a : salones) {
            if (a.getId().equals(id)) return a;
        }
        return null;
    }

    public void actualizar(Salon actualizado) {
        for (int i = 0; i < salones.size(); i++) {
            if (salones.get(i).getId().equals(actualizado.getId())) {
                salones.set(i, actualizado);
            }
        }
    }

    public void eliminar(String id) {
        salones.removeIf(a -> a.getId().equals(id));
    }
}
