package com.example.lab41;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMVC extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMVC.class.getResource("mvc-view.fxml"));
        Parent root = fxmlLoader.load();
        ControllerMVC controller = fxmlLoader.getController();
        Scene scene = new Scene(root, 788, 474);
        stage.setTitle("MVC App");
        stage.setScene(scene);
//        stage.setOnShown(e -> {
//            controller.initApp();
//        });
        stage.show();
        controller.initApp();
    }

    public static void main(String[] args) {
        launch();
    }
}