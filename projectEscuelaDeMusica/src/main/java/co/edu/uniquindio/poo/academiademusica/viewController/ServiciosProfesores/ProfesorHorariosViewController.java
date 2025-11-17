package co.edu.uniquindio.poo.academiademusica.viewController.ServiciosProfesores;

import co.edu.uniquindio.poo.academiademusica.model.Horario;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;

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
            mostrar("Debes seleccionar un día y una hora.");
            return;
        }

        listaHorarios.add(new Horario(cmbDia.getValue(), txtHora.getText()));
        txtHora.clear();
    }

    @FXML
    private void volver() {
    }

    private void mostrar(String msg) {
        new Alert(Alert.AlertType.WARNING, msg).show();
    }
}
