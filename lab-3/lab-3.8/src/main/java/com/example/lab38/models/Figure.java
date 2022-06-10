package com.example.lab38.models;

import javafx.animation.AnimationTimer;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.Random;

public abstract class Figure {

    protected double height;
    protected double width;
    protected Shape shape;
    protected Pane pane;
    protected Color color;
    protected AnimationTimer timer;

    public Figure(Shape shape, Pane pane){
        this.shape = shape;
        this.pane = pane;

        height = pane.getHeight();
        width = pane.getWidth();

        Random r = new Random();
        color = Color.color(r.nextDouble(), r.nextDouble(), r.nextDouble());

        this.setFigure();
    }

    protected abstract void setFigure();

    public Shape getFigure(){
        return this.shape;
    }

    public void start(){
        timer = new AnimationTimer() {
            double dx = 3;
            double dy = 4;

            @Override
            public void handle(long now) {
                shape.setLayoutX(shape.getLayoutX() + dx);
                shape.setLayoutY(shape.getLayoutY() + dy);

                var bounds = shape.getBoundsInParent();

                if (bounds.getMinX() <= 0 || bounds.getMaxX() >= width) {
                    dx = -dx;
                }

                if (bounds.getMinY() <= 0 || bounds.getMaxY() >= height) {
                    dy = -dy;
                }
            }
        };
        timer.start();
    }

}
