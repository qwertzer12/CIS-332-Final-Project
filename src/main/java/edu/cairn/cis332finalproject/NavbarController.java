package edu.cairn.cis332finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NavbarController {

    private void loadScene(String fxmlPath, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
            stage.setFullScreen(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadScene1(ActionEvent event) {
        loadScene("/edu/cairn/cis332finalproject/scene1.fxml", event);
    }

    public void loadScene2(ActionEvent event) {
        loadScene("/edu/cairn/cis332finalproject/scene2.fxml", event);
    }

    public void loadScene3(ActionEvent event) {
        loadScene("/edu/cairn/cis332finalproject/scene3.fxml", event);
    }
}