package co.edu.uniquindio.poo.academiademusica.controller;

import co.edu.uniquindio.poo.academiademusica.model.Academia;
import co.edu.uniquindio.poo.academiademusica.model.AdministradorAcademico;

import java.util.List;

public class AdministradorAcademicoController {

    private Academia academia;

    public AdministradorAcademicoController(Academia academia) {
        this.academia = academia;
    }


    public boolean crearAdministrador(AdministradorAcademico administrador) {
        return academia.agregarAdministrador(administrador);
    }

    public List<AdministradorAcademico> obtenerListaAdministradores() {
        return academia.listarAdministradores();
    }

    public AdministradorAcademico buscarAdministrador(AdministradorAcademico administrador) {
        return academia.buscarAdministrador(administrador);
    }

    public boolean actualizarAdministrador(AdministradorAcademico original, AdministradorAcademico actualizado) {
        return academia.actualizarAdministrador(original, actualizado);
    }

    public boolean eliminarAdministrador(AdministradorAcademico administrador) {
        return academia.eliminarAdministrador(administrador);
    }
}