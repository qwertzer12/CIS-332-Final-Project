module edu.cairn.cis332finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens edu.cairn.cis332finalproject to javafx.fxml;
    exports edu.cairn.cis332finalproject;
    exports edu.cairn.cis332finalproject.controllers;
    opens edu.cairn.cis332finalproject.controllers to javafx.fxml;
}