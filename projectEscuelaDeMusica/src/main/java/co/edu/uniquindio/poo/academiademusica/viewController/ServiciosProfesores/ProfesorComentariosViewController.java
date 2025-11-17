package co.edu.uniquindio.poo.academiademusica.viewController.ServiciosProfesores;
import co.edu.uniquindio.poo.academiademusica.model.ComentarioEstudiante;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;

public class ProfesorComentariosViewController {

    @FXML private TableView<ComentarioEstudiante> tablaEstudiantes;
    @FXML private TableColumn<ComentarioEstudiante, String> colEstudiante;
    @FXML private TableColumn<ComentarioEstudiante, String> colUltComentario;
    @FXML private TextArea txtComentario;

    private ObservableList<ComentarioEstudiante> lista = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colEstudiante.setCellValueFactory(c -> c.getValue().estudianteProperty());
        colUltComentario.setCellValueFactory(c -> c.getValue().comentarioProperty());

        lista.addAll(
                new ComentarioEstudiante("Camilo", "Practicar escalas."),
                new ComentarioEstudiante("Laura", "Mejorar postura.")
        );

        tablaEstudiantes.setItems(lista);
    }

    @FXML
    private void guardarComentario() {
        ComentarioEstudiante c = tablaEstudiantes.getSelectionModel().getSelectedItem();
        if (c == null) return;
        if (txtComentario.getText().isBlank()) return;

        c.setComentario(txtComentario.getText());
        txtComentario.clear();
    }

    @FXML
    private void volver() {}
}
