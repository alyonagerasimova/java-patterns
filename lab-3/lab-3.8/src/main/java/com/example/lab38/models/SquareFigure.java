package com.example.lab38.models;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.Random;

public class SquareFigure extends Figure{
    public SquareFigure(Pane mainPane) {
        super(new Rectangle(20, 20), mainPane);
    }

    @Override
    protected void setFigure() {
        var random = new Random();
        shape.setFill(color);
        this.shape.setLayoutX(random.nextInt(15) + this.width - 40);
        this.shape.setLayoutY(random.nextInt(10) + this.height - 40);
    }
}
