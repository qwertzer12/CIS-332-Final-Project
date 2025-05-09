package edu.cairn.cis332finalproject.controllers;

import edu.cairn.cis332finalproject.Preload;

/**
 * Controller for the application navigation bar.
 * Handles scene transitions between different application views.
 * 
 * @author AJ Chabin
 */
public class NavbarController {
    /**
     * Creates a new NavbarController instance.
     * Default constructor used by FXML loader.
     * 
     * @author AJ Chabin
     */
    public NavbarController() {
    }

    /**
     * Switches to the tip calculator view.
     * Loads the tip calculator controller and initializes it.
     * 
     * @author AJ Chabin
     */
    public void loadTipCalculator() {
        TipCalculatorController tipCalculatorController = Preload.getController("tipCalculator");
        if (tipCalculatorController != null) {
            tipCalculatorController.load();
        }

        Preload.switchScene("tipCalculator", "Tip Calculator");
    }

    /**
     * Switches to the Hangman game view.
     * Loads the hangman controller and initializes it.
     *
     * @author AJ Chabin
     */
    public void loadHangman() {
        HangmanController hangmanController = Preload.getController("hangman");
        if (hangmanController != null) {
            hangmanController.load();
        }
        Preload.switchScene("hangman", "Hangman");
    }

    /**
     * Switches to scene 3.
     * 
     * @author AJ Chabin
     */
    public void loadScene3() {
        Preload.switchScene("scene3", "Scene 3");
    }

    /**
     * Handles user logout.
     * Returns to the login screen.
     * 
     * @author AJ Chabin
     */
    public void handleLogout() {
        Preload.switchScene("login", "Login");
    }
}
