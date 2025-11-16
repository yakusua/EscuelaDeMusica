package co.edu.uniquindio.poo.academiademusica.viewController;

import co.edu.uniquindio.poo.academiademusica.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UsuarioViewController {

    // ventana admins
    @FXML
    private void abrirAdminView() {
        abrirVentana("/co/edu/uniquindio/poo/academiademusica/Usuarios/AdminView.fxml", "Gestión de Administradores");
    }

    // ventana profesores
    @FXML
    private void abrirProfesorView() {
        abrirVentana("/co/edu/uniquindio/poo/academiademusica/Usuarios/ProfesorView.fxml", "Gestión de Profesores");
    }

    // ventana estudiantes
    @FXML
    private void abrirEstudianteView() {
        abrirVentana("/co/edu/uniquindio/poo/academiademusica/Usuarios/EstudianteView.fxml", "Gestión de Estudiantes");
    }


    // abre cualquiera
    private void abrirVentana(String rutaFXML, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(rutaFXML));

            if (loader.getLocation() == null) {
                System.out.println("No se encontró el archivo FXML: " + rutaFXML);
                return;
            }

            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al abrir " + rutaFXML + ": " + e.getMessage());
        }
    }
}
