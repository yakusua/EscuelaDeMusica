package co.edu.uniquindio.poo.academiademusica.viewController;

import co.edu.uniquindio.poo.academiademusica.model.Profesor;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ProfesorViewController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtEmail;
    @FXML private TextField txtRol;
    @FXML private TextField txtIdProfesor;
    @FXML private TextField txtEspecialidad;
    @FXML private TextField txtInstrumento;

    @FXML private TableView<Profesor> tblProfesores;
    @FXML private TableColumn<Profesor, String> tbcIdProfesor;
    @FXML private TableColumn<Profesor, String> tbcNombre;
    @FXML private TableColumn<Profesor, String> tbcEspecialidad;
    @FXML private TableColumn<Profesor, String> tbcInstrumento;

    // Métodos CRUD
    @FXML public void onCrear() { System.out.println("Profesor - Crear (Lógica pendiente)"); }
    @FXML public void onActualizar() { System.out.println("Profesor - Actualizar (Lógica pendiente)"); }
    @FXML public void onEliminar() { System.out.println("Profesor - Eliminar (Lógica pendiente)"); }

    @FXML public void onLimpiar() {
        txtNombre.clear(); txtEmail.clear(); txtRol.clear();
        txtIdProfesor.clear(); txtEspecialidad.clear(); txtInstrumento.clear();
        System.out.println("Profesor - Campos limpiados.");
    }
}