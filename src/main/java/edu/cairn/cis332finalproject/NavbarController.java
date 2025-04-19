package edu.cairn.cis332finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NavbarController {
    private static final Map<String, Parent> scenes = new HashMap<>();
    private static Stage primaryStage;

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public static void preloadScenes() {
        try {
            scenes.put("scene1", FXMLLoader.load(NavbarController.class.getResource("/edu/cairn/cis332finalproject/scene1.fxml")));
            scenes.put("scene2", FXMLLoader.load(NavbarController.class.getResource("/edu/cairn/cis332finalproject/scene2.fxml")));
            scenes.put("scene3", FXMLLoader.load(NavbarController.class.getResource("/edu/cairn/cis332finalproject/scene3.fxml")));
            scenes.put("main", FXMLLoader.load(NavbarController.class.getResource("/edu/cairn/cis332finalproject/main.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void switchScene(String sceneName) {
        Parent sceneRoot = scenes.get(sceneName);
        if (sceneRoot != null && primaryStage != null) {
            primaryStage.getScene().setRoot(sceneRoot);
        }
    }

    public void loadScene1(ActionEvent event) {
        switchScene("scene1");
    }

    public void loadScene2(ActionEvent event) {
        switchScene("scene2");
    }

    public void loadScene3(ActionEvent event) {
        switchScene("scene3");
    }
}