package com.example.escuelamusica.model;

import java.util.LinkedList;

public class Estudiante extends Usuario {
    private String idEstudiante;
    private LinkedList<Curso> listCursosInscritos;
    private LinkedList<Curso> listCursosAprobados;

    public Estudiante (String nombre, String email, String rol, String idEstudiante) {
        super(nombre,email, rol);
        this.idEstudiante=idEstudiante;
        this.listCursosInscritos = new LinkedList<>();
        this.listCursosAprobados = new LinkedList<>();
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public LinkedList<Curso> getListCursosInscritos() {
        return listCursosInscritos;
    }

    public void setListCursosInscritos(LinkedList<Curso> listCursosInscritos) {
        this.listCursosInscritos = listCursosInscritos;
    }

    public LinkedList<Curso> getListCursosAprobados() {
        return listCursosAprobados;
    }

    public void setListCursosAprobados(LinkedList<Curso> listCursosAprobados) {
        this.listCursosAprobados = listCursosAprobados;
    }

    //metodo para inscribirse a un curso
    //metodo que diga mande la aprobacion un curso
}


