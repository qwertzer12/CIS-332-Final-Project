package edu.cairn.cis332finalproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller for the main application view.
 * Manages the welcome message display based on user login.
 */
public class MainController {
    /**
     * Creates a new MainController instance.
     * Default constructor used by FXML loader.
     */
    public MainController() {
    }

    /**
     * Label for displaying the welcome message.
     */
    @FXML
    private Label data_field;

    /**
     * The username of the currently logged-in user.
     */
    private String username;

    /**
     * Initializes the controller.
     * Called after FXML fields are injected.
     */
    @FXML
    public void initialize() {
        updateWelcomeMessage();
    }

    /**
     * Sets the username and updates the welcome message.
     *
     * @param username the username to display
     */
    public void setUsername(String username) {
        this.username = username;
        updateWelcomeMessage();
    }

    /**
     * Updates the welcome message based on username availability.
     * Displays a personalized message if username is present.
     */
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