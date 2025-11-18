package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.Salon;

import java.util.ArrayList;
import java.util.List;

public class SalonController {
    private final List<Salon> salones = new ArrayList<>();

    public SalonController() { }

    public boolean guardarSalon(Salon s) {
        if (s == null) {
            System.out.println("Aviso: salon nulo. No se guarda.");
            return false;
        }
        for (int i = 0; i < salones.size(); i++) {
            if (salones.get(i).getId().equals(s.getId())) {
                salones.set(i, s);
                System.out.println("Salon actualizado: " + s.getId());
                return true;
            }
        }
        salones.add(s);
        System.out.println("Salon agregado: " + s.getId());
        return true;
    }

    public Salon buscarSalonPorId(String id) {
        if (id == null) return null;
        for (int i = 0; i < salones.size(); i++) {
            if (salones.get(i).getId().equals(id)) return salones.get(i);
        }
        return null;
    }

    public List<Salon> listarSalones() {
        List<Salon> copia = new ArrayList<>();
        for (int i = 0; i < salones.size(); i++) copia.add(salones.get(i));
        return copia;
    }

    public boolean eliminarSalon(String id) {
        if (id == null) return false;
        for (int i = 0; i < salones.size(); i++) {
            if (salones.get(i).getId().equals(id)) {
                salones.remove(i);
                System.out.println("Salon eliminado: " + id);
                return true;
            }
        }
        System.out.println("Aviso: salon no encontrado: " + id);
        return false;
    }
}

