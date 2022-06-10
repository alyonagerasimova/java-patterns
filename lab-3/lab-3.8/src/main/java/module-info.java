module com.example.lab38 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab38 to javafx.fxml;
    exports com.example.lab38;
    exports com.example.lab38.models;
    opens com.example.lab38.models to javafx.fxml;
}