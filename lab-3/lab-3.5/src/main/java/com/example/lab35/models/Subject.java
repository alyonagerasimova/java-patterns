package com.example.lab35.models;

public interface Subject {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObserver(FaceAction action);
}
