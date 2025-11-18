package co.edu.uniquindio.poo.academiademusica.viewController;

import co.edu.uniquindio.poo.academiademusica.controller.ProfesorController;
import co.edu.uniquindio.poo.academiademusica.model.Profesor;
import co.edu.uniquindio.poo.academiademusica.model.enums.Instrumento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfesorViewController {

    @FXML private TextField txtIdProfesor;
    @FXML private TextField txtNombre;
    @FXML private TextField txtEmail;
    @FXML private TextField txtEspecialidad;
    @FXML private ComboBox<Instrumento> cmbInstrumento;
    @FXML private ComboBox<String> cmbRol;

    @FXML private TableView<Profesor> tblProfesores;
    @FXML private TableColumn<Profesor, String> tbcId;
    @FXML private TableColumn<Profesor, String> tbcNombre;
    @FXML private TableColumn<Profesor, String> tbcEmail;
    @FXML private TableColumn<Profesor, String> tbcEspecialidad;
    @FXML private TableColumn<Profesor, String> tbcInstrumento;

    private final ObservableList<Profesor> listaProfesores = FXCollections.observableArrayList();
    private ProfesorController profesorController;

    @FXML
    private void initialize() {
        cmbInstrumento.setItems(FXCollections.observableArrayList(Instrumento.values()));
        cargarRoles();
        configurarTabla();
        manejarSeleccionTabla();
    }

    public void setProfesorController(ProfesorController controller) {
        this.profesorController = controller;
    }
    @FXML
    public void volverAlMenuPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/academiademusica/Usuarios/CrudUsuario.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) txtNombre.getScene().getWindow();

            Scene scene = new Scene(root, 500, 300);
            stage.setScene(scene);
            stage.setTitle("Menú Principal");

        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("No se pudo regresar al menú principal: " + e.getMessage());
        }
    }
    private void cargarRoles() {
        cmbRol.getItems().addAll("Administrador Académico", "Profesor", "Estudiante");

        cmbRol.valueProperty().addListener((obs, viejo, nuevo) -> {
            if (nuevo != null && !nuevo.equals("Profesor")) {
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setHeaderText(null);
                alerta.setContentText("El rol seleccionado no puede ser: " + nuevo);
                alerta.show();
                cmbRol.setValue("Profesor");
            }
        });
    }

    private void configurarTabla() {
        tbcId.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getIdProfesor()));
        tbcNombre.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getNombre()));
        tbcEmail.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getEmail()));
        tbcEspecialidad.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getEspecialidad()));
        tbcInstrumento.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getInstrumento().name()));

        tblProfesores.setItems(listaProfesores);
    }

    private void manejarSeleccionTabla() {
        tblProfesores.getSelectionModel().selectedItemProperty().addListener(
                (obs, viejo, nuevo) -> {
                    if (nuevo != null) {
                        txtIdProfesor.setText(nuevo.getIdProfesor());
                        txtNombre.setText(nuevo.getNombre());
                        txtEmail.setText(nuevo.getEmail());
                        txtEspecialidad.setText(nuevo.getEspecialidad());
                        cmbInstrumento.setValue(nuevo.getInstrumento());
                        cmbRol.setValue("Profesor");
                    }
                }
        );
    }

    @FXML
    private void onAgregarProfesor() {
        Profesor profesor = construirProfesorDesdeFormulario();
        if (profesor == null) return;

        listaProfesores.add(profesor);
        onLimpiar();
    }

    @FXML
    private void onActualizarProfesor() {
        Profesor seleccionado = tblProfesores.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            mostrarAlerta("Seleccione un profesor para actualizar.");
            return;
        }

        Profesor actualizado = construirProfesorDesdeFormulario();
        if (actualizado == null) return;

        int index = listaProfesores.indexOf(seleccionado);
        listaProfesores.set(index, actualizado);

        onLimpiar();
    }

    private Profesor construirProfesorDesdeFormulario() {
        String nombre = txtNombre.getText().trim();
        String email = txtEmail.getText().trim();
        String id = txtIdProfesor.getText().trim();
        String especialidad = txtEspecialidad.getText().trim();
        Instrumento instrumento = cmbInstrumento.getValue();

        if (nombre.isEmpty() || email.isEmpty() || id.isEmpty() || especialidad.isEmpty() || instrumento == null) {
            mostrarAlerta("Todos los campos son obligatorios.");
            return null;
        }

        return new Profesor(nombre, email, id, instrumento, especialidad);
    }

    @FXML
    private void onEliminarProfesor() {
        Profesor seleccionado = tblProfesores.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Seleccione un profesor para eliminar.");
            return;
        }

        listaProfesores.remove(seleccionado);
        onLimpiar();
    }

    @FXML
    private void onLimpiar() {
        txtIdProfesor.clear();
        txtNombre.clear();
        txtEmail.clear();
        txtEspecialidad.clear();
        cmbInstrumento.setValue(null);
        cmbRol.setValue(null);
        tblProfesores.getSelectionModel().clearSelection();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void onMenu() {
        cargarVentana("/co/edu/uniquindio/poo/academiademusica/ServiciosProfesores/MenuProfesor.fxml");
    }

    private void cargarVentana(String ruta) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ruta));
            Parent root = loader.load();

            Stage stage = (Stage) txtNombre.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("No se pudo abrir la ventana: " + e.getMessage());
        }
    }
}

