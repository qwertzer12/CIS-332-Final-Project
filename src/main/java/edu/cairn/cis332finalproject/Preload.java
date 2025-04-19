package edu.cairn.cis332finalproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Preload {
    private static final Map<String, FXMLLoader> loaders = new HashMap<>();
    private static Stage primaryStage;

    public static void setPrimaryStage(Stage primaryStage) {
        Preload.primaryStage = primaryStage;
    }

    public static void preloadScenes() {
        try {
            loaders.put("scene1", new FXMLLoader(Preload.class.getResource("/edu/cairn/cis332finalproject/scene1.fxml")));
            loaders.put("scene2", new FXMLLoader(Preload.class.getResource("/edu/cairn/cis332finalproject/scene2.fxml")));
            loaders.put("scene3", new FXMLLoader(Preload.class.getResource("/edu/cairn/cis332finalproject/scene3.fxml")));
            loaders.put("main", new FXMLLoader(Preload.class.getResource("/edu/cairn/cis332finalproject/main.fxml")));
            loaders.put("login", new FXMLLoader(Preload.class.getResource("/edu/cairn/cis332finalproject/login.fxml")));

            for (Map.Entry<String, FXMLLoader> entry : loaders.entrySet()) {
                entry.getValue().load();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void switchScene(String sceneName) {
        Parent sceneRoot = loaders.get(sceneName).getRoot();
        if (sceneRoot != null && primaryStage != null) {
            primaryStage.getScene().setRoot(sceneRoot);
        }
    }

    public static <T> T getController(String sceneName) {
        FXMLLoader loader = loaders.get(sceneName);
        return loader != null ? loader.getController() : null;
    }
}