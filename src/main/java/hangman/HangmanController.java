package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.HangmanGame;
import model.HangmanScoreboard;

public class HangmanController {

    // FXML-injected UI components from the corresponding .fxml file
    @FXML private Label wordLabel;        // Displays the current state of the guessed word
    @FXML private Label messageLabel;     // Displays game messages (e.g., correct/incorrect guess)
    @FXML private Label attemptsLabel;    // Displays the number of attempts remaining
    @FXML private TextField guessInput;   // User input for guessing a letter
    @FXML private Label scoreLabel;       // Displays the current score (wins/losses)

    // Scoreboard to keep track of wins and losses
    private final HangmanScoreboard scoreboard = new HangmanScoreboard();

    // Game logic instance
    private HangmanGame game;

    // Called automatically when the controller is initialized
    @FXML
    public void initialize() {
        // Initializes a new game with the word "banana"
        game = new HangmanGame("banana");
        // Updates the UI with the initial game state
        updateUI();
    }

    // Handles the user's guess when they press Enter or submit input
    @FXML
    public void handleGuess() {
        // Get and normalize user input
        String guess = guessInput.getText().toLowerCase();
        // Ensure the input is a single letter
        if (guess.length() == 1 && Character.isLetter(guess.charAt(0))) {
            // Submit the guess to the game logic
            game.guessLetter(guess.charAt(0));
        }
        // Clear the input field for the next guess
        guessInput.clear();
        // Update UI to reflect the new game state
        updateUI();
    }

    // Updates the labels and handles game-over logic
    private void updateUI() {
        // Show the current guessed word with hidden and revealed letters
        wordLabel.setText(game.getMaskedWord());
        // Show the current game message
        messageLabel.setText(game.getMessage());
        // Show remaining attempts
        attemptsLabel.setText("Attempts left: " + game.getAttemptsLeft());

        // If the game is over, handle end-of-game UI and scoring
        if (game.isGameOver()) {
            // Disable input field to prevent further guessing
            guessInput.setDisable(true);
            // Get the current displayed word (without spaces)
            String currentWord = game.getMaskedWord().replace(" ", "");
            // If the word is guessed correctly, record a win; otherwise, a loss
            if (currentWord.equals(game.getWord())) {
                scoreboard.addWin();
            } else {
                scoreboard.addLoss();
            }
            // Display updated scoreboard
            scoreLabel.setText(scoreboard.toString());
        }
    }
}

