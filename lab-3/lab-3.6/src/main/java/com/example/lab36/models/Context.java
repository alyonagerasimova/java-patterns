package com.example.lab36.models;

public class Context {
    private State state;

    public Context() {
        state = new SemesterState();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
