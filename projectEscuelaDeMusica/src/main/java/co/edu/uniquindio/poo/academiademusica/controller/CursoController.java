package co.edu.uniquindio.poo.academiademusica.controller;

import co.edu.uniquindio.poo.academiademusica.model.Academia;
import co.edu.uniquindio.poo.academiademusica.model.Curso;

import java.util.List;

public class CursoController {

    private Academia academia;

    public CursoController(Academia academia) {
        this.academia = academia;
    }

    public boolean crearCurso(Curso curso) {
        return academia.agregarCurso(curso);
    }

    public List<Curso> obtenerListaCursos() {
        return academia.listarCursos();
    }

    public Curso buscarCurso(int capacidad) {
        return academia.buscarCurso(capacidad);
    }

    public boolean eliminarCurso(int capacidad) {
        return academia.eliminarCurso(capacidad);
    }

    public boolean actualizarCurso(int capacidad, Curso cursoActualizado) {
        return academia.actualizarCurso(capacidad, cursoActualizado);
    }
}
