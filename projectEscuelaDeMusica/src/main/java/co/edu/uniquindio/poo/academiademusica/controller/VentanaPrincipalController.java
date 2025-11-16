package co.edu.uniquindio.poo.academiademusica.controller;

import co.edu.uniquindio.poo.academiademusica.model.Academia;

public class VentanaPrincipalController {

    private final Academia academia;

    public VentanaPrincipalController(Academia academia) {
        this.academia = academia;
    }


    public AdministradorAcademicoController getAdministradorController() {
        return new AdministradorAcademicoController(academia);
    }

    public EstudianteController getEstudianteController() {
        return new EstudianteController(academia);
    }

    public ProfesorController getProfesorController() {
        return new ProfesorController(academia);
    }

    public CursoController getCursoController() {
        return new CursoController(academia);
    }

    public ClaseController getClaseController() {
        return new ClaseController(academia);
    }

    public SalonController getSalonController() {
        return new SalonController(academia);
    }

    public ReporteProgresoController getReporteProgresoController() {
        return new ReporteProgresoController(academia);
    }

}
