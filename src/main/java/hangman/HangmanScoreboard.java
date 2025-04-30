package model;

public class HangmanScoreboard {
    private int wins;
    private int losses;

    public void addWin() {
        wins++;
    }

    public void addLoss() {
        losses++;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    @Override
    public String toString() {
        return "Wins: " + wins + " | Losses: " + losses;
    }
}
