package kpolicar.game.actions;

import kpolicar.Main;

import java.awt.*;

public class AssignSourceColor implements GameAction {
    Color color;

    public AssignSourceColor(Color color) {
        this.color = color;
    }

    @Override
    public void execute() {
        Main.preferences.source = color;
    }
}
