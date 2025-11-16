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

    public Salon buscarSalon(Salon salon) {
        return academia.buscarSalon(salon);
    }

    public boolean eliminarSalon(Salon salon) {
        return academia.eliminarSalon(salon);
    }

    public boolean actualizarSalon(Salon salon,Salon salonEditable) {
        return academia.actualizarSalon(salon,salonEditable);
    }
}
