package edu.cairn.cis332finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Test application launcher that loads the tip calculator view.
 * Used for testing individual components of the application.
 * 
 * @author AJ Chabin
 */
public class TestLoader extends Application {
    /**
     * Creates a new TestLoader instance.
     * Default constructor used by JavaFX.
     * 
     * @author AJ Chabin
     */
    public TestLoader() {
    }

    /**
     * Main entry point for the test application.
     *
     * @param args command line arguments
     * @author AJ Chabin
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes the JavaFX stage with the tip calculator scene.
     *
     * @param primaryStage the primary stage for this application
     * @throws Exception if an error occurs during loading
     * @author AJ Chabin
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        String file = "tipCalculator";
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/edu/cairn/cis332finalproject/" + file + ".fxml")));
        primaryStage.setTitle("Tip Calculator");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
