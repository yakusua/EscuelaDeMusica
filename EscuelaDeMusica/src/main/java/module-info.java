module org.example.escuelademusica {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.escuelademusica to javafx.fxml;
    exports org.example.escuelademusica;
}