package co.edu.uniquindio.poo.academiademusica.model;
import co.edu.uniquindio.poo.academiademusica.model.enums.Instrumento;
import co.edu.uniquindio.poo.academiademusica.model.enums.Nivel;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private int capacidad;
    private Instrumento instrumento;
    private Nivel nivel;
    private Curso curso;
    private List<Clase> listClases;

    public Curso(int capacidad, Instrumento instrumento, Nivel nivel,  Curso curso) {
        this.capacidad = capacidad;
        this.instrumento = instrumento;
        this.nivel = nivel;
        this.curso = curso;
        this.listClases = new ArrayList<>();
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
