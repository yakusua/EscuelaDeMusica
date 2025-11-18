package co.edu.uniquindio.poo.academiademusica.model;

import co.edu.uniquindio.poo.academiademusica.model.enums.Nivel;

import java.util.LinkedList;

public class Estudiante extends Usuario {

    private String idEstudiante;
    private int edad;
    private Nivel nivel;
    private double asistencia;
    private double progreso;
    private String curso; // <- agregado
    private LinkedList<Nivel> listCursosAprobados = new LinkedList<>();

    public Estudiante(String nombre, String email, String idEstudiante, int edad,
                      Nivel nivel, String curso, double asistencia, double progreso) {

        super(nombre, email, "Estudiante");
        this.idEstudiante = idEstudiante;
        this.edad = edad;
        this.nivel = nivel;
        this.curso = curso;
        this.asistencia = asistencia;
        this.progreso = progreso;

        this.listCursosAprobados.add(nivel);
    }

    public String getIdEstudiante() { return idEstudiante; }
    public void setIdEstudiante(String idEstudiante) { this.idEstudiante = idEstudiante; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public Nivel getNivel() { return nivel; }
    public void setNivel(Nivel nivel) { this.nivel = nivel; }

    public double getAsistencia() { return asistencia; }
    public void setAsistencia(double asistencia) { this.asistencia = asistencia; }

    public double getProgreso() { return progreso; }
    public void setProgreso(double progreso) { this.progreso = progreso; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public LinkedList<Nivel> getListCursosAprobados() { return listCursosAprobados; }

    @Override
    public String toString() {
        return "Estudiante{" +
                "idEstudiante='" + idEstudiante + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", curso='" + curso + '\'' +
                '}';
    }

}
