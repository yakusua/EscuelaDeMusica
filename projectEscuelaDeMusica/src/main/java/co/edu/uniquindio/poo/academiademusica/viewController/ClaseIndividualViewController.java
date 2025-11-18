package co.edu.uniquindio.poo.academiademusica.viewController;

import co.edu.uniquindio.poo.academiademusica.model.*;
import co.edu.uniquindio.poo.academiademusica.model.enums.Instrumento;
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

public class ClaseIndividualViewController {

    @FXML private ComboBox<String> cmbInstrumento;
    @FXML private ComboBox<Nivel> cmbNivel;
    @FXML private TextField txtAula;
    @FXML private TextField txtHorario;
    @FXML private ComboBox<Estudiante> cmbEstudiante;

    @FXML private TableView<ClaseIndividual> tablaClasesIndividuales;
    @FXML private TableColumn<ClaseIndividual, String> colEstudiante;
    @FXML private TableColumn<ClaseIndividual, String> colInstrumento;
    @FXML private TableColumn<ClaseIndividual, String> colNivel;
    @FXML private TableColumn<ClaseIndividual, String> colAula;
    @FXML private TableColumn<ClaseIndividual, String> colHorario;

    private final ObservableList<ClaseIndividual> listaClases = FXCollections.observableArrayList();
    private final ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        //Data quemada
        listaEstudiantes.addAll(
                new Estudiante("Juan", "a@a.com", "Estu01", 12,
                        Nivel.PRINCIPIANTE, "Piano", 0, 0),

                new Estudiante("Ana", "ana@a.com", "Estu02", 15,
                        Nivel.INTERMEDIO, "Violín", 0, 0)
        );

        cmbEstudiante.setItems(listaEstudiantes);

        // obtener name en el combobox
        cmbEstudiante.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Estudiante item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : item.getNombre());
            }
        });


        cmbInstrumento.getItems().addAll("PIANO","GUITARRA","VIOLIN","CANTO","BATERIA");
        cmbNivel.getItems().addAll(Nivel.PRINCIPIANTE, Nivel.INTERMEDIO, Nivel.AVANZADO);

        tablaClasesIndividuales.setItems(listaClases);

        colEstudiante.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(
                        c.getValue().getEstudiante() != null ? c.getValue().getEstudiante().getNombre() : "Sin asignar"
                ));

        colInstrumento.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getInstrumento()));

        colNivel.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(String.valueOf(c.getValue().getNivel())));

        colAula.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getSalon().getAula()));

        colHorario.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getHorario().toString()));
    }

    @FXML
    public void crearClase() {
        try {
            String instrumento = cmbInstrumento.getValue();
            Nivel nivel = cmbNivel.getValue();
            String aula = txtAula.getText();
            String horarioTxt = txtHorario.getText();
            Estudiante estudiante = cmbEstudiante.getValue();

            if (instrumento == null || nivel == null || aula.isEmpty() || horarioTxt.isEmpty() || estudiante == null) {
                mostrar("Faltan datos obligatorios.");
                return;
            }

            // data quemada
            Salon salon = new Salon(aula, 1, null);
            Profesor profesor = new Profesor("Pedro","P@0p","Prof01",Instrumento.GUITARRA,"Cuerdas");
            Curso curso = new Curso(12, Instrumento.BATERIA,Nivel.AVANZADO);

            ClaseIndividual clase = new ClaseIndividual(
                    "CI" + (listaClases.size()+1),
                    nivel.ordinal(),
                    java.time.LocalDateTime.now(),
                    1,
                    profesor,
                    curso,
                    salon,
                    instrumento
            );

            clase.setEstudiante(estudiante);

            listaClases.add(clase);

        } catch (Exception ex) {
            ex.printStackTrace();
            mostrar("Error al crear la clase.");
        }
    }

    @FXML
    public void eliminarClase() {
        ClaseIndividual seleccionada = tablaClasesIndividuales.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            listaClases.remove(seleccionada);
        } else {
            mostrar("Seleccione una clase para eliminar.");
        }
    }

    private void mostrar(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(msg);
        a.show();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    @FXML
    private void volver() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/academiademusica/Usuarios/CrudUsuario.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) cmbInstrumento.getScene().getWindow();
            stage.setScene(new Scene(root, 500, 300));
            stage.setTitle("Menú Principal");
        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("No se pudo regresar al menú principal: " + e.getMessage());
        }
    }

}
