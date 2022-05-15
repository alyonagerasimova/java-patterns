package com.example.lab4_1;

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
        Scene scene = new Scene(root, 500, 450);
        stage.setTitle("MVC App");
        stage.setScene(scene);
        stage.show();
        controller.init();
    }

    public static void main(String[] args) {
        launch();
    }
}