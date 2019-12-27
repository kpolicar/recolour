package kpolicar.game.events;

import kpolicar.Main;
import kpolicar.game.ActionHandler;
import kpolicar.ui.GridButton;

import java.awt.*;

public class CellEvent implements GameEvent {
    Point position;
    ActionHandler actions;

    public CellEvent(Point position, ActionHandler actions) {
        this.position = position;
        this.actions = actions;
    }

    public void handle() {
        if (Main.preferences.source == null) {
            actions.assignSource(position);
        } else if (Main.preferences.target == null) {
            actions.assignTarget(position);
        } else {
            actions.paint(position, Main.preferences.source);
        }
    }
}
