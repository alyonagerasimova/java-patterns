package com.example.lab4_1.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.List;

public class AppModel {
    private final TableView<Coordinates> tableView;

    public AppModel(TableView<Coordinates> tableView){
        this.tableView = tableView;
    }

    private final ObservableList<Coordinates> coordinates = FXCollections.observableArrayList(
            new Coordinates(-1),
            new Coordinates(0),
            new Coordinates(1)
    );

    public void setInitialCoordinates() {
        tableView.setItems(coordinates);
    }

    public ObservableList<Coordinates> getCoordinates() {
        return tableView.getItems();
    }

    public List<XYChart.Data<Double, Double>> getChartData() {
        var list = new ArrayList<XYChart.Data<Double, Double>>();
        for (Coordinates coordinate : tableView.getItems()) {
            list.add(new XYChart.Data<>(coordinate.getX(), coordinate.getY()));
        }
        return list;
    }
}
