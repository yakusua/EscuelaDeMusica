package co.edu.uniquindio.poo.academiademusica.model;

public class AdministradorAcademico extends Usuario {

    private String idAdministrador;

    public AdministradorAcademico(String nombre, String email, String idAdministrador) {
        super(nombre, email, "Administrador Académico");
        this.idAdministrador = idAdministrador;
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public void modificarUsuario(Usuario usuario, String nuevoNombre, String nuevoEmail) {
        usuario.setNombre(nuevoNombre);
        usuario.setEmail(nuevoEmail);
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "idAdministrador='" + idAdministrador + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

