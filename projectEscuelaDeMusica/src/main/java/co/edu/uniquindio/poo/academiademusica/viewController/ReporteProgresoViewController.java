package co.edu.uniquindio.poo.academiademusica.viewController;

import co.edu.uniquindio.poo.academiademusica.model.ReporteProgreso;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class ReporteProgresoViewController {

    @FXML private TextField txtIdEstudiante;
    @FXML private TextField txtIdCurso;
    @FXML private TextField txtNota;
    @FXML private TextArea txtObservaciones;


    @FXML private TableView<ReporteProgreso> tblReportes;
    @FXML private TableColumn<ReporteProgreso, String> tbcIdEstudiante;
    @FXML private TableColumn<ReporteProgreso, String> tbcIdCurso;
    @FXML private TableColumn<ReporteProgreso, Double> tbcNota;
    @FXML private TableColumn<ReporteProgreso, String> tbcObservaciones;


    @FXML public void onCrear() { System.out.println("Reporte - Crear (Lógica pendiente)"); }
    @FXML public void onActualizar() { System.out.println("Reporte - Actualizar (Lógica pendiente)"); }
    @FXML public void onEliminar() { System.out.println("Reporte - Eliminar (Lógica pendiente)"); }

    @FXML public void onLimpiar() {
        txtIdEstudiante.clear(); txtIdCurso.clear(); txtNota.clear(); txtObservaciones.clear();
        System.out.println("Reporte - Campos limpiados.");
    }
}