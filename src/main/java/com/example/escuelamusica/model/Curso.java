package com.example.escuelamusica.model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String idCurso;
    private int capacidad;
    private Instrumento instrumento;
    private Nivel nivel;
    private Curso curso;
    private List<Clase> listClases;

    public Curso(String idCurso, int capacidad, Instrumento instrumento, Nivel nivel,  Curso curso) {
        this.idCurso = idCurso;
        this.capacidad = capacidad;
        this.instrumento = instrumento;
        this.nivel = nivel;
        this.curso = curso;
        this.listClases = new ArrayList<>();
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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
}
