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


    public Curso buscarCurso(String curso) {
        return academia.buscarCurso(curso);
    }

    public boolean eliminarCurso(String curso) {
        return academia.eliminarCurso(curso);
    }

    public boolean actualizarCurso(String curso, Curso cursoEditable) {
        return academia.actualizarCurso(curso,cursoEditable);
    }
}

