module com.example.lab35 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab35 to javafx.fxml;
    exports com.example.lab35;
}