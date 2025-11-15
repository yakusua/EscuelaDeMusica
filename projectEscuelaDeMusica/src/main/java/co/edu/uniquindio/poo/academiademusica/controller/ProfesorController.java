package co.edu.uniquindio.poo.academiademusica.controller;

import co.edu.uniquindio.poo.academiademusica.model.Academia;
import co.edu.uniquindio.poo.academiademusica.model.Profesor;

import java.util.List;

public class ProfesorController {

    private Academia academia;

    public ProfesorController(Academia academia) {
        this.academia = academia;
    }

    public boolean crearProfesor(Profesor profesor) {
        return academia.agregarProfesor(profesor);
    }

    public List<Profesor> obtenerListaProfesores() {
        return academia.listarProfesores();
    }

    public Profesor buscarProfesor(String idProfesor) {
        return academia.buscarProfesor(idProfesor);
    }

    public boolean eliminarProfesor(String idProfesor) {
        return academia.eliminarProfesor(idProfesor);
    }

    public boolean actualizarProfesor(String id, Profesor profesorActualizado) {
        return academia.actualizarProfesor(id, profesorActualizado);
    }
}
