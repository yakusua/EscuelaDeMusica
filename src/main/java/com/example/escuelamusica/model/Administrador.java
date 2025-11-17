package com.example.escuelamusica.model;

public class Administrador extends Usuario {
    private String idAdministrador;
// se relaciona con entidads pero no las posee

    public Administrador(String nombre, String email, String rol, String idAdministrador) {
        super(nombre, email, rol);
        this.idAdministrador = idAdministrador;
    }


    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "idAdministrador='" + idAdministrador + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}
