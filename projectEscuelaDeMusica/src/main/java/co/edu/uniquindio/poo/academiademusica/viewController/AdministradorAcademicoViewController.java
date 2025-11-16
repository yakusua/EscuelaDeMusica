package co.edu.uniquindio.poo.academiademusica.viewController;

import co.edu.uniquindio.poo.academiademusica.model.AdministradorAcademico;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class AdministradorAcademicoViewController {

    private AdministradorAcademicoViewController administradorController;

    @FXML
    private TextField txtIdAdministrador;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnCrear;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TableView<AdministradorAcademico> tblAdministradores;
    @FXML
    private TableColumn<AdministradorAcademico, String> tbcIdAdministrador;
    @FXML
    private TableColumn<AdministradorAcademico, String> tbcNombre;
    @FXML
    private TableColumn<AdministradorAcademico, String> tbcEmail;
    @FXML
    public void onCrear() {
    }
    @FXML
    public void onActualizar() {
    }
    @FXML
    public void onEliminar() {
    }
    @FXML
    public void onLimpiar() {
        txtIdAdministrador.clear();
        txtNombre.clear();
        txtEmail.clear();
    }
    public void initialize() {
    }
    
}