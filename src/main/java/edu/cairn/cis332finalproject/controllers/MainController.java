package edu.cairn.cis332finalproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller for the main application view.
 * Manages the welcome message display based on user login.
 * 
 * @author AJ Chabin
 */
public class MainController {
    /**
     * Creates a new MainController instance.
     * Default constructor used by FXML loader.
     * 
     * @author AJ Chabin
     */
    public MainController() {
    }

    /**
     * Label for displaying the welcome message.
     *
     */
    @FXML
    private Label data_field;

    /**
     * The username of the currently logged-in user.
     *
     */
    private String username;

    /**
     * Initializes the controller.
     * Called after FXML fields are injected.
     * 
     * @author AJ Chabin
     */
    @FXML
    public void initialize() {
        updateWelcomeMessage();
    }

    /**
     * Sets the username and updates the welcome message.
     *
     * @param username the username to display
     * 
     * @author AJ Chabin
     */
    public void setUsername(String username) {
        this.username = username;
        updateWelcomeMessage();
    }

    /**
     * Gets the username of the currently logged-in user.
     *
     * @return the username
     *
     * @author AJ Chabin
     */
    public String getUsername() {
        return username;
    }

    /**
     * Updates the welcome message based on username availability.
     * Displays a personalized message if username is present.
     * 
     * @author AJ Chabin
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
