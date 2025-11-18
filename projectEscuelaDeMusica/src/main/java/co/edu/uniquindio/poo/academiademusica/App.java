package co.edu.uniquindio.poo.academiademusica;

import co.edu.uniquindio.poo.academiademusica.model.Academia;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static Academia academia;
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        openVentanaPrincipal(); // Seleccionar
    }

    public static void openVentanaPrincipal() {
        openWindow("/co/edu/uniquindio/poo/academiademusica/VentanaPrincipal.fxml",
                "Menú Principal");
    }

    public static void openCrudUsuario() {
        openWindow("co/edu/uniquindio/poo/academiademusica/Usuarios/CrudUsuario.fxml",
                "Gestión de Empleados");
    }

    public static void openAdminView() {
        openWindow("co/edu/uniquindio/poo/segurcoljfx/empleados/crudVigilante.fxml",
                "Gestión de Vigilantes");
    }

    public static void openEstudianteView() {
        openWindow("/co/edu/uniquindio/poo/segurcoljfx/empleados/crudSupervisor.fxml",
                "Gestión de Supervisores");
    }

    public static void openProfesorView() {
        openWindow("/co/edu/uniquindio/poo/segurcoljfx/empleados/crudOperadorMonitoreo.fxml",
                "Gestión de Operadores de Monitoreo");
    }

    //abre cualquier  fxml
    private static void openWindow(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(fxmlPath));

            if (loader.getLocation() == null) {
                System.out.println("No se encontró el archivo: " + fxmlPath);
                return;
            }

            Parent root = loader.load();
            Scene scene = new Scene(root);

            primaryStage.setTitle(title);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al abrir " + fxmlPath + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        academia = new Academia("Musical UQ","uq001","RandomPlace");
        launch(args);
    }
}