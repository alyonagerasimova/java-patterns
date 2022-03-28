module com.javapatterns.lab2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javapatterns.lab2 to javafx.fxml;
    exports com.javapatterns.lab2;
}