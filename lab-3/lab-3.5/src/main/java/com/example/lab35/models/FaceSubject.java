package com.example.lab35.models;

import java.util.ArrayList;

public class FaceSubject implements Subject {

    private final ArrayList<Observer> observers;

    public FaceSubject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver(FaceAction action) {
        for (Observer observer : observers){
            observer.update(action);
        }
    }

//    public ArrayList<Observer> getObservers(){
//        return this.observers;
//    }
}
