package edu.cairn.cis332finalproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label data_field;

    private String username;

    @FXML
    public void initialize() {
        updateWelcomeMessage();
    }

    public void setUsername(String username) {
        this.username = username;
        updateWelcomeMessage();
    }

    private void updateWelcomeMessage() {
        if (data_field != null) {
            if (username != null && !username.isEmpty()) {
                data_field.setText("Welcome, " + username + "!");
            } else {
                data_field.setText("Welcome!");
            }
        }
    }
}