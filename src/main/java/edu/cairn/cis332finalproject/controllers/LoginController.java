package edu.cairn.cis332finalproject.controllers;

import edu.cairn.cis332finalproject.DataStorage;
import edu.cairn.cis332finalproject.Preload;
import edu.cairn.cis332finalproject.UserData;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


/**
 * LoginController handles the login process for the application.
 * It retrieves the username from the TextField,
 * loads the user data from storage,
 * updates the login time,
 * and switches to the main scene.
 * If the username is empty,
 * it sets a prompt text to inform the user.
 */
public class LoginController {
    /**
     * Creates a new LoginController instance.
     * Default constructor used by FXML loader.
     */
    public LoginController() {
    }


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
            Preload.switchScene("main", "Swiss Army App");
        } else {
            usernameField.setPromptText("Username cannot be empty!");
        }
    }
}