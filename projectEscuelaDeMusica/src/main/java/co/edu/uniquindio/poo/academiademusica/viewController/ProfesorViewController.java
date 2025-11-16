package co.edu.uniquindio.poo.academiademusica.viewController;

import co.edu.uniquindio.poo.academiademusica.controller.ProfesorController;
import co.edu.uniquindio.poo.academiademusica.model.AdministradorAcademico;
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

    @FXML private TableView<Profesor> tblProfesores;
    @FXML private TableColumn<Profesor, String> tbcId;
    @FXML private TableColumn<Profesor, String> tbcNombre;
    @FXML private TableColumn<Profesor, String> tbcEmail;
    @FXML private TableColumn<Profesor, String> tbcEspecialidad;
    @FXML private TableColumn<Profesor, String> tbcInstrumento;

    private final ObservableList<Profesor> listaProfesores = FXCollections.observableArrayList();
    private ProfesorController profesorController; // ⚠ debe inicializarse desde App


    @FXML
    private ComboBox<String> cmbRol;


    @FXML
    private void initialize() {
        // Inicializar ComboBox de roles
        cmbRol.getItems().addAll();
        cmbInstrumento.setItems(FXCollections.observableArrayList(Instrumento.values()));
            configurarTabla();
            cargarRoles();
            manejarSeleccionTabla();
    }

    public void setProfesorController(ProfesorController controller) {
        this.profesorController = controller;
    }

    private void configurarTabla() {
        tbcId.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getIdProfesor()));
        tbcNombre.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombre()));
        tbcEmail.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getEmail()));
        tbcEspecialidad.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getEspecialidad()));
        tbcInstrumento.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getInstrumento().name()));

        tblProfesores.setItems(listaProfesores);

        tblProfesores.getSelectionModel().selectedItemProperty().addListener(
                (obs, old, nuevo) -> {
                    if(nuevo != null) {
                        txtIdProfesor.setText(nuevo.getIdProfesor());
                        txtNombre.setText(nuevo.getNombre());
                        txtEmail.setText(nuevo.getEmail());
                        txtEspecialidad.setText(nuevo.getEspecialidad());
                        cmbInstrumento.setValue(nuevo.getInstrumento());
                    }
                }
        );
    }
    private void cargarRoles() {
        cmbRol.getItems().addAll(
                "Administrador Académico",
                "Profesor",
                "Estudiante"
        );
//doble verificación, abrir ventana corrrecta y sleccionar Rol correcto
        cmbRol.valueProperty().addListener((obs, viejo, nuevo) -> {
            if (nuevo != null && !nuevo.equals("Profesor")) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("El rol seleccionado no puede ser : " + nuevo);
                alert.showAndWait();

            }
        });
    }

    private void manejarSeleccionTabla() {
        tblProfesores.getSelectionModel().selectedItemProperty().addListener(
                (obs, viejo, nuevo) -> {
                    if (nuevo != null) {
                        txtNombre.setText(nuevo.getNombre());
                        txtEmail.setText(nuevo.getEmail());
                        cmbRol.setValue(nuevo.getRol());
                        txtIdProfesor.setText(nuevo.getIdProfesor());
                    }
                }
        );
    }

    @FXML
    private void onAgregarProfesor() {
        Profesor profesor= construirProfesorDesdeFormulario();
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

        limpiarCampos();
    }


    private Profesor construirProfesorDesdeFormulario() {
        String nombre = txtNombre.getText().trim();
        String email = txtEmail.getText().trim();
        String idProfesor = txtIdProfesor.getText().trim();
        String rol = cmbRol.getValue();
        String especialidad = txtEspecialidad.getText().trim();
        Instrumento instrumento = cmbInstrumento.getValue(); // valor seleccionado del comboBox

        if (nombre.isEmpty() || email.isEmpty() || idProfesor.isEmpty() ||rol == null ||instrumento == null || especialidad.isEmpty()) {
            mostrarAlerta("Todos los campos son obligatorios.");
            return null;
        }

        return new Profesor(nombre, email, idProfesor, instrumento, especialidad);
    }
    @FXML
    private void onEliminarProfesor() {
        Profesor seleccionado = tblProfesores.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Seleccione un administrador para eliminar.");
            return;
        }
        listaProfesores.remove(seleccionado);
        limpiarCampos();
    }

    @FXML
    private void onLimpiar() {
        txtIdProfesor.clear();
        txtNombre.clear();
        txtEmail.clear();
        txtEspecialidad.clear();
        cmbInstrumento.setValue(null);
        tblProfesores.getSelectionModel().clearSelection();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    private void limpiarCampos() {
        txtNombre.clear();
        txtEmail.clear();
        cmbRol.setValue(null);
        txtIdProfesor.clear();
        tblProfesores.getSelectionModel().clearSelection();
    }
    @FXML
    public void volverAlMenuPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/academiademusica/VentanaPrincipal.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) txtNombre.getScene().getWindow();

            Scene scene = new Scene(root, 320, 420);
            stage.setScene(scene);
            stage.setTitle("Menú Principal");

        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("No se pudo regresar al menú principal: " + e.getMessage());
        }
    }
}
