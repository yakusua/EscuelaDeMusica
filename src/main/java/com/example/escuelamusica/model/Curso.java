package com.example.escuelamusica.model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String idCurso;
    private int capacidad;
    private Instrumento instrumento;
    private Nivel nivel;
    private Profesor profesor;
    private List<Estudiante> estudiantesInscritos;
    private List<Clase> listClases;

    public Curso(String idCurso, int capacidad, Instrumento instrumento, Nivel nivel,  Curso curso) {
        this.idCurso = idCurso;
        this.capacidad = capacidad;
        this.instrumento = instrumento;
        this.nivel = nivel;
        this.estudiantesInscritos = new ArrayList<>();
        this.listClases = new ArrayList<>();
    }

    public List<Estudiante> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }

    public void setEstudiantesInscritos(List<Estudiante> estudiantesInscritos) {
        this.estudiantesInscritos = estudiantesInscritos;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public List<Clase> getListClases() {
        return listClases;
    }

    public void setListClases(List<Clase> listClases) {
        this.listClases = listClases;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "idCurso='" + idCurso + '\'' +
                ", capacidad=" + capacidad +
                ", instrumento=" + instrumento +
                ", nivel=" + nivel +
                ", inscritos=" + estudiantesInscritos.size() +
                '}';
    }
}
