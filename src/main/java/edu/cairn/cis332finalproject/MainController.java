package edu.cairn.cis332finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label data_field;

    @FXML
    protected void getInfoClick() {
        data_field.setText("Data Field: dsfkvomsfkvimsf");
    }
}
