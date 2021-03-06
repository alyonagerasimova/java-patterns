package com.example.lab41.models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Coordinate {
    private DoubleProperty xProperty;
    private DoubleProperty yProperty;

    public Coordinate(double x) {
        setX(x);
    }

    public DoubleProperty xProperty() {
        if (xProperty == null) {
            xProperty = new SimpleDoubleProperty(this, "x");
        }
        return xProperty;
    }

    public DoubleProperty yProperty() {
        if (yProperty == null) {
            yProperty = new SimpleDoubleProperty(this, "y");
        }
        return yProperty;
    }

    public double getX() {
        return xProperty().doubleValue();
    }

    public void setX(double x) {
        xProperty().set(x);
        calculateY();
    }

    public double getY() {
        return yProperty().doubleValue();
    }

    public void setY(double y) {
        yProperty().set(y);
    }

    private void calculateY() {
        setY(Function.getInstance().calculateY(getX()));
    }
}
