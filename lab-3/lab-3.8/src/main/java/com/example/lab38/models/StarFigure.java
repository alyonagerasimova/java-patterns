package com.example.lab38.models;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.util.Random;

public class StarFigure extends Figure {

    public StarFigure(Pane pane) {
        super(new Polygon(9, 0, 15, 18, 0, 6, 18, 6, 3, 18), pane);
    }

    @Override
    protected void setFigure() {
        var random = new Random();
        shape.setFill(color);
        this.shape.setLayoutX(random.nextInt(10) + this.width - 36);
        this.shape.setLayoutY(random.nextInt(5) + this.height - 36);
    }
}
