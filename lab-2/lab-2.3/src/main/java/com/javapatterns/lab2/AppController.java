package com.javapatterns.lab2;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.shape.Circle;

public class AppController {


    @FXML
    private Node autoElement;

    @FXML
    private Circle redLight;

    @FXML
    private Circle greenLight;

    @FXML
    private Circle yellowLight;

    private App mainAppFacade;

    @FXML
    protected void onStartButtonClick() {
        if (this.mainAppFacade == null) {
            this.mainAppFacade = new AppFacade(autoElement, redLight, greenLight, yellowLight);
        }
        if (mainAppFacade.isStarted()) {
            mainAppFacade.stopEmulation();
        } else {
            mainAppFacade.startEmulation();
        }
    }
}