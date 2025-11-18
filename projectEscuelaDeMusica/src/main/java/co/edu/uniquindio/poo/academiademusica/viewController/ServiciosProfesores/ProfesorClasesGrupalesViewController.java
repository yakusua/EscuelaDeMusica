package co.edu.uniquindio.poo.academiademusica.viewController.ServiciosProfesores;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class ProfesorClasesGrupalesViewController {

    @FXML private ComboBox<String> cmbInstrumento;
    @FXML private ComboBox<String> cmbNivel;
    @FXML private TextField txtAula;
    @FXML private TextField txtCupos;
    @FXML private TextField txtHorario;

    @FXML private TableView<Clase> tablaClases;
    @FXML private TableColumn<Clase, String> colInst;
    @FXML private TableColumn<Clase, String> colNivel;
    @FXML private TableColumn<Clase, String> colAula;
    @FXML private TableColumn<Clase, String> colCupos;
    @FXML private TableColumn<Clase, String> colHorario;

    private final ObservableList<Clase> listaClases = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        cmbInstrumento.setItems(FXCollections.observableArrayList(
                "PIANO", "GUITARRA", "VIOLIN", "CANTO", "BATERIA"
        ));
        cmbNivel.setItems(FXCollections.observableArrayList(
                "PRINCIPIANTE", "INTERMEDIO", "AVANZADO"
        ));

        configurarTabla();
    }

    private void configurarTabla() {
        colInst.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getInstrumento()));
        colNivel.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getNivel()));
        colAula.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getAula()));
        colCupos.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getCupos()));
        colHorario.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getHorario()));

        tablaClases.setItems(listaClases);
    }

    @FXML
    private void crearClase() {
        String instrumento = cmbInstrumento.getValue();
        String nivel = cmbNivel.getValue();
        String aula = txtAula.getText().trim();
        String cupos = txtCupos.getText().trim();
        String horario = txtHorario.getText().trim();

        if(instrumento == null || nivel == null || aula.isEmpty() || cupos.isEmpty() || horario.isEmpty()) {
            mostrarAlerta("Todos los campos son obligatorios.");
            return;
        }

        Clase nuevaClase = new Clase(instrumento, nivel, aula, cupos, horario);
        listaClases.add(nuevaClase);

        limpiarCampos();
    }

    @FXML
    private void eliminarClase() {
        Clase seleccionado = tablaClases.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Seleccione una clase para eliminar.");
            return;
        }
        listaClases.remove(seleccionado);
    }

    private void limpiarCampos() {
        cmbInstrumento.setValue(null);
        cmbNivel.setValue(null);
        txtAula.clear();
        txtCupos.clear();
        txtHorario.clear();
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

//se cambia para manejar la tabla
    public static class Clase {
        private final String instrumento;
        private final String nivel;
        private final String aula;
        private final String cupos;
        private final String horario;

        public Clase(String instrumento, String nivel, String aula, String cupos, String horario) {
            this.instrumento = instrumento;
            this.nivel = nivel;
            this.aula = aula;
            this.cupos = cupos;
            this.horario = horario;
        }

        public String getInstrumento() { return instrumento; }
        public String getNivel() { return nivel; }
        public String getAula() { return aula; }
        public String getCupos() { return cupos; }
        public String getHorario() { return horario; }
    }
}
