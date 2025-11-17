package com.example.escuelamusica.model;

import java.util.LinkedList;

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
}
