package com.example.lab35;

import com.example.lab35.models.*;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.QuadCurve;

import java.util.ArrayList;

public class ObserverController {
    @FXML
    public QuadCurve mouth;

    @FXML
    public Polyline nose;

    @FXML
    public Group firstEye;

    @FXML
    public Group secondEye;

    private final ArrayList<Observer> subscriptions = new ArrayList<>(4);
    private final Subject subject = new FaceSubject();

    public void initSubscriptions() {
        subscriptions.add(subject.subscribe(new NoseObserver(nose)));
        subscriptions.add(subject.subscribe(new MouthObserver(mouth)));
        subscriptions.add(subject.subscribe(new EyeObserver(firstEye, FaceAction.FIRST_EYE)));
        subscriptions.add(subject.subscribe(new EyeObserver(secondEye, FaceAction.SECOND_EYE)));
    }

    public void mouthClick() {
        subject.notifyObserver(FaceAction.MOUTH);
    }

    public void noseClick() {
        subject.notifyObserver(FaceAction.NOSE);
    }

    public void firstEyeClick() {
        subject.notifyObserver(FaceAction.FIRST_EYE);
    }

    public void secondClick() {
        subject.notifyObserver(FaceAction.SECOND_EYE);
    }

    protected void unsubscribeClick() {
        for (Observer subscription : subscriptions) {
            subject.unsubscribe(subscription);
        }
        subscriptions.clear();
    }
}