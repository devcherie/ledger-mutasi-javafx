module com.example.javafx {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com to javafx.fxml;
    opens com.controller to javafx.fxml;

    exports com;
}