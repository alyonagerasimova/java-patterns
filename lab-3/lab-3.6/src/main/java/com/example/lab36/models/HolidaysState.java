package com.example.lab36.models;

public class HolidaysState implements State{
    private static final String IMG_SRC = "C:\\Users\\alena\\IdeaProjects\\java-patterns\\lab-3\\lab-3.6\\src\\main\\resources\\com\\example\\lab36\\img\\happy.png";

    @Override
    public String getImage() {
        return IMG_SRC;
    }
}
