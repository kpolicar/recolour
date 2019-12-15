package kpolicar.game.actions;

import kpolicar.Main;
import kpolicar.ui.GridButton;

import java.awt.*;

public class Paint implements GameAction, IncrementsScore {
    GridButton button;
    Color color;

    public Paint(GridButton button, Color color) {
        this.button = button;
        this.color = color;
    }

    @Override
    public void execute() {
        button.setBackground(color);
    }

    @Override
    public boolean shouldIncrementScore() {
        return false;
    }
}
