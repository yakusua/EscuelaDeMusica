package co.edu.uniquindio.poo.academiademusica.viewController;
import co.edu.uniquindio.poo.academiademusica.model.AdministradorAcademico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AdminViewController {

    // Campos del form
    @FXML private TextField txtNombre;
    @FXML private TextField txtEmail;
    @FXML private ComboBox<String> cmbRol;
    @FXML private TextField txtIdAdministrador;

//tabla
    @FXML private TableView<AdministradorAcademico> tblAdmins;
    @FXML private TableColumn<AdministradorAcademico, String> colNombre;
    @FXML private TableColumn<AdministradorAcademico, String> colEmail;
    @FXML private TableColumn<AdministradorAcademico, String> colRol;
    @FXML private TableColumn<AdministradorAcademico, String> colIdAdministrador;

    private final ObservableList<AdministradorAcademico> listaAdmins =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        configurarTabla();
        cargarRoles();
        manejarSeleccionTabla();
    }

    private void configurarTabla() {
        colNombre.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombre()));
        colEmail.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getEmail()));
        colRol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getRol()));
        colIdAdministrador.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getIdAdministrador()));

        tblAdmins.setItems(listaAdmins);
    }

    private void cargarRoles() {
        cmbRol.getItems().addAll(
                "Administrador Académico",
                "Coordinador",
                "Director Académico"
        );
    }

    private void manejarSeleccionTabla() {
        tblAdmins.getSelectionModel().selectedItemProperty().addListener(
                (obs, viejo, nuevo) -> {
                    if (nuevo != null) {
                        txtNombre.setText(nuevo.getNombre());
                        txtEmail.setText(nuevo.getEmail());
                        cmbRol.setValue(nuevo.getRol());
                        txtIdAdministrador.setText(nuevo.getIdAdministrador());
                    }
                }
        );
    }

//config botones
    @FXML
    private void onAgregar() {
        AdministradorAcademico admin = construirAdminDesdeFormulario();

        if (admin == null) return;

        listaAdmins.add(admin);
        limpiarCampos();
    }

    @FXML
    private void onActualizar() {
        AdministradorAcademico seleccionado = tblAdmins.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            mostrarAlerta("Seleccione un administrador para actualizar.");
            return;
        }

        AdministradorAcademico actualizado = construirAdminDesdeFormulario();
        if (actualizado == null) return;

        int index = listaAdmins.indexOf(seleccionado);
        listaAdmins.set(index, actualizado);

        limpiarCampos();
    }

    @FXML
    private void onEliminar() {
        AdministradorAcademico seleccionado = tblAdmins.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            mostrarAlerta("Seleccione un administrador para eliminar.");
            return;
        }

        listaAdmins.remove(seleccionado);
        limpiarCampos();
    }

    @FXML
    private void onLimpiar() {
        limpiarCampos();
    }



    private AdministradorAcademico construirAdminDesdeFormulario() {
        String nombre = txtNombre.getText().trim();
        String email = txtEmail.getText().trim();
        String rol = cmbRol.getValue();

        if (nombre.isEmpty() || email.isEmpty() || rol == null) {
            mostrarAlerta("Todos los campos son obligatorios.");
            return null;
        }

        return new AdministradorAcademico(nombre, email, rol);
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtEmail.clear();
        cmbRol.setValue(null);
        txtIdAdministrador.clear();
        tblAdmins.getSelectionModel().clearSelection();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
