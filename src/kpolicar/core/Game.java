package kpolicar.core;

import kpolicar.core.game.ActionFactory;
import kpolicar.core.game.EventHandler;
import kpolicar.game.Match;
import kpolicar.game.Preferences;
import kpolicar.ui.GameFrame;

public class Game {
    final public GameFrame frame;
    public Match match;

    public Game(GameFrame frame, Preferences preferences) {
        this.frame = frame;
        match = new Match(preferences, new ActionFactory(this));

        new UiEventHandler(this);
        new EventHandler(this);
    }

    public void begin() {
        match.begin();
    }
}
