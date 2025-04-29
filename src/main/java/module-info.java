/**
 * Main module for the CIS-332 Final Project application.
 * Provides JavaFX-based UI components and data persistence functionality.
 */
module edu.cairn.cis332finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires jdk.compiler;


    opens edu.cairn.cis332finalproject to javafx.fxml, com.fasterxml.jackson.databind;
    exports edu.cairn.cis332finalproject;
    exports edu.cairn.cis332finalproject.controllers;
    opens edu.cairn.cis332finalproject.controllers to javafx.fxml;
}