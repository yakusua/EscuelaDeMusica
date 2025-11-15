package co.edu.uniquindio.poo.academiademusica.model;

public class AdministradorAcademico extends Usuario {
    private String idAdministrador;
// se relaciona con entidads pero no las posee

    public AdministradorAcademico(String nombre, String email, String rol, String idAdministrador) {
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