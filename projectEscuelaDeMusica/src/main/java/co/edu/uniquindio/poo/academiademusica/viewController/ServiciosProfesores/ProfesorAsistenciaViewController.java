package co.edu.uniquindio.poo.academiademusica.viewController.ServiciosProfesores;

import co.edu.uniquindio.poo.academiademusica.model.Registro;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;

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
                new Registro("Juan", "Pendiente", "0%"),
                new Registro("Sara", "Pendiente", "0%")
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
    private void subirProgreso() {
        Registro r = tablaAsistencia.getSelectionModel().getSelectedItem();
        if (r == null) return;

        int actual = Integer.parseInt(r.getProgreso().replace("%", ""));
        int nuevo = Math.min(100, actual + 10);

        r.setProgreso(nuevo + "%");
    }

    @FXML
    private void volver() {
        // pendiente enlazar con ProfesorViewController
    }
}
