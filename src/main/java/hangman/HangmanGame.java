package model;

import java.util.HashSet;
import java.util.Set;

/**
 * A simple Hangman game class.
 * Stores the word, tracks guesses, remaining attempts, and result messages.
 */
public class HangmanGame {
    // The word the player is trying to guess
    private final String word;

    // A set to keep track of letters the player has guessed
    private final Set<Character> guessedLetters = new HashSet<>();

    // Number of incorrect attempts remaining before game over
    private int attemptsLeft = 6;

    // Message to show the user based on their last guess
    private String message = "";

    /**
     * Constructor initializes the game with the given word.
     * Converts the word to lowercase for consistency in comparisons.
     * 
     * @param word the target word to guess
     */
    public HangmanGame(String word) {
        this.word = word.toLowerCase();
    }

    /**
     * Handles a letter guess from the user.
     * If the letter hasn't been guessed before:
     *  - adds it to the guessed set
     *  - checks if it's in the word
     *      - if not, decreases attempts
     *      - updates message accordingly
     * If the letter was already guessed, sets a message indicating so.
     * 
     * @param letter the letter guessed by the player
     */
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
  
    /**
     * Returns the word in masked form for display (e.g. "_ a _ a _ a").
     * Reveals guessed letters, hides others with underscores.
     * 
     * @return the masked version of the word
     */
    public String getMaskedWord() {
        StringBuilder masked = new StringBuilder();
        for (char c : word.toCharArray()) {
            masked.append(guessedLetters.contains(c) ? c + " " : "_ ");
        }
        return masked.toString().trim();
    }

    /**
     * Checks if the game is over due to win or loss.
     * Game ends when:
     *  - All letters have been correctly guessed, OR
     *  - No attempts remain.
     * 
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        return attemptsLeft <= 0 || getMaskedWord().replace(" ", "").equals(word);
    }

    /**
     * Returns the number of incorrect guesses remaining.
     * 
     * @return attempts left
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * Returns the current message to display to the user based on last guess.
     * 
     * @return message string
     */
    public String getMessage() {
        return message;
    }
}

