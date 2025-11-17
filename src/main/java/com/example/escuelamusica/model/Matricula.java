package com.example.escuelamusica.model;

import java.time.LocalDate;

public class Matricula {
    private String idMatricula;
    private Estudiante estudiante;
    private Curso curso;
    private LocalDate fecha;
    private EstadoAsistencia estado;

    public Matricula(String idMatricula, Estudiante estudiante, Curso curso, LocalDate fecha, EstadoAsistencia estado) {
        this.idMatricula = idMatricula;
        this.estudiante = estudiante;
        this.curso = curso;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(String idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public EstadoAsistencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsistencia estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "id='" + idMatricula + '\'' +
                ", estudiante=" + estudiante.getNombre() +
                ", curso=" + curso.getInstrumento() +
                ", fecha='" + fecha + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
