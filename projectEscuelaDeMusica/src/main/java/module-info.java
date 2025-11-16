module co.edu.uniquindio.poo.academiademusica {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    opens co.edu.uniquindio.poo.academiademusica to javafx.graphics, javafx.fxml;
    opens co.edu.uniquindio.poo.academiademusica.viewController to javafx.fxml;
    exports co.edu.uniquindio.poo.academiademusica.model;

}