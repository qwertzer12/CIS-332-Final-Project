package edu.cairn.cis332finalproject.controllers;

import edu.cairn.cis332finalproject.DataStorage;
import edu.cairn.cis332finalproject.Preload;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller class for Scene2, where the Hangman game is played.
 * Manages the UI interactions and game logic.
 */
public class HangmanController {
    /**
     * method to load a new game.
     * This resets the game state and prepares the UI for a new round.
     */
    public void load() {
        // Reset game state
        currentGuess = new StringBuilder();
        currentGuess.append("_ ".repeat(wordToGuess.length()));
        remainingAttempts = 6;

        // Reset UI elements
        wordLabel.setText(currentGuess.toString().trim());
        guessInput.setText("");
        guessInput.setDisable(false);  // Re-enable input if it was disabled after game end
        guessInput.requestFocus();
        messageLabel.setText("New game started! You have " + remainingAttempts + " attempts left.");
        System.out.println("Consecutive Wins: " + consecutiveWins + ", Total Wins: " + totalWins);
    }
    /** The word that the player needs to guess. */
    private final String wordToGuess = "banana"; // You can replace this later with a random word!

    /** StringBuilder to track the player's current progress (guessed letters and underscores). */
    private StringBuilder currentGuess;

    /** Number of remaining attempts the player has before losing. */
    private int remainingAttempts = 6;

    /** Number of consecutive wins*/
    private int consecutiveWins = 0;

    /** Number of total wins */
    private int totalWins = 0;

    /** Label that displays the masked version of the word (with underscores and revealed letters). */
    @FXML
    private Label wordLabel;

    /** TextField where the player inputs their letter guess. */
    @FXML
    private TextField guessInput;

    /** Label that displays messages to the player (e.g., good guess, wrong guess, win/lose messages). */
    @FXML
    private Label messageLabel;

    /**
     * Initializes the game when the scene is loaded.
     * Sets up the masked word with underscores and prepares the display.
     */
    @FXML
    public void initialize() {
        currentGuess = new StringBuilder();
        currentGuess.append("_ ".repeat(wordToGuess.length()));
        wordLabel.setText(currentGuess.toString().trim());
    }

    /**
     * Handles the logic when the player makes a guess.
     * Validates input, updates the display, checks for win/lose conditions.
     */
    @FXML
    public void handleGuess() {
        String input = guessInput.getText().toLowerCase().trim();

        // Validate that the input is exactly one letter
        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            messageLabel.setText("Please enter a single letter.");
            return;
        }

        char guessedChar = input.charAt(0);
        boolean found = false;

        // Check if the guessed letter is in the word
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guessedChar) {
                currentGuess.setCharAt(i * 2, guessedChar); // Multiply by 2 because of spaces between underscores
                found = true;
            }
        }

        // Update message based on guess result
        if (found) {
            messageLabel.setText("Good guess!");
        } else {
            remainingAttempts--;
            messageLabel.setText("Wrong guess! Attempts left: " + remainingAttempts);
        }

        // Update the displayed word
        wordLabel.setText(currentGuess.toString().trim());
        guessInput.clear();

        // Check for win or lose conditions
        if (!currentGuess.toString().contains("_")) {
            messageLabel.setText("Congratulations! You won!");
            guessInput.setDisable(true);
            totalWins++;
            consecutiveWins++;
            // Save the game data (e.g., to a file or database)
            MainController mainController = Preload.getController("main");
            assert mainController != null;
            DataStorage.saveHangmanData(mainController.getUsername(), new int[]{consecutiveWins, totalWins});
        } else if (remainingAttempts <= 0) {
            messageLabel.setText("Game over! The word was: " + wordToGuess);
            guessInput.setDisable(true);
            consecutiveWins = 0; // Reset consecutive wins on loss
            MainController mainController = Preload.getController("main");
            assert mainController != null;
            DataStorage.saveHangmanData(mainController.getUsername(), new int[]{consecutiveWins, totalWins});
        }
    }
}
