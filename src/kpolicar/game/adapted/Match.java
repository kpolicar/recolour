package kpolicar.game.adapted;

import kpolicar.game.Preferences;
import kpolicar.game.Score;
import kpolicar.game.entity.Board;

public class Match {
    public Board board;
    public Preferences preferences;
    public Score score = new Score();

    public Match() {
    }

    public Match(kpolicar.game.Match original) {
        board = original.board;
        preferences = original.preferences;
        score = original.score;
    }
}
