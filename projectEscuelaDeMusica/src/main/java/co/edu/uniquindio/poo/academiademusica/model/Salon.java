package co.edu.uniquindio.poo.academiademusica.model;

import java.util.LinkedList;

public class Salon {
    private String nombre;
    private int capacidad;
    private Clase clase;
    private AdministradorAcademico administradorAcademico;

    public Salon (String nombre, int capacidad, AdministradorAcademico administradorAcademico) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.administradorAcademico = administradorAcademico;
    }

    public AdministradorAcademico getAdministradorAcademico() {
        return administradorAcademico;
    }

    public void setAdministradorAcademico(AdministradorAcademico administradorAcademico) {
        this.administradorAcademico = administradorAcademico;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
