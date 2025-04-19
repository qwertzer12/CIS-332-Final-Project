package edu.cairn.cis332finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static java.lang.Float.parseFloat;

public class tipCalculatorLoader {
    @FXML
    private TextField input;
    @FXML
    private Label display;

    private float tipPercent;


    @FXML
    public void load() {
        display.setText("$0.00");
        input.setPromptText("Enter a number");
        tipPercent = 0.0f;

    }

    @FXML
    private void calculateTip(){
        String amount = input.getText();
        if (amount != null && !amount.isEmpty() && tipPercent != 0.0f) {
            try {
                float amountFloat = parseFloat(amount);
                float tip = amountFloat * tipPercent;
                display.setText("Tip: $" + String.format("%.2f", tip));
            } catch (NumberFormatException e) {
                display.setText("Please enter a valid amount.");
                input.setText("");
            }
        } else if (tipPercent == 0.0f) {
            display.setText("Please select a tip percentage.");
        } else {
            display.setText("Please enter an amount.");
        }

    }

    @FXML
    private void tenTip(){
        tipPercent = 0.1f;
        calculateTip();
    }

    @FXML
    private void fifteenTip(){
        tipPercent = 0.15f;
        calculateTip();
    }

    @FXML
    private void twentyTip(){
        tipPercent = 0.20f;
        calculateTip();
    }
}
