
package co.edu.uniquindio.poo.academiademusica.controller;
import co.edu.uniquindio.poo.academiademusica.model.Academia;
import co.edu.uniquindio.poo.academiademusica.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

    private List<Usuario> listaUsuarios = new ArrayList<>();

    public UsuarioController(Academia academia) {
    }

    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public List<Usuario> obtenerEmpleados() {
        return listaUsuarios;
    }

    public boolean eliminarUsuario(String usuario) {
        listaUsuarios.remove(usuario);
        return false;
    }

    public boolean actualizarUsuario(String nombre, String email, String rol) {
        return false;
    }
}
