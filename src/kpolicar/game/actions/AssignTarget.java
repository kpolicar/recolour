package kpolicar.game.actions;

import kpolicar.Main;

import java.awt.*;

public class AssignTarget implements GameAction {
    Color color;

    public AssignTarget(Color color) {
        this.color = color;
    }

    @Override
    public void execute() {
        Main.preferences.target = color;
    }
}
