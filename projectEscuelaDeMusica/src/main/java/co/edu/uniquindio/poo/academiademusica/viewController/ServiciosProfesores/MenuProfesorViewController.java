package co.edu.uniquindio.poo.academiademusica.viewController.ServiciosProfesores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuProfesorViewController {

    @FXML
    private Button btnAsistencia, btnClases, btnComentarios, btnHorarios;

    @FXML
    private VBox root; //para lograr obtener la ventanActual

    @FXML
    private void irAsistencia() {
        cambiarVentana("/co/edu/uniquindio/poo/academiademusica/ServiciosProfesores/ProfesorAsistencia.fxml");
    }

    @FXML
    private void irClases() {
        cambiarVentana("/co/edu/uniquindio/poo/academiademusica/ServiciosProfesores/ProfesorClasesGrupales.fxml");
    }

    @FXML
    private void irComentarios() {
        cambiarVentana("/co/edu/uniquindio/poo/academiademusica/ServiciosProfesores/ProfesorComentarios.fxml");
    }

    @FXML
    private void irHorarios() {
        cambiarVentana("/co/edu/uniquindio/poo/academiademusica/ServiciosProfesores/ProfesorHorarios.fxml");
    }

    private void cambiarVentana(String ruta) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ruta));
            Parent rootNuevo = loader.load();

            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(new Scene(rootNuevo));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
