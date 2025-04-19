package edu.cairn.cis332finalproject;

public class NavbarController {

    public void loadScene1() {
        Preload.switchScene("scene1");
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