module com.example.lab41 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab41 to javafx.fxml;
    exports com.example.lab41;

    opens com.example.lab41.models to javafx.fxml;
    exports com.example.lab41.models;
}