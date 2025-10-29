module co.edu.uniquindio.poo.mediator {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.mediator to javafx.fxml;
    exports co.edu.uniquindio.poo.mediator;
    exports co.edu.uniquindio.poo.mediator.viewController;
    opens co.edu.uniquindio.poo.mediator.viewController to javafx.fxml;
}