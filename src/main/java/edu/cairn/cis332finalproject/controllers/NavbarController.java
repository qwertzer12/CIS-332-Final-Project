package edu.cairn.cis332finalproject.controllers;

import edu.cairn.cis332finalproject.Preload;

/**
 * Controller for the application navigation bar.
 * Handles scene transitions between different application views.
 */
public class NavbarController {

    /**
     * Switches to the tip calculator view.
     * Loads the tip calculator controller and initializes it.
     */
    public void loadTipCalculator() {
        TipCalculatorController tipCalculatorController = Preload.getController("tipCalculator");
        if (tipCalculatorController != null) {
            tipCalculatorController.load();
        }

        Preload.switchScene("tipCalculator", "Tip Calculator");
    }

    /**
     * Switches to scene 2.
     */
    public void loadScene2() {
        Preload.switchScene("scene2", "Scene 2");
    }

    /**
     * Switches to scene 3.
     */
    public void loadScene3() {
        Preload.switchScene("scene3", "Scene 3");
    }

    /**
     * Handles user logout.
     * Returns to the login screen.
     */
    public void handleLogout() {
        Preload.switchScene("login", "Login");
    }
}