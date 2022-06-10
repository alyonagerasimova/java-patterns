package com.example.lab38;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class TemplateMethodApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TemplateMethodApp.class.getResource("templateMethod-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 395);
        TemplateMethodController controller = fxmlLoader.getController();
        stage.setTitle("Template Method");
        stage.setScene(scene);
        controller.init();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}