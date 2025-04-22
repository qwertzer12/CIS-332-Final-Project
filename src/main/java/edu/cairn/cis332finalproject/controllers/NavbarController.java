package edu.cairn.cis332finalproject.controllers;

import edu.cairn.cis332finalproject.Preload;

public class NavbarController {

    public void loadTipCalculator() {
        TipCalculatorController tipCalculatorController = Preload.getController("tipCalculator");
        if (tipCalculatorController != null) {
            tipCalculatorController.load();
        }

        Preload.switchScene("tipCalculator", "Tip Calculator");
    }

    public void loadScene2() {
        Preload.switchScene("scene2", "Scene 2");
    }

    public void loadScene3() {
        Preload.switchScene("scene3", "Scene 3");
    }

    public void handleLogout() {
        Preload.switchScene("login", "Login");
    }
}