package com.example.lab38.models;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.util.Random;

public class CircleFigure extends Figure{

    public CircleFigure(Pane pane){
        super(new Circle(10), pane);
    }

    @Override
    protected void setFigure() {
        var random = new Random();
        shape.setFill(color);
        this.shape.setLayoutX(random.nextInt(7) + this.width - 20);
        this.shape.setLayoutY(random.nextInt(5) + this.height - 20);
    }
}
