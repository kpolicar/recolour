package kpolicar.xml.adapted;

import kpolicar.game.Preferences;
import kpolicar.game.entity.Board;

public class Match {
    public Board board;
    public Preferences preferences;

    public Match() {
    }

    public Match(kpolicar.game.Match original) {
        board = original.board;
        preferences = original.preferences;
    }
}
