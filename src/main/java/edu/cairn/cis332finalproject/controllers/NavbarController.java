package edu.cairn.cis332finalproject.controllers;

import edu.cairn.cis332finalproject.Preload;

public class NavbarController {

    public void loadTipCalculator() {
        tipCalculatorController tipCalculatorController = Preload.getController("tipCalculator");
        if (tipCalculatorController != null) {
            tipCalculatorController.load();
        }

        Preload.switchScene("tipCalculator");
    }

    public void loadScene2() {
        Preload.switchScene("scene2");
    }

    public void loadScene3() {
        Preload.switchScene("scene3");
    }

    public void handleLogout() {
        Preload.switchScene("login");
    }
}