package co.edu.uniquindio.poo.academiademusica.viewController.ServiciosProfesores;

import co.edu.uniquindio.poo.academiademusica.model.Horario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfesorHorariosViewController {

    @FXML private ComboBox<String> cmbDia;
    @FXML private TextField txtHora;
    @FXML private TableView<Horario> tablaHorarios;
    @FXML private TableColumn<Horario, String> colDia;
    @FXML private TableColumn<Horario, String> colHora;

    private ObservableList<Horario> listaHorarios = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        cmbDia.setItems(FXCollections.observableArrayList(
                "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"
        ));

        colDia.setCellValueFactory(c -> c.getValue().diaProperty());
        colHora.setCellValueFactory(c -> c.getValue().horaProperty());

        tablaHorarios.setItems(listaHorarios);
    }

    @FXML
    private void agregarHorario() {
        if (cmbDia.getValue() == null || txtHora.getText().isBlank()) {
            mostrarAlerta("Debes seleccionar un día y una hora.");
            return;
        }

        listaHorarios.add(new Horario(cmbDia.getValue(), txtHora.getText()));
        txtHora.clear();
    }

    @FXML
    private void volver() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/co/edu/uniquindio/poo/academiademusica/ServiciosProfesores/MenuProfesor.fxml"
            ));
            Parent root = loader.load();

            Stage stage = (Stage) tablaHorarios.getScene().getWindow();
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

