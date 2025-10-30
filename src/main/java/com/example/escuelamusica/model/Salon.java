package com.example.escuelamusica.model;

import java.util.LinkedList;

public class Salon {
    private String nombre;
    private int capacidad;
    private Clase clase;
    private Administrador administrador;

    public Salon (String nombre, int capacidad, Administrador administrador) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.administrador = administrador;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
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
