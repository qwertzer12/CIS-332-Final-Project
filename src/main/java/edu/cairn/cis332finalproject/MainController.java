package edu.cairn.cis332finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label data_field;

    @FXML
    private void initialize() {
        String username = LoginController.getUsername();
        if (username != null && !username.isEmpty()) {
            data_field.setText("Welcome, " + username + "!");
        } else {
            data_field.setText("Welcome!");
        }
    }
}