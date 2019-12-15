package kpolicar.game.actions;

import kpolicar.Main;

import java.awt.*;

public class AssignSource implements GameAction {
    Color color;

    public AssignSource(Color color) {
        this.color = color;
    }

    @Override
    public void execute() {
        Main.preferences.source = color;
    }
}
