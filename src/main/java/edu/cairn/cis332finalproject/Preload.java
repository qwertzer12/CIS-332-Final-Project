package edu.cairn.cis332finalproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages scene preloading and navigation for the application.
 * Preloads all FXML scenes to improve performance when switching between views.
 * @author AJ Chabin
 */
public class Preload {
    /**
     * Private constructor to prevent instantiation of this utility class.
     * @author AJ Chabin
     */
    private Preload() {
        // Utility class should not be instantiated
    }

    private static final Map<String, FXMLLoader> loaders = new HashMap<>();
    private static Stage primaryStage;

    /**
     * Sets the primary stage for scene switching.
     *
     * @param primaryStage the main application window
     * @author AJ Chabin
     */
    public static void setPrimaryStage(Stage primaryStage) {
        Preload.primaryStage = primaryStage;
    }

    /**
     * Preloads all application scenes to improve performance.
     * Loads each FXML file and stores the loader for later use.
     * This allows for faster scene switching and controller access.
     * @author AJ Chabin
     */
    public static void preloadScenes() {
        try {
            loaders.put("tipCalculator", new FXMLLoader(Preload.class.getResource("/edu/cairn/cis332finalproject/tipCalculator.fxml")));
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

    /**
     * Switches the displayed scene in the primary stage.
     *
     * @param sceneName the name of the scene to display
     * @param title the window title to set
     * @author AJ Chabin
     */
    public static void switchScene(String sceneName, String title) {
        Parent sceneRoot = loaders.get(sceneName).getRoot();
        if (sceneRoot != null && primaryStage != null) {
            primaryStage.getScene().setRoot(sceneRoot);
            primaryStage.setTitle(title);
        }
    }

    /**
     * Gets the controller for a specific scene.
     *
     * @param <T> the type of controller to return
     * @param sceneName the name of the scene
     * @return the controller instance or null if not found
     * @author AJ Chabin
     */
    public static <T> T getController(String sceneName) {
        FXMLLoader loader = loaders.get(sceneName);
        return loader != null ? loader.getController() : null;
    }
}
