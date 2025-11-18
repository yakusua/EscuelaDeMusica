package co.edu.uniquindio.poo.academiademusica.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VentanaPrincipalViewController {

    @FXML
    public void abrirUsuarios() {
        abrirVentana("/co/edu/uniquindio/poo/academiademusica/Usuarios/CrudUsuario.fxml", "Gestión de Usuarios");
    }

    @FXML
    public void abrirCursos() {
        abrirVentana("/co/edu/uniquindio/poo/academiademusica/CursoView.fxml", "Cursos");
    }

    @FXML
    public void abrirClases() {
        abrirVentana("/co/edu/uniquindio/poo/academiademusica/Clases/ClasesView.fxml", "Clases");
    }

    @FXML
    public void abrirSalones() {
        abrirVentana("/co/edu/uniquindio/poo/academiademusica/SalonView.fxml", "Salones");
    }


    private void abrirVentana(String ruta, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ruta));
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
