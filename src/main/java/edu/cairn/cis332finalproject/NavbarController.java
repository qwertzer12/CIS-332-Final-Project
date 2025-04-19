package edu.cairn.cis332finalproject;

import javafx.event.ActionEvent;


public class NavbarController {


    public void loadScene1(ActionEvent event) {
        Preload.switchScene("scene1");
    }

    public void loadScene2(ActionEvent event) {
        Preload.switchScene("scene2");
    }

    public void loadScene3(ActionEvent event) {
        Preload.switchScene("scene3");
    }
}