package co.edu.uniquindio.poo.academiademusica.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Registro {

    private StringProperty nombre;
    private StringProperty asistencia;
    private StringProperty progreso;

    public Registro(String nombre, String asistencia, String progreso) {
        this.nombre = new SimpleStringProperty(nombre);
        this.asistencia = new SimpleStringProperty(asistencia);
        this.progreso = new SimpleStringProperty(progreso);
    }

    public StringProperty nombreProperty() { return nombre; }
    public StringProperty asistenciaProperty() { return asistencia; }
    public StringProperty progresoProperty() { return progreso; }

    public String getNombre() { return nombre.get(); }
    public String getAsistencia() { return asistencia.get(); }
    public String getProgreso() { return progreso.get(); }

    public void setAsistencia(String valor) { asistencia.set(valor); }
    public void setProgreso(String valor) { progreso.set(valor); }
}
