package co.edu.uniquindio.poo.academiademusica.viewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class CursoViewController {

    @FXML private TextField txtIdCurso;
    @FXML private TextField txtCapacidad;
    @FXML private ComboBox<String> cmbInstrumento;
    @FXML private ComboBox<String> cmbNivel;

    @FXML private TableView<Curso> tblCursos;
    @FXML private TableColumn<Curso, String> tbcIdCurso;
    @FXML private TableColumn<Curso, String> tbcCapacidad;
    @FXML private TableColumn<Curso, String> tbcInstrumento;
    @FXML private TableColumn<Curso, String> tbcNivel;

    private final ObservableList<Curso> listaCursos = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        configurarTabla();
        manejarSeleccionTabla();
    }

    private void configurarTabla() {
        tbcIdCurso.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getIdCurso()));
        tbcCapacidad.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(String.valueOf(d.getValue().getCapacidad())));
        tbcInstrumento.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getInstrumento()));
        tbcNivel.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getNivel()));

        tblCursos.setItems(listaCursos);
    }

    private void manejarSeleccionTabla() {
        tblCursos.getSelectionModel().selectedItemProperty().addListener((obs, viejo, nuevo) -> {
            if (nuevo != null) {
                txtIdCurso.setText(nuevo.getIdCurso());
                txtCapacidad.setText(String.valueOf(nuevo.getCapacidad()));
                cmbInstrumento.setValue(nuevo.getInstrumento());
                cmbNivel.setValue(nuevo.getNivel());
            }
        });
    }

    private Curso construirCursoDesdeFormulario() {
        String id = txtIdCurso.getText().trim();
        String capacidadStr = txtCapacidad.getText().trim();
        String instrumento = cmbInstrumento.getValue();
        String nivel = cmbNivel.getValue();

        if (id.isEmpty() || capacidadStr.isEmpty() || instrumento == null || nivel == null) {
            mostrarAlerta("Todos los campos son obligatorios.");
            return null;
        }

        int capacidad;
        try {
            capacidad = Integer.parseInt(capacidadStr);
        } catch (NumberFormatException e) {
            mostrarAlerta("Capacidad inválida.");
            return null;
        }

        return new Curso(id, capacidad, instrumento, nivel);
    }

    @FXML
    private void onCrear() {
        Curso curso = construirCursoDesdeFormulario();
        if (curso != null) {
            listaCursos.add(curso);
            onLimpiar();
        }
    }

    @FXML
    private void onActualizar() {
        Curso seleccionado = tblCursos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Seleccione un curso para actualizar.");
            return;
        }
        Curso actualizado = construirCursoDesdeFormulario();
        if (actualizado != null) {
            int index = listaCursos.indexOf(seleccionado);
            listaCursos.set(index, actualizado);
            onLimpiar();
        }
    }

    @FXML
    private void onEliminar() {
        Curso seleccionado = tblCursos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaCursos.remove(seleccionado);
            onLimpiar();
        } else {
            mostrarAlerta("Seleccione un curso para eliminar.");
        }
    }

    @FXML
    private void onLimpiar() {
        txtIdCurso.clear();
        txtCapacidad.clear();
        cmbInstrumento.setValue(null);
        cmbNivel.setValue(null);
        tblCursos.getSelectionModel().clearSelection();
    }

    @FXML
    private void volverAlMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/co/edu/uniquindio/poo/academiademusica/VentanaPrincipal.fxml"
            ));
            Parent root = loader.load();
            Stage stage = (Stage) txtIdCurso.getScene().getWindow();
            stage.setScene(new Scene(root, 500, 300));
            stage.setTitle("Menú Principal");
        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("No se pudo regresar al menú principal: " + e.getMessage());
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static class Curso {
        private final String idCurso;
        private final int capacidad;
        private final String instrumento;
        private final String nivel;

        public Curso(String idCurso, int capacidad, String instrumento, String nivel) {
            this.idCurso = idCurso;
            this.capacidad = capacidad;
            this.instrumento = instrumento;
            this.nivel = nivel;
        }

        public String getIdCurso() { return idCurso; }
        public int getCapacidad() { return capacidad; }
        public String getInstrumento() { return instrumento; }
        public String getNivel() { return nivel; }
    }
}

