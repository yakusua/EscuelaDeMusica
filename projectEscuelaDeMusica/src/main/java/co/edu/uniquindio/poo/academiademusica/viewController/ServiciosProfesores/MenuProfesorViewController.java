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
    private VBox root; // <---- ESTE ES EL QUE SE USA

    @FXML
    private void irAsistencia() {
        cambiarVentana("/co/edu/uniquindio/poo/academiademusica/ServiciosProfesores/ProfesorAsistencia.fxml","Asistencia");
    }

    @FXML
    private void irClases() {
        cambiarVentana("/co/edu/uniquindio/poo/academiademusica/ServiciosProfesores/ProfesorClasesGrupales.fxml","Clases grupales");
    }

    @FXML
    private void irComentarios() {
        cambiarVentana("/co/edu/uniquindio/poo/academiademusica/ServiciosProfesores/ProfesorComentarios.fxml","Comentarios");
    }

    @FXML
    private void irHorarios() {
        cambiarVentana("/co/edu/uniquindio/poo/academiademusica/ServiciosProfesores/ProfesorHorarios.fxml","Horarios");
    }

    private void cambiarVentana(String ruta, String titulo) {
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
