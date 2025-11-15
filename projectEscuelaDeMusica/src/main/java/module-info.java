module co.edu.uniquindio.poo.academiademusica {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.academiademusica to javafx.fxml;
    exports co.edu.uniquindio.poo.academiademusica;
}