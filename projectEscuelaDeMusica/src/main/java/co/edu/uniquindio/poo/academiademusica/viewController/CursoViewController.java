package co.edu.uniquindio.poo.academiademusica.viewController;

import co.edu.uniquindio.poo.academiademusica.model.Curso;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class CursoViewController {

    @FXML private TextField txtIdCurso;
    @FXML private TextField txtCapacidad;
    @FXML private TextField txtInstrumento;
    @FXML private TextField txtNivel;

    @FXML private TableView<Curso> tblCursos;
    @FXML private TableColumn<Curso, String> tbcIdCurso;
    @FXML private TableColumn<Curso, Integer> tbcCapacidad;
    @FXML private TableColumn<Curso, String> tbcInstrumento;
    @FXML private TableColumn<Curso, String> tbcNivel;

    @FXML public void onCrear() { System.out.println("Curso - Crear (Lógica pendiente)"); }
    @FXML public void onActualizar() { System.out.println("Curso - Actualizar (Lógica pendiente)"); }
    @FXML public void onEliminar() { System.out.println("Curso - Eliminar (Lógica pendiente)"); }

    @FXML public void onLimpiar() {
        txtIdCurso.clear(); txtCapacidad.clear();
        txtInstrumento.clear(); txtNivel.clear();
        System.out.println("Curso - Campos limpiados.");
    }
}

