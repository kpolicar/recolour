package kpolicar.core;

import kpolicar.Main;
import kpolicar.game.Match;
import kpolicar.ui.GameFrame;

public class Game {
    final public GameFrame frame;
    public Match match;

    public Game(GameFrame frame) {
        this.frame = frame;
        match = new Match(Main.preferences, frame);

        new UiEventHandler(frame, match.actions, match.score);
    }

    public void begin() {
        match.begin();
    }
}
