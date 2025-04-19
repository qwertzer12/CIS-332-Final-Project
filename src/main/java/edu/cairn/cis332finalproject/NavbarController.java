package edu.cairn.cis332finalproject;

public class NavbarController {

    public void loadTipCalculator() {
        tipCalculatorLoader tipCalculatorLoader = Preload.getController("tipCalculator");
        if (tipCalculatorLoader != null) {
            tipCalculatorLoader.load();
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