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

    private final FaceSubject subject = new FaceSubject();

    public void initSubscriptions() {
        subject.subscribe(new NoseObserver(nose));
        subject.subscribe(new MouthObserver(mouth));
        subject.subscribe(new EyeObserver(firstEye, FaceAction.FIRST_EYE));
        subject.subscribe(new EyeObserver(secondEye, FaceAction.SECOND_EYE));
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

//    private final ArrayList<Observer> subscriptions = subject.getObservers();
//
//    protected void unsubscribeClick() {
//        for (Observer subscription : subscriptions) {
//            subject.unsubscribe(subscription);
//        }
//        subscriptions.clear();
//    }
}