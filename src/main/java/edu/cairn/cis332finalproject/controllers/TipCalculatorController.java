package edu.cairn.cis332finalproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static java.lang.Float.parseFloat;

/**
 * Controller for the tip calculator functionality.
 * Allows users to calculate tips based on bill amount and percentage.
 */
public class TipCalculatorController {
    /**
     * Text field for bill amount input.
     */
    @FXML
    private TextField input;

    /**
     * Label for displaying calculated tip amount.
     */
    @FXML
    private Label display;

    /**
     * The current tip percentage as a decimal value.
     */
    private float tipPercent;

    /**
     * Initializes the tip calculator view.
     * Resets display and input fields to their default states.
     */
    @FXML
    public void load() {
        display.setText("$0.00");
        input.setPromptText("Enter a number");
        tipPercent = 0.0f;
    }

    /**
     * Calculates the tip based on input amount and selected percentage.
     * Validates input and displays appropriate messages for invalid inputs.
     */
    @FXML
    private void calculateTip() {
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

    /**
     * Sets tip percentage to 10% and calculates the tip.
     */
    @FXML
    private void tenTip() {
        tipPercent = 0.1f;
        calculateTip();
    }

    /**
     * Sets tip percentage to 15% and calculates the tip.
     */
    @FXML
    private void fifteenTip() {
        tipPercent = 0.15f;
        calculateTip();
    }

    /**
     * Sets tip percentage to 20% and calculates the tip.
     */
    @FXML
    private void twentyTip() {
        tipPercent = 0.20f;
        calculateTip();
    }
}