module co.edu.uniquindio.poo.academiademusica {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

   // si se crean carpetas en controladores se deben añadir
    opens co.edu.uniquindio.poo.academiademusica to javafx.fxml;
    opens co.edu.uniquindio.poo.academiademusica.viewController to javafx.fxml;
    opens co.edu.uniquindio.poo.academiademusica.viewController.ServiciosProfesores to javafx.fxml;

    exports co.edu.uniquindio.poo.academiademusica;
    exports co.edu.uniquindio.poo.academiademusica.model;
    exports co.edu.uniquindio.poo.academiademusica.viewController;
    exports co.edu.uniquindio.poo.academiademusica.viewController.ServiciosProfesores;
}
