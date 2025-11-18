package com.example.escuelamusica.model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Clase implements IAsistible {
    protected String id;
    protected LocalDate fecha;
    protected LocalTime hora;
    protected int cupo;
    protected Profesor profesor;
    protected Curso curso;
    protected Salon salon;
    protected List<Asistencia> listAsistencias;

    public Clase(String id, LocalDate fecha, LocalTime hora, int cupo, Profesor profesor, Curso curso, Salon salon) {
        this.id = (id == null || id.isBlank()) ? java.util.UUID.randomUUID().toString() : id;
        this.fecha = (fecha == null) ? LocalDate.now() : fecha;
        this.hora = (hora == null) ? LocalTime.of(0,0) : hora;
        this.cupo = (cupo <= 0) ? 1 : cupo;
        this.profesor = profesor;
        this.curso = curso;
        this.salon = salon;
        this.listAsistencias = new ArrayList<>();
    }

    public void setProfesor(Profesor profesor) {
        if (profesor == null) {
            System.out.println("Aviso: profesor nulo. No se asignó.");
            return;
        }
        this.profesor = profesor;
    }

    public void setSalon(Salon salon) {
        if (salon == null) {
            System.out.println("Aviso: salon nulo. No se asignó.");
            return;
        }
        this.salon = salon;
    }

    public void setCurso(Curso curso) {
        if (curso == null) {
            System.out.println("Aviso: curso nulo. No se asignó.");
            return;
        }
        this.curso = curso;
    }


    public String getId() { return id; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHora() { return hora; }
    public int getCupo() {
        return cupo;
    }
    public Profesor getProfesor() { return profesor; }
    public Curso getCurso() { return curso; }
    public Salon getSalon() { return salon; }
    public List<Asistencia> getListAsistencias() { return new ArrayList<>(listAsistencias); }

    protected int estudiantesInscritosSize() {
        if (this instanceof ClaseGrupal) {
            return ((ClaseGrupal) this).getEstudiantesInscritos().size();
        } else if (this instanceof ClaseIndividual) {
            return (((ClaseIndividual) this).getEstudiante() == null) ? 0 : 1;
        }
        return 0;
    }

    public boolean estaCompletaLocal() {
        return estudiantesInscritosSize() >= cupo;
    }

    public abstract List<Estudiante> obtenerEstudiantesInscritos();
    protected abstract boolean validarEstudianteInscrito(Estudiante estudiante);
}
