package com.example.lab4_1;

import com.example.lab4_1.model.AppModel;
import com.example.lab4_1.model.Coordinates;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;

public class ControllerMVC {

    @FXML
    private TableView<Coordinates> tableView;
    @FXML
    private TableColumn<Coordinates, Double> xColumn;
    @FXML
    private TableColumn<Coordinates, Double> yColumn;
    @FXML
    private LineChart<Double, Double> lineChart;

    private AppModel appModel;

    protected void addCoordinate() {
        tableView.getItems().add(new Coordinates(0));
    }

    public void init() {
        appModel = new AppModel(this.tableView);
        initChart();
        initTableValues();
    }

    private void initChart() {
        XYChart.Series<Double, Double> series = new XYChart.Series<>();
        series.setName("Cubic fn");
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

        xColumn.setOnEditCommit((TableColumn.CellEditEvent<Coordinates, Double> editEvent) -> {
            TablePosition<Coordinates, Double> position = editEvent.getTablePosition();

            var value = editEvent.getNewValue();
            var rowNumber = position.getRow();
            var row = appModel.getCoordinates().get(rowNumber);

            if (value != null && !Double.isNaN(value)) {
                row.setX(value);
            } else {
                appModel.getCoordinates().remove(row);
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