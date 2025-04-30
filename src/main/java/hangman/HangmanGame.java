package model;

import java.util.HashSet;
import java.util.Set;

public class HangmanGame {
    private final String word;
    private final Set<Character> guessedLetters = new HashSet<>();
    private int attemptsLeft = 6;
    private String message = "";

    public HangmanGame(String word) {
        this.word = word.toLowerCase();
    }

    public void guessLetter(char letter) {
        if (!guessedLetters.contains(letter)) {
            guessedLetters.add(letter);
            if (!word.contains(Character.toString(letter))) {
                attemptsLeft--;
                message = "Wrong guess!";
            } else {
                message = "Correct!";
            }
        } else {
            message = "Already guessed!";
        }
    }

    public String getWord() {
        return word;
    }

    public String getMaskedWord() {
        StringBuilder masked = new StringBuilder();
        for (char c : word.toCharArray()) {
            masked.append(guessedLetters.contains(c) ? c + " " : "_ ");
        }
        return masked.toString().trim();
    }

    public boolean isGameOver() {
        return attemptsLeft <= 0 || getMaskedWord().replace(" ", "").equals(word);
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public String getMessage() {
        return message;
    }
}
