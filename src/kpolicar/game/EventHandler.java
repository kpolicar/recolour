package kpolicar.game;

import kpolicar.ui.GameFrame;

public class EventHandler {
    GameFrame gameFrame;
    Field field;

    public EventHandler(GameFrame gameFrame, Field field) {
        this.gameFrame = gameFrame;
        this.field = field;
    }
}
