package com.example.lab35.models;

import javafx.scene.shape.QuadCurve;

public class MouthObserver implements Observer {

    private final QuadCurve mouthElement;

    public MouthObserver(QuadCurve mouthElement) {
        this.mouthElement = mouthElement;
    }

    @Override
    public void update(FaceAction action) {
        if (action == FaceAction.MOUTH) {
            double rotation = 180;
            if (this.mouthElement.getRotate() != rotation) {
                this.mouthElement.setRotate(rotation);
            } else {
                this.mouthElement.setRotate(0);
            }

        }
    }
}
