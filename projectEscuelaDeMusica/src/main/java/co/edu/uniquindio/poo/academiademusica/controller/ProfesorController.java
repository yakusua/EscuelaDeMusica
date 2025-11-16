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

    public Profesor buscarProfesor(Profesor profesor) {
        return academia.buscarProfesor(profesor);
    }

    public boolean eliminarProfesor(Profesor profesor) {
        return academia.eliminarProfesor(profesor);
    }

    public boolean actualizarProfesor(Profesor profesor,Profesor profesorEditable) {
        return academia.actualizarProfesor(profesor,profesorEditable);
    }
}
