module com.example.escuelamusica {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.escuelamusica to javafx.fxml;
    exports com.example.escuelamusica;
    exports com.example.escuelamusica.viewController;
    opens com.example.escuelamusica.viewController to javafx.fxml;
}