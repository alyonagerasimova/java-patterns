package com.example.lab41;

import com.example.lab41.models.AppModel;
import com.example.lab41.models.Coordinate;
import javafx.fxml.FXML;

import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.util.converter.DoubleStringConverter;

public class ControllerMVC {

    @FXML
    private TableView<Coordinate> tableView;
    @FXML
    private TableColumn<Coordinate, Double> xColumn;
    @FXML
    private TableColumn<Coordinate, Double> yColumn;
    @FXML
    private LineChart<Double, Double> lineChart;

    @FXML
    protected void addCoordinate() {
        tableView.getItems().add(new Coordinate(0));
    }

    private AppModel appModel;

    public void initApp() {
        appModel = new AppModel(this.tableView);
        initChart();
        initTableValues();
    }

    private void initChart() {
        XYChart.Series<Double, Double> series = new XYChart.Series<>();
        series.setName("func");
        lineChart.getData().add(series);
    }

    private void initTableValues() {
        xColumn.setEditable(true);

        this.appModel.setInitialCoordinates();

        xColumn.setCellValueFactory(new PropertyValueFactory<>(appModel.getCoordinates().get(0).xProperty().getName()));
        yColumn.setCellValueFactory(new PropertyValueFactory<>(appModel.getCoordinates().get(0).yProperty().getName()));

        var convertor = new DoubleStringConverter() {
            @Override
            public Double fromString(String value) {
                try {
                    return super.fromString(value);
                } catch (Exception ignored) {
                }
                return null;
            }
        };

        xColumn.setCellFactory(TextFieldTableCell.forTableColumn(convertor));
        yColumn.setCellFactory(TextFieldTableCell.forTableColumn(convertor));

        xColumn.setOnEditCommit((TableColumn.CellEditEvent<Coordinate, Double> editEvent) -> {
            TablePosition<Coordinate, Double> position = editEvent.getTablePosition();

            var value = editEvent.getNewValue();
            var rowNumber = position.getRow();
            var coordinate = appModel.getCoordinates().get(rowNumber);

            if (value != null && !Double.isNaN(value)) {
                coordinate.setX(value);
            } else {
                appModel.getCoordinates().remove(coordinate);
            }

            this.updateChart();
        });
        yColumn.setOnEditCommit(editEvent -> {
        });
        this.updateChart();
    }

    private void updateChart() {
        XYChart.Series<Double, Double> series = lineChart.getData().get(0);
        series.getData().clear();
        series.getData().addAll(appModel.getChartData());
    }
}