package co.edu.uniquindio.poo.academiademusica.model;

import co.edu.uniquindio.poo.academiademusica.model.enums.EstadoAsistencia;

import java.time.LocalDate;

public class Asistencia {
    private String id;
    private LocalDate fecha;
    private Estudiante estudiante;
    private Clase clase;
    private EstadoAsistencia estadoAsistencia;
    public Asistencia(String id, LocalDate fecha, Estudiante estudiante, Clase clase, EstadoAsistencia estadoAsistencia) {
        // excepciones nulas de las instancias
        if (estudiante == null) {
            throw new IllegalArgumentException("El estudiante no puede ser nulo");
        }
        if (clase == null) {
            throw new IllegalArgumentException("La clase no puede ser nula");
        }
        if (estadoAsistencia == null) {
            throw new IllegalArgumentException("El estado no puede ser nulo");
        }

        this.id = id;
        this.fecha = fecha;
        this.estudiante = estudiante;
        this.clase = clase;
        this.estadoAsistencia = estadoAsistencia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public EstadoAsistencia getEstadoAsistencia() {
        return estadoAsistencia;
    }

    public void setEstadoAsistencia(EstadoAsistencia estadoAsistencia) {
        this.estadoAsistencia = estadoAsistencia;
    }
    @Override
    public String toString() {
        return "Asistencia{" +
                "id='" + id + '\'' +
                ", fecha=" + fecha +
                ", estudiante=" + (estudiante != null ? estudiante.getNombre() : "null") +
                ", clase=" + (clase != null ? clase.getId() : "null") +
                ", estado=" + estadoAsistencia +
                '}';
    }
    //ternario para validar si exist

}