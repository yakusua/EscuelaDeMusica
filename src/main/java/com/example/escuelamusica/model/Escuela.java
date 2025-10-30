package com.example.escuelamusica.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Escuela {
    private String nombre;
    private String nit;
    private String ubicacion;

    //de relación
    private List<Estudiante> listEstudiantes;
    private List<Profesor> listProfesores;
    private List<Curso> listCursos;
    private List<Salon> listSalones;

    public Escuela(String nombre, String nit, String ubicacion) {
        this.nombre = nombre;
        this.nit = nit;
        this.ubicacion = ubicacion;
        this.listEstudiantes = new ArrayList<>();
        this.listProfesores = new ArrayList<>();
        this.listCursos = new ArrayList<>();
        this.listSalones = new ArrayList<>();
    }

    public List<Salon> getListSalones() {
        return listSalones;
    }

    public void setListSalones(List<Salon> listSalones) {
        this.listSalones = listSalones;
    }

    public List<Curso> getListCursos() {
        return listCursos;
    }

    public void setListCursos(List<Curso> listCursos) {
        this.listCursos = listCursos;
    }

    public List<Profesor> getListProfesores() {
        return listProfesores;
    }

    public void setListProfesores(List<Profesor> listProfesores) {
        this.listProfesores = listProfesores;
    }

    public List<Estudiante> getListEstudiantes() {
        return listEstudiantes;
    }

    public void setListEstudiantes(List<Estudiante> listEstudiantes) {
        this.listEstudiantes = listEstudiantes;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
