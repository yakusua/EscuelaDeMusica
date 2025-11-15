package co.edu.uniquindio.poo.academiademusica.model;

public class AdministradorAcademico extends Usuario {
    private String idAdministrador;

    public AdministradorAcademico(String nombre, String email, String idAdministrador) {
        super(nombre, email, "Administrador");
        this.idAdministrador = idAdministrador;
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    // permite modificar la info de un usuario
    public void modificarUsuario(Usuario usuario, String nuevoNombre, String nuevoEmail) {
        usuario.setNombre(nuevoNombre);
        usuario.setEmail(nuevoEmail);
        System.out.println("Usuario modificado por administrador: " + usuario.getNombre());
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
