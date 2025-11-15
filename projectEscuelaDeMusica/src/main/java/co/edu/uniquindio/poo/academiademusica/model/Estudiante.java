package co.edu.uniquindio.poo.academiademusica.model;
import co.edu.uniquindio.poo.academiademusica.model.enums.Nivel;

import java.util.LinkedList;

public class Estudiante extends Usuario{

    //hereda atributo nombre
    private String idEstudiante;
    private int edad;
    private Nivel nivel;
    private String curso;
    private double asistencia;
    private double progreso;
    private LinkedList<Curso> listCursosInscritos;
    private LinkedList<Curso> listCursosAprobados;

    public Estudiante(String nombre, String email, String rol,
                      String idEstudiante, int edad, Nivel nivel,
                      String curso, double asistencia, double progreso) {

        super(nombre, email, rol);
        this.idEstudiante = idEstudiante;
        this.edad = edad;
        this.nivel = nivel;
        this.curso = curso;
        this.asistencia = asistencia;
        this.progreso = progreso;
        this.listCursosInscritos = new LinkedList<>();
        this.listCursosAprobados = new LinkedList<>();
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(double asistencia) {
        this.asistencia = asistencia;
    }

    public double getProgreso() {
        return progreso;
    }

    public void setProgreso(double progreso) {
        this.progreso = progreso;
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

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", listCursosAprobados=" + listCursosAprobados +
                ", listCursosInscritos=" + listCursosInscritos +
                ", progreso=" + progreso +
                ", asistencia=" + asistencia +
                ", curso='" + curso + '\'' +
                ", nivel=" + nivel +
                ", edad=" + edad +
                ", idEstudiante='" + idEstudiante + '\'' +
                '}';
    }

}
