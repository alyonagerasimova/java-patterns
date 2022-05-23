package com.example.lab35.models;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

public class NoseObserver implements Observer {

    private final Polyline noseElement;

    public NoseObserver(Polyline noseElement) {
        this.noseElement = noseElement;
    }

    @Override
    public void update(FaceAction action) {
        if (action == FaceAction.NOSE){
            noseElement.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        }
    }
}
