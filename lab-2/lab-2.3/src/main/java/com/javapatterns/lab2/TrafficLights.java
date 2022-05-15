package com.javapatterns.lab2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TrafficLights {
    private final Circle redLight;
    private final Circle greenLight;
    private final Circle yellowLight;

    public TrafficLights(Circle redLight, Circle greenLight, Circle yellowLight){
        this.redLight = redLight;
        this.greenLight = greenLight;
        this.yellowLight = yellowLight;
    }

    public void setRed(){
        this.redLight.setFill(Color.RED);
        this.greenLight.setFill(Color.BLACK);
        this.yellowLight.setFill(Color.BLACK);
    }

    public void setGreen(){
        this.greenLight.setFill(Color.GREEN);
        this.yellowLight.setFill(Color.BLACK);
        this.redLight.setFill(Color.BLACK);
    }

    public void setYellow(){
        this.greenLight.setFill(Color.BLACK);
        this.yellowLight.setFill(Color.YELLOW);
        this.redLight.setFill(Color.BLACK);
    }

}
