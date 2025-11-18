package co.edu.uniquindio.poo.academiademusica.viewController;

import co.edu.uniquindio.poo.academiademusica.model.Estudiante;
import co.edu.uniquindio.poo.academiademusica.model.enums.Nivel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class EstudianteViewController {

    @FXML private TextField txtIdEstudiante;
    @FXML private TextField txtNombre;
    @FXML private TextField txtEmail;
    @FXML private TextField txtEdad;
    @FXML private ComboBox<String> cmbNivel;
    @FXML private TextField txtCurso;
    @FXML private TextField txtAsistencia;
    @FXML private TextField txtProgreso;

    @FXML private TableView<Estudiante> tblEstudiantes;
    @FXML private TableColumn<Estudiante, String> tbcIdEstudiante;
    @FXML private TableColumn<Estudiante, String> tbcNombre;
    @FXML private TableColumn<Estudiante, String> tbcNivel;
    @FXML private TableColumn<Estudiante, String> tbcCurso;
    @FXML private TableColumn<Estudiante, String> tbcAsistencia;
    @FXML private TableColumn<Estudiante, String> tbcProgreso;

    private final ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        cargarNiveles();
        configurarTabla();
        manejarSeleccionTabla();
    }

    private void cargarNiveles() {
        cmbNivel.setItems(FXCollections.observableArrayList(
                "PRINCIPIANTE", "INTERMEDIO", "AVANZADO"
        ));
    }

    private void configurarTabla() {
        tbcIdEstudiante.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(d.getValue().getIdEstudiante()));
        tbcNombre.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(d.getValue().getNombre()));
        tbcNivel.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(d.getValue().getNivel().name()));
        tbcCurso.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(d.getValue().getCurso()));
        tbcAsistencia.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(String.valueOf(d.getValue().getAsistencia())));
        tbcProgreso.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(String.valueOf(d.getValue().getProgreso())));

        tblEstudiantes.setItems(listaEstudiantes);
    }

    private void manejarSeleccionTabla() {
        tblEstudiantes.getSelectionModel().selectedItemProperty().addListener((obs, old, nuevo) -> {
            if (nuevo != null) {
                txtIdEstudiante.setText(nuevo.getIdEstudiante());
                txtNombre.setText(nuevo.getNombre());
                txtEmail.setText(nuevo.getEmail());
                txtEdad.setText(String.valueOf(nuevo.getEdad()));
                cmbNivel.setValue(nuevo.getNivel().name());
                txtCurso.setText(nuevo.getCurso());
                txtAsistencia.setText(String.valueOf(nuevo.getAsistencia()));
                txtProgreso.setText(String.valueOf(nuevo.getProgreso()));
            }
        });
    }

    private Estudiante construirEstudianteDesdeFormulario() {

        try {
            String id = txtIdEstudiante.getText().trim();
            String nombre = txtNombre.getText().trim();
            String email = txtEmail.getText().trim();
            int edad = Integer.parseInt(txtEdad.getText().trim());
            String nivelStr = cmbNivel.getValue();
            String curso = txtCurso.getText().trim();
            double asistencia = Double.parseDouble(txtAsistencia.getText().trim());
            double progreso = Double.parseDouble(txtProgreso.getText().trim());

            if (id.isEmpty() || nombre.isEmpty() || email.isEmpty() || nivelStr == null
                    || curso.isEmpty()) {
                mostrarAlerta("Todos los campos son obligatorios.");
                return null;
            }

            Nivel nivel = Nivel.valueOf(nivelStr);

            return new Estudiante(nombre, email, id, edad, nivel, curso, asistencia, progreso);

        } catch (Exception e) {
            mostrarAlerta("Datos inválidos: " + e.getMessage());
            return null;
        }
    }

    @FXML
    private void onCrear() {
        Estudiante estudiante = construirEstudianteDesdeFormulario();
        if (estudiante != null) {
            listaEstudiantes.add(estudiante);
            onLimpiar();
        }
    }

    @FXML
    private void onActualizar() {
        Estudiante seleccionado = tblEstudiantes.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Seleccione un estudiante para actualizar.");
            return;
        }

        Estudiante nuevo = construirEstudianteDesdeFormulario();
        if (nuevo != null) {
            int pos = listaEstudiantes.indexOf(seleccionado);
            listaEstudiantes.set(pos, nuevo);
            onLimpiar();
        }
    }

    @FXML
    private void onEliminar() {
        Estudiante seleccionado = tblEstudiantes.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Seleccione un estudiante para eliminar.");
            return;
        }

        listaEstudiantes.remove(seleccionado);
        onLimpiar();
    }

    @FXML
    private void onLimpiar() {
        txtIdEstudiante.clear();
        txtNombre.clear();
        txtEmail.clear();
        txtEdad.clear();
        cmbNivel.setValue(null);
        txtCurso.clear();
        txtAsistencia.clear();
        txtProgreso.clear();
        tblEstudiantes.getSelectionModel().clearSelection();
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
    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
