package com.javapatterns.lab2;

@FunctionalInterface
public interface TrafficLightsActionHandler {
    void doAction(TrafficLightsActions action);
}
