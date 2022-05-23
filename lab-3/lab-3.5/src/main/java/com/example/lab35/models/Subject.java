package com.example.lab35.models;

public interface Subject {
    Observer subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObserver(FaceAction action);
}
