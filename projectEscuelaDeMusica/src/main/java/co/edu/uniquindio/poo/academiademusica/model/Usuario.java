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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //relación con el implements (boceto)
    @Override
    public void registrar() {
        System.out.println("Usuario registrado: " + nombre);
    }

    @Override
    public void actualizar() {
        System.out.println("Datos actualizados para: " + nombre);
    }

    @Override
    public void consultarHorarios() {
        System.out.println("Consultando horarios de: " + nombre);
    }

    @Override
    public void generarReporte() {
        System.out.println("Generando reporte para: " + nombre);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
