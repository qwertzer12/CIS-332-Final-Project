package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.HangmanGame;
import model.HangmanScoreboard;

public class HangmanController {
    @FXML private Label wordLabel;
    @FXML private Label messageLabel;
    @FXML private Label attemptsLabel;
    @FXML private TextField guessInput;
    @FXML private Label scoreLabel;
private final HangmanScoreboard scoreboard = new HangmanScoreboard();

    private HangmanGame game;

    @FXML
    public void initialize() {
        game = new HangmanGame("banana");
        updateUI();
    }

    @FXML
    public void handleGuess() {
        String guess = guessInput.getText().toLowerCase();
        if (guess.length() == 1 && Character.isLetter(guess.charAt(0))) {
            game.guessLetter(guess.charAt(0));
        }
        guessInput.clear();
        updateUI();
    }

    private void updateUI() {
        wordLabel.setText(game.getMaskedWord());
        messageLabel.setText(game.getMessage());
        attemptsLabel.setText("Attempts left: " + game.getAttemptsLeft());

        if (game.isGameOver()) {
            guessInput.setDisable(true);
            String currentWord = game.getMaskedWord().replace(" ", "");
            if (currentWord.equals(game.getWord())) {
                scoreboard.addWin();
            } else {
                scoreboard.addLoss();
            }
            scoreLabel.setText(scoreboard.toString());
        }
    }

}
