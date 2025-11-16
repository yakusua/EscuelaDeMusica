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

    public Estudiante buscarEstudiante(Estudiante estudiante) {
        return academia.buscarEstudiante(estudiante);
    }

    public boolean eliminarEstudiante(Estudiante estudiante) {
        return academia.eliminarEstudiante(estudiante);
    }

    public boolean actualizarEstudiante( Estudiante estudiante,Estudiante estudianteEditable) {
        return academia.actualizarEstudiante(estudiante,estudianteEditable);
    }
}
