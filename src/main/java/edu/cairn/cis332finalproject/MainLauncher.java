package edu.cairn.cis332finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main application launcher class.
 * Initializes the application with the login scene and preloads other scenes.
 *
 * @author AJ Chabin
 */
public class MainLauncher extends Application {
    /**
     * Creates a new MainLauncher instance.
     * Default constructor used by JavaFX.
     *
     * @author AJ Chabin
     */
    public MainLauncher() {
    }

    /**
     * Main entry point for the application.
     *
     * @param args command line arguments
     * @author AJ Chabin
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes the primary stage with the login scene.
     * Sets up full screen mode and preloads all scenes.
     *
     * @param primaryStage the primary stage for this application
     * @author AJ Chabin
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/cairn/cis332finalproject/login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 400, 300);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Login");
            primaryStage.setFullScreen(true);
            primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
            primaryStage.setFullScreenExitHint("");

            // Set primary stage and preload scenes
            Preload.setPrimaryStage(primaryStage);
            Preload.preloadScenes();

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
