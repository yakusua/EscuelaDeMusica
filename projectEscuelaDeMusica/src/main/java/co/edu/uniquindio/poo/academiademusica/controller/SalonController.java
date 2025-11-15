package co.edu.uniquindio.poo.academiademusica.controller;

import co.edu.uniquindio.poo.academiademusica.model.Academia;
import co.edu.uniquindio.poo.academiademusica.model.Salon;

import java.util.List;

public class SalonController {

    private Academia academia;

    public SalonController(Academia academia) {
        this.academia = academia;
    }

    public boolean crearSalon(Salon salon) {
        return academia.agregarSalon(salon);
    }

    public List<Salon> obtenerListaSalones() {
        return academia.listarSalones();
    }

    public Salon buscarSalon(String nombre) {
        return academia.buscarSalon(nombre);
    }

    public boolean eliminarSalon(String nombre) {
        return academia.eliminarSalon(nombre);
    }

    public boolean actualizarSalon(String nombre, Salon salonActualizado) {
        return academia.actualizarSalon(nombre, salonActualizado);
    }
}
