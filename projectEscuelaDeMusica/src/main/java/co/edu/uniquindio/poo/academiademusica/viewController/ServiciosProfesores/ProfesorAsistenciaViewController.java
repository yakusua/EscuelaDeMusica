package co.edu.uniquindio.poo.academiademusica.viewController.ServiciosProfesores;

import co.edu.uniquindio.poo.academiademusica.model.Registro;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfesorAsistenciaViewController {

    @FXML private TableView<Registro> tablaAsistencia;
    @FXML private TableColumn<Registro, String> colNombre;
    @FXML private TableColumn<Registro, String> colAsistencia;
    @FXML private TableColumn<Registro, String> colProgreso;

    private ObservableList<Registro> lista = FXCollections.observableArrayList();


    @FXML
    public void initialize() {

        colNombre.setCellValueFactory(c -> c.getValue().nombreProperty());
        colAsistencia.setCellValueFactory(c -> c.getValue().asistenciaProperty());
        colProgreso.setCellValueFactory(c -> c.getValue().progresoProperty());

        lista.addAll(
                new Registro("Juan", " Presente  PRESENTE, AUSENTE, EXCUSA", "0%"),
                new Registro("Sara", "Presente", "0%"),
                new Registro("Lucia", "Ausente", "20%"),
                new Registro("Valentina", "Excusa", "0%"),
                new Registro("Salomé", "Ausente", "0%"),
                new Registro("Emiliano", "Presente", "0%"),
                new Registro("Mario", "Excusa", "0%")
        );

        tablaAsistencia.setItems(lista);
    }

    @FXML
    private void marcarPresente() {
        Registro r = tablaAsistencia.getSelectionModel().getSelectedItem();
        if (r == null) return;
        r.setAsistencia("Presente");
    }

    @FXML
    private void marcarAusente() {
        Registro r = tablaAsistencia.getSelectionModel().getSelectedItem();
        if (r == null) return;
        r.setAsistencia("Ausente");
    }
    @FXML
    private void marcarExcusa() {
        Registro r = tablaAsistencia.getSelectionModel().getSelectedItem();
        if (r == null) return;
        r.setAsistencia("Excusa");
    }

    @FXML
    private void subirProgreso() {
        Registro r = tablaAsistencia.getSelectionModel().getSelectedItem();
        if (r == null) return;

        int actual = Integer.parseInt(r.getProgreso().replace("%", ""));
        int nuevo = Math.min(100, actual + 10);

        r.setProgreso(nuevo + "%");
    }
    @FXML
    private void volver() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/co/edu/uniquindio/poo/academiademusica/ServiciosProfesores/MenuProfesor.fxml"
            ));
            Parent root = loader.load();

            Stage stage = (Stage) tablaAsistencia.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error al regresar al menú del profesor: " + e.getMessage());
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
