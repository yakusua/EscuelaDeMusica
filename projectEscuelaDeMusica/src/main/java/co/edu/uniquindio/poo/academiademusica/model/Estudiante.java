package co.edu.uniquindio.poo.academiademusica.model;

import co.edu.uniquindio.poo.academiademusica.model.enums.Nivel;

import java.util.LinkedList;

public class Estudiante extends Usuario {
    private String idEstudiante;
    private int edad;
    private Nivel nivel;
    private double asistencia;
    private double progreso;
    private LinkedList<Nivel> listCursosAprobados = new LinkedList<>();


    public Estudiante(String nombre, String email, String idEstudiante, int edad, Nivel nivel) {
        super(nombre, email, "Estudiante");
        this.idEstudiante = idEstudiante;
        this.edad = edad;
        this.nivel = nivel;
        this.asistencia = 0.0;
        this.progreso = 0.0;
        this.listCursosAprobados.add(nivel);
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

    public LinkedList<Nivel> getListCursosAprobados() {
        return listCursosAprobados;
    }

    public void setListCursosAprobados(LinkedList<Nivel> listCursosAprobados) {
        this.listCursosAprobados = listCursosAprobados;
    }

    public void agregarCursoAprobado(Nivel nivel) {
        listCursosAprobados.add(nivel);
    }



    public void consultarHorario() {
        System.out.println("Consultando horario de: " + nombre);
    }

    public void descargarReporte() {
        System.out.println("Reporte de progreso de: " + nombre);
    }
    public boolean inscribirCurso(String nombreCurso, Nivel nivelCurso) {
        // Si es nivel 1, no hay prerrequisito
        if (nivelCurso == Nivel.PRINCIPIANTE) {
            System.out.println(nombre + " se inscribió en " + nombreCurso);
            return true;
        }

        // Verificar si aprobó el nivel anterior
        Nivel nivelAnterior;
        switch (nivelCurso) {
            case INTERMEDIO -> nivelAnterior = Nivel.PRINCIPIANTE;
            case AVANZADO-> nivelAnterior = Nivel.INTERMEDIO;
            default -> {
                System.out.println("Nivel no válido");
                return false;
            }
        }

        if (listCursosAprobados.contains(nivelAnterior)) {
            System.out.println(nombre + " quedó inscrito en " + nombreCurso);
            return true;
        } else {
            System.out.println(nombre + " no puede inscribirse a " + nombreCurso + ". Debe aprobar nivel anterior.");
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "Estudiante{" +
                "idEstudiante='" + idEstudiante + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", edad=" + edad +
                ", nivel=" + nivel +
                ", asistencia=" + asistencia +
                ", progreso=" + progreso +
                '}';
    }
}
