package edu.cairn.cis332finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        if (username != null && !username.isEmpty()) {
            MainController mainController = Preload.getController("main");
            if (mainController != null) {
                mainController.setUsername(username);
            }
            Preload.switchScene("main");
        } else {
            usernameField.setPromptText("Username cannot be empty!");
        }
    }
}