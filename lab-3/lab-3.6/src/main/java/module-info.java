module com.example.lab36 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab36 to javafx.fxml;
    exports com.example.lab36;
    exports com.example.lab36.models;
    opens com.example.lab36.models to javafx.fxml;
}