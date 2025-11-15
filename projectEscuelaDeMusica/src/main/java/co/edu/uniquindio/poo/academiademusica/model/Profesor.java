package co.edu.uniquindio.poo.academiademusica.model;

import co.edu.uniquindio.poo.academiademusica.model.enums.Instrumento;

import java.util.LinkedList;

public class Profesor extends Usuario {
    private String idprofesor;
    private String especialidad;
    private LinkedList<Clase> listClasesAsignadas;
    private Instrumento instrumento;

    public Profesor(String nombre, String email, String rol,String idprofesor, String especialidad, Instrumento instrumento) {
        super(nombre, email, rol);
        this.idprofesor = idprofesor;
        this.especialidad = especialidad;
        this.listClasesAsignadas = new LinkedList<>();
        this.instrumento = instrumento;
    }

    public LinkedList<Clase> getListClasesAsignadas() {
        return listClasesAsignadas;
    }

    public void setListClasesAsignadas(LinkedList<Clase> listClasesAsignadas) {
        this.listClasesAsignadas = listClasesAsignadas;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(String idprofesor) {
        this.idprofesor = idprofesor;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }
    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }
    @Override
    public String toString() {
        return "Profesor{" +
                "idProfesor='" + idprofesor + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", instrumento=" + instrumento +
                ", clasesAsignadas=" + listClasesAsignadas.size() +
                '}';
    }
}