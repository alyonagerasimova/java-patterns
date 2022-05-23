package com.example.lab41.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.List;

public class AppModel {
    private final TableView<Coordinate> tableView;

    public AppModel(TableView<Coordinate> tableView){
        this.tableView = tableView;
    }

    private final ObservableList<Coordinate> coordinates = FXCollections.observableArrayList(
            new Coordinate(-1),
            new Coordinate(0),
            new Coordinate(1),
            new Coordinate(2),
            new Coordinate(3)
    );

    public void setInitialCoordinates() {
        tableView.setItems(coordinates);
    }

    public ObservableList<Coordinate> getCoordinates() {
        return tableView.getItems();
    }

    public List<XYChart.Data<Double, Double>> getChartData() {
        var list = new ArrayList<XYChart.Data<Double, Double>>();
        for (Coordinate coordinate : tableView.getItems()) {
            list.add(new XYChart.Data<>(coordinate.getX(), coordinate.getY()));
        }
        return list;
    }
}

