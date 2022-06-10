package com.example.lab36;

import com.example.lab36.models.Context;
import com.example.lab36.models.HolidaysState;
import com.example.lab36.models.SemesterState;
import com.example.lab36.models.SessionState;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StateController {
    @FXML
    public ImageView imageView;

    private final Context context = new Context();

    public void semesterClick() throws FileNotFoundException {
        context.setState(new SemesterState());
        updateImage();
    }

    public void sessionClick() throws FileNotFoundException {
        context.setState(new SessionState());
        updateImage();
    }

    public void holidaysClick() throws FileNotFoundException {
        context.setState(new HolidaysState());
        updateImage();
    }

    private void updateImage() throws FileNotFoundException {
        this.imageView.imageProperty().setValue(new Image(new FileInputStream(context.getState().getImage())));
    }
}