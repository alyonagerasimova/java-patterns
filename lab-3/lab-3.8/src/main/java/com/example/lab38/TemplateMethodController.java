package com.example.lab38;

import com.example.lab38.models.CircleFigure;
import com.example.lab38.models.Figure;
import com.example.lab38.models.SquareFigure;
import com.example.lab38.models.StarFigure;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import java.util.ArrayList;

public class TemplateMethodController {

    @FXML
    public ComboBox comboBox;

    @FXML
    private Pane pane;

    private final ArrayList<Figure> figures = new ArrayList<>();

    public void init(){
        String listOfFigures[] = { "Мяч", "Звезда", "Квадрат" };
        comboBox.getItems().addAll(listOfFigures);
    }

    @FXML
    protected void onStartButtonClick() {
        Figure figure;
        String value = String.valueOf(comboBox.getValue());
        switch (value) {
            case "Мяч" ->  figure = new CircleFigure(pane);
            case "Звезда" -> figure = new StarFigure(pane);
            case "Квадрат" -> figure = new SquareFigure(pane);
            default -> figure = new CircleFigure(pane);
        }

        pane.getChildren().add(figure.getFigure());
        figures.add(figure);
        figure.start();
    }

    @FXML
    protected void onExitButtonClick() {
        System.exit(0);
    }

}