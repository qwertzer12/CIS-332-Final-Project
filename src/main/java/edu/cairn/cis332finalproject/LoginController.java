package edu.cairn.cis332finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;



public class LoginController {
    @FXML
    private javafx.scene.control.TextField usernameField;

    private static String username;

    @FXML
    private void initialize() {
        usernameField.setPromptText("Enter your username");
        setUsername(null);
    }

    public static String getUsername() {
        return username;
    }
    public static void setUsername(String username) {
        LoginController.username = username;
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        username = usernameField.getText();
        if (username != null && !username.isEmpty()) {
            Preload.switchScene("main");
        } else {
            usernameField.setPromptText("Username cannot be empty!");
        }
    }
}