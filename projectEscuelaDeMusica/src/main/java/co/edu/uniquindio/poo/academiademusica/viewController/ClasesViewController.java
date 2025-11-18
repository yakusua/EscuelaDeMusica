package co.edu.uniquindio.poo.academiademusica.viewController;

import co.edu.uniquindio.poo.academiademusica.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClasesViewController {

    @FXML
    private void abrirClaseIndividual() {
        abrirVentana(
                "/co/edu/uniquindio/poo/academiademusica/Clases/ClaseIndividualView.fxml",
                "Crear Clase Individual"
        );
    }

    @FXML
    private void abrirClaseGrupal() {
        abrirVentana(
                "/co/edu/uniquindio/poo/academiademusica/ServiciosProfesores/ProfesorClasesGrupales.fxml",
                "Crear Clase Grupal"
        );
    }

    private void abrirVentana(String rutaFXML, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(rutaFXML));

            if (loader.getLocation() == null) {
                System.out.println("No se encontró el archivo FXML: " + rutaFXML);
                return;
            }

            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al abrir " + rutaFXML + ": " + e.getMessage());
        }
    }
}
