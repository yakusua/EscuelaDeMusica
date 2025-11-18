package com.example.escuelamusica.model;

import java.util.LinkedList;
import java.util.Objects;

public class Profesor extends Usuario {
    private String idProfesor;
    private String especialidad;
    private LinkedList<Clase> listClasesAsignadas;
    private Instrumento instrumento;

    public Profesor(String nombre, String email, String rol,String idProfesor, String especialidad, Instrumento instrumento) {
        super(nombre, email, rol);
        this.idProfesor = idProfesor;
        this.especialidad = especialidad;
        this.listClasesAsignadas = new LinkedList<>();
        this.instrumento = instrumento;
    }

    public LinkedList<Clase> getListClasesAsignadas() {
        return listClasesAsignadas;
    }

    public void setListClasesAsignadas(LinkedList<Clase> listClasesAsignadas) {
        this.listClasesAsignadas = listClasesAsignadas;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }
    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }
    @Override
    public String toString() {
        return "Profesor{" +
                "idProfesor='" + idProfesor + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", instrumento=" + instrumento +
                ", clasesAsignadas=" + listClasesAsignadas.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profesor)) return false;
        Profesor profesor = (Profesor) o;
        return Objects.equals(idProfesor, profesor.idProfesor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProfesor);
    }

}
