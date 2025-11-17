package com.example.escuelamusica.model;

public class EvaluacionNivel {
    private String idEvaluacionNivel;
    private Estudiante estudiante;
    private Curso curso;
    private Nivel nivel;          // o puedes usar int si manejan niveles
    private String comentarios;
    private String fecha;

    public EvaluacionNivel(String idEvaluacionNivel, Estudiante estudiante, Curso curso, Nivel nivel, String comentarios, String fecha) {
        this.idEvaluacionNivel = idEvaluacionNivel;
        this.estudiante = estudiante;
        this.curso = curso;
        this.nivel = nivel;
        this.comentarios = comentarios;
        this.fecha = fecha;
    }

    public String getIdEvaluacionNivel() {
        return idEvaluacionNivel;
    }

    public void setId(String idEvaluacionNivel) {
        this.idEvaluacionNivel = idEvaluacionNivel;
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

    public Nivel getNivel() {
        return nivel;
    }

    public void setNota(Nivel nivel) {
        this.nivel = nivel;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Evaluacion{" +
                "id='" + idEvaluacionNivel + '\'' +
                ", estudiante=" + estudiante.getNombre() +
                ", curso=" + curso.getIdCurso() +
                ", nota=" + nivel +
                ", comentarios='" + comentarios + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
