package co.edu.uniquindio.poo.academiademusica.model;

import co.edu.uniquindio.poo.academiademusica.model.enums.Instrumento;

public class Profesor extends Usuario {
    private String idProfesor;
    private Instrumento instrumento;
    private String especialidad;

    public Profesor(String nombre, String email, String idProfesor, Instrumento instrumento, String especialidad) {
        super(nombre, email, "Profesor");
        this.idProfesor = idProfesor;
        this.instrumento = instrumento;
        this.especialidad = especialidad;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // debe gestionar el horario
    public void gestionarHorario() {
        System.out.println("Gestionando horario del profesor: " + nombre);
    }

    // debe registrar una asistencia
    public void registrarAsistencia(String estudiante) {
        System.out.println("Registrando asistencia del estudiante: " + estudiante + " por " + nombre);
    }

    // debe crear una clase
    public void crearClase(String curso) {
        System.out.println("Creando clase de " + curso + " por profesor: " + nombre);
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "idProfesor='" + idProfesor + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", instrumento=" + instrumento +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}
