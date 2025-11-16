package co.edu.uniquindio.poo.academiademusica.viewController;

import co.edu.uniquindio.poo.academiademusica.model.Salon;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SalonViewController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtCapacidad;
    @FXML private TextField txtIdAdministrador;

    @FXML private TableView<Salon> tblSalones;
    @FXML private TableColumn<Salon, String> tbcNombre;
    @FXML private TableColumn<Salon, Integer> tbcCapacidad;
    @FXML private TableColumn<Salon, String> tbcAdministrador;

    @FXML public void onCrear() { System.out.println("Salón - Crear (Lógica pendiente)"); }
    @FXML public void onActualizar() { System.out.println("Salón - Actualizar (Lógica pendiente)"); }
    @FXML public void onEliminar() { System.out.println("Salón - Eliminar (Lógica pendiente)"); }

    @FXML public void onLimpiar() {
        txtNombre.clear(); txtCapacidad.clear(); txtIdAdministrador.clear();
        System.out.println("Salón - Campos limpiados.");
    }
}