module edu.cairn.cis332finalproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.cairn.cis332finalproject to javafx.fxml;
    exports edu.cairn.cis332finalproject;
}