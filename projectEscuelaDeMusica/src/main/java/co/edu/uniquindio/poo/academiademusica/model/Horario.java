package co.edu.uniquindio.poo.academiademusica.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Horario {

    private final StringProperty dia;
    private final StringProperty hora;

    public Horario(String dia, String hora) {
        this.dia = new SimpleStringProperty(dia);
        this.hora = new SimpleStringProperty(hora);
    }

    public String getDia() {
        return dia.get();
    }

    public void setDia(String dia) {
        this.dia.set(dia);
    }

    public StringProperty diaProperty() {
        return dia;
    }

    public String getHora() {
        return hora.get();
    }

    public void setHora(String hora) {
        this.hora.set(hora);
    }

    public StringProperty horaProperty() {
        return hora;
    }

    @Override
    public String toString() {
        return dia.get() + " - " + hora.get();
    }
}
