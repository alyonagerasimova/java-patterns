package com.javapatterns.lab2;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Car {
    private final Node autoElement;
    private boolean canGo = false;
    private boolean isWait = false;

    private final TranslateTransition beforeTrafficLightTransition = new TranslateTransition();
    private final TranslateTransition afterTrafficLightTransition = new TranslateTransition();

    public Car(Node autoElement) {
        this.autoElement = autoElement;
        setupTransitions();
    }

    private void setupTransitions() {
        beforeTrafficLightTransition.setDuration(Duration.millis(1000));
        afterTrafficLightTransition.setDuration(Duration.millis(2000));

        beforeTrafficLightTransition.setByX(238);
        afterTrafficLightTransition.setByX(898);

        beforeTrafficLightTransition.setCycleCount(1);
        afterTrafficLightTransition.setCycleCount(1);

        beforeTrafficLightTransition.setAutoReverse(false);
        afterTrafficLightTransition.setAutoReverse(false);

        beforeTrafficLightTransition.setOnFinished(actionEvent -> {
            if (this.canGo) {
                this.afterTrafficLightTransition.play();
                isWait = false;
            } else {
                isWait = true;
            }
        });

        afterTrafficLightTransition.setOnFinished(actionEvent -> {
            this.autoElement.setTranslateX(0);
            this.beforeTrafficLightTransition.play();
        });

        beforeTrafficLightTransition.setNode(autoElement);
        afterTrafficLightTransition.setNode(autoElement);
    }

    public void start() {
        this.beforeTrafficLightTransition.play();
    }

    public void resume() {
        if (isWait) {
            this.isWait = false;
            this.afterTrafficLightTransition.play();
        }
    }

    public void stop() {
        beforeTrafficLightTransition.stop();
        afterTrafficLightTransition.stop();
        beforeTrafficLightTransition.jumpTo(Duration.millis(0));
        afterTrafficLightTransition.jumpTo(Duration.millis(0));

        this.autoElement.setTranslateX(0);
    }

    public void setCanGo() {
        canGo = true;
    }

    public void setCanNotGo() {
        canGo = false;
    }

    public boolean IsWait() {
        return this.isWait;
    }
}
