package co.edu.uniquindio.poo.academiademusica;

import co.edu.uniquindio.poo.academiademusica.model.Academia ;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static Academia academia;
    private static Stage primaryStage;
/*
    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        openVentanaPrincipal(); // Seleccionar
    }


   public static void openVentanaPrincipal() {
     openWindow("/co/edu/uniquindio/poo/segurcoljfx/ventanaPrincipal.fxml",
              "Bienvenido a Segurcol");
 }
*/
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
/*
    public static void openCrudServicios() {
        openWindow("/co/edu/uniquindio/poo/segurcoljfx/crudServicio.fxml",
                "Gestión de Servicios");
    }

    public static void openCrudCustodiaFija() {
        openWindow("/co/edu/uniquindio/poo/segurcoljfx/servicios/crudCustodiaFija.fxml",
                "Gestión de Custodia Fija");
    }

    public static void openCrudPatrullajeMovil() {
        openWindow("/co/edu/uniquindio/poo/segurcoljfx/servicios/crudPatrullajeMovil.fxml",
                "Gestión de Patrullaje Móvil");
    }

    public static void openCrudEquipos() {
        openWindow("/co/edu/uniquindio/poo/segurcoljfx/crudEquipos.fxml",
                "Gestión de Equipos");
    }

    public static void openCrudAgenda() {
        openWindow("/co/edu/uniquindio/poo/segurcoljfx/crudAgenda.fxml",
                "Gestión de Agenda y Novedades");
    }
*/
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
        academia = new Academia("Music AXM","A001","Uniquindio");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
    }
}