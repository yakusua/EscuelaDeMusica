package com.example.escuelamusica.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Estudiante> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }

    public void setEstudiantesInscritos(List<Estudiante> estudiantesInscritos) {
        this.estudiantesInscritos = estudiantesInscritos;
    }

    public List<Clase> getListClases() {
        return listClases;
    }

    public void setListClases(List<Clase> listClases) {
        this.listClases = listClases;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad <= 0) {
            System.out.println("Aviso: capacidad inválida. No se actualizó.");
            return;
        }
        this.capacidad = capacidad;
    }

    public boolean hayCupoLocal() {
        return estudiantesInscritos.size() < capacidad;
    }

    public boolean inscribirLocal(Estudiante estudiante) {
        if (estudiante == null) {
            System.out.println("Aviso: estudiante nulo. No se inscribe.");
            return false;
        }
        if (!hayCupoLocal()) {
            System.out.println("Aviso: no hay cupo.");
            return false;
        }
        for (int i = 0; i < estudiantesInscritos.size(); i++) {
            if (estudiantesInscritos.get(i).equals(estudiante)) {
                System.out.println("Aviso: estudiante ya inscrito.");
                return false;
            }
        }
        return estudiantesInscritos.add(estudiante);
    }

    public boolean desinscribirLocal(Estudiante estudiante) {
        if (estudiante == null) {
            System.out.println("Aviso: estudiante nulo. No se desinscribe.");
            return false;
        }
        for (int i = 0; i < estudiantesInscritos.size(); i++) {
            if (estudiantesInscritos.get(i).equals(estudiante)) {
                estudiantesInscritos.remove(i);
                return true;
            }
        }
        System.out.println("Aviso: estudiante no encontrado en inscritos.");
        return false;
    }

    public int numeroInscritos() { return estudiantesInscritos.size(); }

    public boolean agregarClaseLocal(Clase clase) {
        if (clase == null) {
            System.out.println("Aviso: clase nula. No se agrega.");
            return false;
        }
        return listClases.add(clase);
    }

    @Override
    public String toString() {
        return "Curso{" + "idCurso='" + idCurso + '\'' + ", capacidad=" + capacidad +
                ", instrumento=" + instrumento + ", nivel=" + nivel + ", inscritos=" + estudiantesInscritos.size() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curso)) return false;
        Curso curso = (Curso) o;
        return Objects.equals(idCurso, curso.idCurso);
    }

    @Override
    public int hashCode() { return Objects.hash(idCurso); }
}

