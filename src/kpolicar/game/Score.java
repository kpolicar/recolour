package kpolicar.game;

public class Score {
    private int moves = 0;

    public void increment() {
        moves++;
    }

    public int moves() {
        return moves;
    }

    public void reset() {
        moves = 0;
    }
}
