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

    public static void openCrudUsuario() {
        openWindow("co/edu/uniquindio/poo/academiademusica/CrudUsuario.fxml",
                "Gestión de Empleados");
    }

    public static void openAdminView() {
        openWindow("co/edu/uniquindio/poo/academiademusica/AdminView.fxml",
                "Gestión de Administradores");
    }

    public static void openProfesorView() {
        openWindow("co/edu/uniquindio/poo/academiademusica/ProfesorView.fxml",
                "Gestión de Profesores");
    }

    public static void openEstudienteView() {
        openWindow("co/edu/uniquindio/poo/academiademusica/EstudianteView.fxml",
                "Gestión de Estudiantes");
    }

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

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        openCrudUsuario();
    }

    public static void main(String[] args) {
        academia = new Academia("Music AXM", "A001", "Uniquindio");
        launch(args);
    }
}
