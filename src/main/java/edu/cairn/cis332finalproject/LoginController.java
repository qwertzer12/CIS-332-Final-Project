package edu.cairn.cis332finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/cairn/cis332finalproject/main.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root, 800, 600));
                stage.setFullScreen(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            usernameField.setPromptText("Username cannot be empty!");
        }
    }
}