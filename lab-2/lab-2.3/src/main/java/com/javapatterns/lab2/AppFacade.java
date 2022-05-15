package com.javapatterns.lab2;

import javafx.scene.Node;
import javafx.scene.shape.Circle;

public class AppFacade implements App {

    private final TrafficLights trafficLights;
    private final Car car;
    public long timeout = 1000;
    private boolean isStarted = false;

    public AppFacade(Node autoElement, Circle redLight, Circle greenLight, Circle yellowLight) {
        car = new Car(autoElement);
        trafficLights = new TrafficLights(redLight, greenLight, yellowLight);
    }

    @Override
    public void startEmulation() {
        start();
    }

    @Override
    public void stopEmulation() {
        if (isStarted) {
            this.stop();
            this.car.stop();
        }
    }

    @Override
    public boolean isStarted() {
        return isStarted;
    }


    private void setTrafficLightsRed() {
        trafficLights.setRed();
        this.car.setCanNotGo();
    }

    private void setTrafficLightsGreen() {
        trafficLights.setGreen();
        this.car.setCanGo();
        if (isStarted && this.car.IsWait()) {
            car.resume();
        }
    }

    private void setTrafficLightsYellow() {
        trafficLights.setYellow();
        this.car.setCanNotGo();
    }

    public void stop() {
        isStarted = false;
    }

    public void start() {
        car.start();
        new Thread(() -> {
            this.isStarted = true;
            var thread = Thread.currentThread();
            try {
                synchronized (this) {
                    while (isStarted && !thread.isInterrupted()) {
                        setTrafficLightsGreen();
                        wait(this.timeout);
                        setTrafficLightsYellow();
                        wait(this.timeout);
                        setTrafficLightsRed();
                        wait(this.timeout);
                        setTrafficLightsYellow();
                        wait(this.timeout);
                    }
                }
            } catch (InterruptedException e) {
                this.isStarted = false;
                e.printStackTrace();
            }
        }).start();
    }

}
