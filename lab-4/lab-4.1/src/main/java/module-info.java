module com.example.lab4_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab4_1 to javafx.fxml;
    exports com.example.lab4_1;
}