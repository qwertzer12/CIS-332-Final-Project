package edu.cairn.cis332finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static edu.cairn.cis332finalproject.NavbarController.switchScene;

public class LoginController {
    @FXML
    private javafx.scene.control.TextField usernameField;

    private static String username;

    public static String getUsername() {
        return username;
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        username = usernameField.getText();
        if (username != null && !username.isEmpty()) {
            switchScene("main");
        } else {
            usernameField.setPromptText("Username cannot be empty!");
        }
    }
}