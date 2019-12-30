package kpolicar.core.game;

import kpolicar.core.Game;
import kpolicar.core.game.ActionFactory;

public class EventHandler {
    private final ActionFactory actions;

    public EventHandler(Game game) {
        this.actions = new ActionFactory(game);
    }
}
