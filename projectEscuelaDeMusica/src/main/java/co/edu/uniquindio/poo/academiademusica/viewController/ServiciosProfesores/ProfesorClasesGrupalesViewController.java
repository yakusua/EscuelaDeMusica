package co.edu.uniquindio.poo.academiademusica.viewController.ServiciosProfesores;

import co.edu.uniquindio.poo.academiademusica.model.*;

import co.edu.uniquindio.poo.academiademusica.model.enums.Instrumento;
import co.edu.uniquindio.poo.academiademusica.model.enums.Nivel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;

import java.time.LocalDateTime;

public class ProfesorClasesGrupalesViewController {

    @FXML private TextField txtInstrumento, txtAula, txtCupos, txtHorario;
    @FXML private ComboBox<String> cmbNivel;
    @FXML private TableView<ClaseGrupal> tablaClases;
    @FXML private TableColumn<ClaseGrupal, String> colInst, colNivel, colAula, colHorario;
    @FXML private TableColumn<ClaseGrupal, Integer> colCupos;

    private ObservableList<ClaseGrupal> listaClases = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        cmbNivel.setItems(FXCollections.observableArrayList("1", "2", "3", "4"));

        colInst.setCellValueFactory(c -> c.getValue().instrumentoProperty());
        colNivel.setCellValueFactory(c -> c.getValue().nivelProperty());
        colAula.setCellValueFactory(c -> c.getValue().aulaProperty());
        colHorario.setCellValueFactory(c -> c.getValue().horarioProperty());
        colCupos.setCellValueFactory(c -> c.getValue().cuposProperty().asObject());

        tablaClases.setItems(listaClases);
    }

    @FXML
    private void crearClase() {

        if (txtInstrumento.getText().isBlank() ||
                cmbNivel.getValue() == null ||
                txtAula.getText().isBlank() ||
                txtCupos.getText().isBlank() ||
                txtHorario.getText().isBlank()) {

            mostrar("Todos los campos son obligatorios.");
            return;
        }

        int cupos;
        try {
            cupos = Integer.parseInt(txtCupos.getText());
        } catch (Exception e) {
            mostrar("Cupos debe ser un número.");
            return;
        }

        // ------------ CREACIÓN DE OBJETOS REALES ------------

        Profesor profesor = new Profesor(
                "Profesor Temporal",         // nombre
                "temporal@correo.com",       // email
                "P1",                         // idProfesor
                Instrumento.valueOf(txtInstrumento.getText().toUpperCase()), // instrumento
                "General"                     // especialidad
        );

        Curso curso = new Curso(
                20,                          // capacidad
                Instrumento.valueOf(txtInstrumento.getText().toUpperCase()),
                Nivel.valueOf(cmbNivel.getValue().toUpperCase())
        );

        AdministradorAcademico admin = new AdministradorAcademico("Juan","juan@","J001");

        Salon salon = new Salon(
                txtAula.getText(),  // nombre del salón
                20,                 // capacidad
                admin               // administrador8
        );


        LocalDateTime horario;
        try {
            horario = LocalDateTime.parse(txtHorario.getText());
        } catch (Exception e) {
            mostrar("Formato de horario incorrecto. Usa: 2025-11-17T15:30");
            return;
        }

        ClaseGrupal nueva = new ClaseGrupal(
                "CG-" + (listaClases.size() + 1),      // id
                Integer.parseInt(cmbNivel.getValue()), // nivel
                horario,
                cupos,
                profesor,
                curso,
                salon,
                txtInstrumento.getText()
        );

        listaClases.add(nueva);
        limpiarCampos();
}

    private void limpiarCampos() {
        txtInstrumento.clear();
        txtAula.clear();
        txtCupos.clear();
        txtHorario.clear();
        cmbNivel.setValue(null);
    }

    @FXML
    private void volver() {}

    private void mostrar(String msg) {
        new Alert(Alert.AlertType.WARNING, msg).show();
    }
}
