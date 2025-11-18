package co.edu.uniquindio.poo.academiademusica.viewController;

import co.edu.uniquindio.poo.academiademusica.model.Salon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class SalonViewController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtCapacidad;
    @FXML private TextField txtIdAdministrador;

    @FXML private TableView<Salon> tblSalones;
    @FXML private TableColumn<Salon, String> tbcNombre;
    @FXML private TableColumn<Salon, Integer> tbcCapacidad;
    @FXML private TableColumn<Salon, String> tbcAdministrador;

    @FXML private Button btnCrear, btnActualizar, btnLimpiar, btnEliminar, btnVolver;

    private final ObservableList<Salon> listaSalones = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        tblSalones.setItems(listaSalones);

        tbcNombre.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getNombre()));
        tbcCapacidad.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getCapacidad()).asObject());
        tbcAdministrador.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(
                c.getValue().getAdministradorAcademico() != null ? c.getValue().getAdministradorAcademico().getNombre() : "Sin asignar")
        );


        tblSalones.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                txtNombre.setText(newSel.getNombre());
                txtCapacidad.setText(String.valueOf(newSel.getCapacidad()));
                txtIdAdministrador.setText(newSel.getAdministradorAcademico() != null
                        ? newSel.getAdministradorAcademico().getId()
                        : "");
            }
        });
    }

    @FXML
    public void onCrear() {
        if (txtNombre.getText().isEmpty() || txtCapacidad.getText().isEmpty()) {
            showAlert("Completa todos los campos obligatorios.");
            return;
        }

        Salon salon = new Salon(txtNombre.getText(),
                Integer.parseInt(txtCapacidad.getText()),
                null // administrador pendiente
        );
        listaSalones.add(salon);
        tblSalones.refresh();
        clearFields();
    }

    @FXML
    public void onActualizar() {
        Salon seleccionado = tblSalones.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            showAlert("Selecciona un salón de la tabla para actualizar.");
            return;
        }

        seleccionado.setNombre(txtNombre.getText());
        seleccionado.setCapacidad(Integer.parseInt(txtCapacidad.getText()));
        tblSalones.refresh();
        clearFields();
    }

    @FXML
    public void onEliminar() {
        Salon seleccionado = tblSalones.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaSalones.remove(seleccionado);
            tblSalones.refresh();
            clearFields();
        } else {
            showAlert("Selecciona un salón para eliminar.");
        }
    }

    @FXML
    public void onLimpiar() {
        clearFields();
    }


    private void clearFields() {
        txtNombre.clear();
        txtCapacidad.clear();
        txtIdAdministrador.clear();
        tblSalones.getSelectionModel().clearSelection();
    }

    private void showAlert(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING, mensaje, ButtonType.OK);
        alert.showAndWait();
    }
    @FXML
    private void volver() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/co/edu/uniquindio/poo/academiademusica/VentanaPrincipal.fxml"
            ));
            Parent root = loader.load();

            Stage stage = (Stage) tblSalones.getScene().getWindow();
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
