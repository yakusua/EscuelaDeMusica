package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.Clase;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HorarioController {
    // almacenamiento en memoria
    private final List<Clase> clases = new ArrayList<>();

    public HorarioController() { }

    // Guardar o actualizar una clase; devuelve true si fue creada/actualizada
    public boolean guardarClase(Clase nueva) {
        if (nueva == null) {
            System.out.println("Aviso: clase nula. No se guarda.");
            return false;
        }
        // comprobar conflicto local (profesor o salón en mismo día/hora)
        if (existeConflicto(nueva)) {
            System.out.println("Aviso: conflicto de horario. No se guarda la clase.");
            return false;
        }
        // actualizar si ya existe
        for (int i = 0; i < clases.size(); i++) {
            if (clases.get(i).getId().equals(nueva.getId())) {
                clases.set(i, nueva);
                System.out.println("Clase actualizada: " + nueva.getId());
                return true;
            }
        }
        clases.add(nueva);
        System.out.println("Clase agregada: " + nueva.getId());
        return true;
    }

    // Eliminar clase por identificacion
    public boolean eliminarClase(String claseId) {
        if (claseId == null) return false;
        for (int i = 0; i < clases.size(); i++) {
            if (clases.get(i).getId().equals(claseId)) {
                clases.remove(i);
                System.out.println("Clase eliminada: " + claseId);
                return true;
            }
        }
        System.out.println("Aviso: clase no encontrada: " + claseId);
        return false;
    }

    // Verifica si hay conflicto de horario: mismo profesor o mismo salón en la misma fecha y hora
    public boolean existeConflicto(Clase candidata) {
        if (candidata == null) return true;
        LocalDate fecha = candidata.getFecha();
        LocalTime hora = candidata.getHora();
        String profesorId = (candidata.getProfesor() == null) ? null : candidata.getProfesor().getIdProfesor();
        String salonId = (candidata.getSalon() == null) ? null : candidata.getSalon().getId();

        for (int i = 0; i < clases.size(); i++) {
            Clase c = clases.get(i);
            if (c == null) continue;
            if (!c.getFecha().equals(fecha)) continue;
            if (!c.getHora().equals(hora)) continue;

            //mismo profesor
            if (profesorId != null && c.getProfesor() != null && profesorId.equals(c.getProfesor().getIdProfesor())) {
                return true;
            }
            //mismo salón
            if (salonId != null && c.getSalon() != null && salonId.equals(c.getSalon().getId())) {
                return true;
            }
        }
        return false;
    }

    // Listar todas las clases
    public List<Clase> listarClases() {
        List<Clase> copia = new ArrayList<>();
        for (int i = 0; i < clases.size(); i++) copia.add(clases.get(i));
        return copia;
    }

    // Buscar clase por identificacion
    public Clase buscarClasePorId(String id) {
        if (id == null) return null;
        for (int i = 0; i < clases.size(); i++) {
            if (clases.get(i).getId().equals(id)) return clases.get(i);
        }
        return null;
    }

}
