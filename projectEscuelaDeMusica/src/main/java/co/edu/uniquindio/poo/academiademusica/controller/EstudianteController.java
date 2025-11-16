package co.edu.uniquindio.poo.academiademusica.controller;

import co.edu.uniquindio.poo.academiademusica.model.Academia;
import co.edu.uniquindio.poo.academiademusica.model.Estudiante;
import java.util.List;

public class EstudianteController {

    private Academia academia;

    public EstudianteController(Academia academia) {
        this.academia = academia;
    }

    public boolean crearEstudiante(Estudiante estudiante) {
        return academia.agregarEstudiante(estudiante);
    }

    public List<Estudiante> obtenerListaEstudiantes() {
        return academia.listarEstudiantes();
    }

    public Estudiante buscarEstudiante(String idEstudiante) {
        return academia.buscarEstudiante(idEstudiante);
    }

    public boolean eliminarEstudiante(String idEstudiante) {
        return academia.eliminarEstudiante(idEstudiante);
    }

    public boolean actualizarEstudiante(String id, Estudiante estudianteActualizado) {
        return academia.actualizarEstudiante(id, estudianteActualizado);
    }
}
