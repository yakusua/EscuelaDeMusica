package co.edu.uniquindio.poo.academiademusica.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Clase implements IAsistible {

    private String id;
    private int nivel;
    private LocalDateTime horario;
    private int cupo;
    private Profesor profesor;
    private Curso curso;
    private Salon salon;
    protected List<Asistencia> listAsistencias;

    public Clase(String id, int nivel, LocalDateTime horario, int cupo,
                 Profesor profesor, Curso curso, Salon salon) {

        this.id = id;
        this.nivel = nivel;
        this.horario = horario;
        this.cupo = cupo;
        this.profesor = profesor;
        this.curso = curso;
        this.salon = salon;
        this.listAsistencias = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
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
