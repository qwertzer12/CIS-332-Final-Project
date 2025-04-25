package edu.cairn.cis332finalproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller for the Hello view.
 * Simple demo controller that updates welcome text on button click.
 */
public class HelloController {
    /**
     * Label for displaying welcome message.
     */
    @FXML
    private Label welcomeText;

    /**
     * Handles the hello button click event.
     * Updates the welcome text label with a greeting message.
     */
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}