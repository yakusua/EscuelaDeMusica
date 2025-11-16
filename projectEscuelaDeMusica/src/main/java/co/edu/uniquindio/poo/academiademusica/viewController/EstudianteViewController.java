package co.edu.uniquindio.poo.academiademusica.viewController;

import co.edu.uniquindio.poo.academiademusica.model.Estudiante;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class EstudianteViewController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtEmail;
    @FXML private TextField txtRol;
    @FXML private TextField txtIdEstudiante;
    @FXML private TextField txtEdad;
    @FXML private TextField txtNivel;
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

    @FXML public void onCrear() { System.out.println("Estudiante - Crear (Lógica pendiente)"); }
    @FXML public void onActualizar() { System.out.println("Estudiante - Actualizar (Lógica pendiente)"); }
    @FXML public void onEliminar() { System.out.println("Estudiante - Eliminar (Lógica pendiente)"); }

    @FXML public void onLimpiar() {
        txtNombre.clear(); txtEmail.clear(); txtRol.clear();
        txtIdEstudiante.clear(); txtEdad.clear(); txtNivel.clear();
        txtCurso.clear(); txtAsistencia.clear(); txtProgreso.clear();
        System.out.println("Estudiante - Campos limpiados.");
    }

}