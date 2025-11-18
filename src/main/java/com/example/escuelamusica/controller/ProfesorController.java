package com.example.escuelamusica.controller;

import com.example.escuelamusica.model.Clase;
import com.example.escuelamusica.model.Curso;
import com.example.escuelamusica.model.Profesor;

import java.util.ArrayList;
import java.util.List;

public class ProfesorController {
    private final List<Profesor> profesores = new ArrayList<>();

    public ProfesorController() { }

    public boolean guardarProfesor(Profesor p) {
        if (p == null) {
            System.out.println("Aviso: profesor nulo. No se guarda.");
            return false;
        }
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getIdProfesor().equals(p.getIdProfesor())) {
                profesores.set(i, p);
                System.out.println("Profesor actualizado: " + p.getIdProfesor());
                return true;
            }
        }
        profesores.add(p);
        System.out.println("Profesor agregado: " + p.getIdProfesor());
        return true;
    }

    public Profesor buscarProfesorPorId(String id) {
        if (id == null) return null;
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getIdProfesor().equals(id)) return profesores.get(i);
        }
        return null;
    }

    public List<Profesor> listarProfesores() {
        List<Profesor> copia = new ArrayList<>();
        for (int i = 0; i < profesores.size(); i++) copia.add(profesores.get(i));
        return copia;
    }

    public boolean eliminarProfesor(String id) {
        if (id == null) return false;
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getIdProfesor().equals(id)) {
                profesores.remove(i);
                System.out.println("Profesor eliminado: " + id);
                return true;
            }
        }
        System.out.println("Aviso: profesor no encontrado: " + id);
        return false;
    }

    // asigna una clase a un profesor
    public boolean asignarClase(String profesorId, Clase clase) {
        Profesor p = buscarProfesorPorId(profesorId);
        if (p == null) {
            System.out.println("Aviso: profesor no encontrado: " + profesorId);
            return false;
        }
        if (clase == null) {
            System.out.println("Aviso: clase nula.");
            return false;
        }
        p.getListClasesAsignadas().add(clase);
        System.out.println("Clase asignada al profesor: " + profesorId + " clase=" + clase.getId());
        return true;
    }

    public boolean quitarClase(String profesorId, String claseId) {
        Profesor p = buscarProfesorPorId(profesorId);
        if (p == null) return false;
        List<Clase> lista = p.getListClasesAsignadas();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(claseId)) {
                lista.remove(i);
                System.out.println("Clase removida del profesor: " + profesorId + " clase=" + claseId);
                return true;
            }
        }
        System.out.println("Aviso: clase no encontrada en profesor: " + claseId);
        return false;
    }

    // número de clases asignadas
    public int cargaDocente(String profesorId) {
        Profesor p = buscarProfesorPorId(profesorId);
        if (p == null) return 0;
        return p.getListClasesAsignadas().size();
    }
}

