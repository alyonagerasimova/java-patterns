package com.example.lab35;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ObserverApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ObserverApp.class.getResource("observer-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 389, 500);
        ObserverController controller = fxmlLoader.getController();
        stage.setTitle("ObserverApp");
        stage.setScene(scene);
        stage.setOnShown(e -> controller.initSubscriptions());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}