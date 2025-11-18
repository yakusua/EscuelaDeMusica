package com.example.escuelamusica.model;

import java.util.LinkedList;
import java.util.Objects;

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

    public boolean inscribirCursoLocal(Curso curso) {
        if (curso == null) {
            System.out.println("Aviso: curso nulo. No se inscribe.");
            return false;
        }
        for (int i = 0; i < listCursosInscritos.size(); i++) {
            if (listCursosInscritos.get(i).equals(curso)) {
                System.out.println("Aviso: ya inscrito en curso.");
                return false;
            }
        }
        return listCursosInscritos.add(curso);
    }

    public boolean aprobarCursoLocal(Curso curso) {
        if (curso == null) {
            System.out.println("Aviso: curso nulo. No se aprueba.");
            return false;
        }
        boolean encontrado = false;
        for (int i = 0; i < listCursosInscritos.size(); i++) {
            if (listCursosInscritos.get(i).equals(curso)) {
                listCursosInscritos.remove(i);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Aviso: no estaba inscrito en ese curso.");
            return false;
        }
        return listCursosAprobados.add(curso);
    }

    public boolean haAprobadoCursoLocal(Curso curso) {
        if (curso == null) return false;
        for (int i = 0; i < listCursosAprobados.size(); i++) {
            if (listCursosAprobados.get(i).equals(curso)) return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante)) return false;
        Estudiante that = (Estudiante) o;
        return Objects.equals(idEstudiante, that.idEstudiante);
    }

    @Override
    public int hashCode() { return Objects.hash(idEstudiante); }
}






