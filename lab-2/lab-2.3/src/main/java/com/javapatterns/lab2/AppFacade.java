package com.javapatterns.lab2;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class AppFacade implements App{

    private final TrafficLights trafficLights = new TrafficLights();
    private final Car car;

    public AppFacade(Node autoElement, Circle redLight, Circle greenLight, Circle yellowLight) {
        car = new Car(autoElement);

        trafficLights.setHandler(action -> {
            switch (action) {
                case TO_RED -> {
                    redLight.setFill(Color.RED);
                    greenLight.setFill(Color.BLACK);
                    yellowLight.setFill(Color.BLACK);

                    this.car.setCanNotGo();
                }
                case TO_GREEN -> {
                    greenLight.setFill(Color.GREEN);
                    yellowLight.setFill(Color.BLACK);
                    redLight.setFill(Color.BLACK);

                    this.car.setCanGo();
                    if (isStarted() && this.car.IsWait()) {
                        car.resume();
                    }
                }
                case TO_YELLOW -> {
                    greenLight.setFill(Color.BLACK);
                    yellowLight.setFill(Color.YELLOW);
                    redLight.setFill(Color.BLACK);

                    this.car.setCanNotGo();
                }
            }
        });
    }

    @Override
    public void startEmulation() {
        trafficLights.start();
        car.start();
    }

    @Override
    public void stopEmulation() {
        if (isStarted()) {
            this.trafficLights.stop();
            this.car.stop();
        }
    }

    @Override
    public boolean isStarted() {
        return trafficLights.isStarted();
    }
}
