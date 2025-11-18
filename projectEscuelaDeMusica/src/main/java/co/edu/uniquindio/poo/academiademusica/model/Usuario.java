package co.edu.uniquindio.poo.academiademusica.model;

public abstract class Usuario implements IUsuario {
    protected String nombre;
    protected String email;
    protected String rol;

    public Usuario(String nombre, String email, String rol) {
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    //metodos del interface

    @Override
    public void registrar() {
        System.out.println(rol + " registrado: " + nombre);
    }

    @Override
    public void actualizar() {
        System.out.println("Datos actualizados para " + rol + ": " + nombre);
    }

    @Override
    public String toString() {
        return rol + "{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}