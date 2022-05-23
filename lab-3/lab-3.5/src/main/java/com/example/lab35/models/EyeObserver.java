package com.example.lab35.models;

import javafx.scene.Group;

public class EyeObserver implements Observer {

    private final Group eye;
    private final FaceAction currentAction;

    public EyeObserver(Group eye, FaceAction currentAction) {
        this.eye = eye;
        this.currentAction = currentAction;
    }

    @Override
    public void update(FaceAction action) {
        double scale = 0.2;
        if (action == currentAction)
            if (eye.getScaleY() == scale) {
                eye.setScaleY(1);
            } else
                eye.setScaleY(scale);
    }
}
