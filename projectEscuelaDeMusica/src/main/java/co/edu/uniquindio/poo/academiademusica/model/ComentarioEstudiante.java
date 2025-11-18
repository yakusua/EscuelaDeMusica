package co.edu.uniquindio.poo.academiademusica.model;

import javafx.beans.value.ObservableValue;

public class ComentarioEstudiante {

    private String nombre;
    private String comentario;

    public ComentarioEstudiante(String nombre, String comentario) {
        this.nombre = nombre;
        this.comentario = comentario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return nombre + ": " + comentario;
    }

    public ObservableValue<String> estudianteProperty() {
        return null;
    }

    public ObservableValue<String> comentarioProperty() {
        return null;
    }

}
