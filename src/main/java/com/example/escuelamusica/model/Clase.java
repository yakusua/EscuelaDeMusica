package com.example.escuelamusica.model;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Clase implements IAsistible {
    protected String id;
    protected String horario;
    protected int cupo;
    protected Profesor profesor;
    protected Curso curso;
    protected Salon salon;
    protected List<Asistencia> listAsistencias;

    public Clase(String id, String horario,int cupo, Profesor profesor, Curso curso, Salon salon) {
        this.id = id;
        this.horario = horario;
        this.cupo = cupo;
        this.profesor = profesor;
        this.curso = curso;
        this.salon = salon;
        this.listAsistencias = new ArrayList<>();
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Asistencia> getListAsistencias() {
        return listAsistencias;
    }

    public void setListAsistencias(List<Asistencia> listAsistencias) {
        this.listAsistencias = listAsistencias;
    }


    public abstract List<Estudiante> obtenerEstudiantesInscritos();

    protected abstract boolean validarEstudianteInscrito(Estudiante estudiante);
}