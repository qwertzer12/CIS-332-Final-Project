package edu.cairn.cis332finalproject.controllers;

import edu.cairn.cis332finalproject.DataStorage;
import edu.cairn.cis332finalproject.Preload;
import edu.cairn.cis332finalproject.UserData;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        UserData userData = DataStorage.loadUser(username);
        if (userData != null) {
            userData.updateLoginTime();
            DataStorage.saveUser(userData);
        }
        else {
            userData = new UserData(username, DataStorage.getUserCount());
            DataStorage.saveUser(userData);
        }

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