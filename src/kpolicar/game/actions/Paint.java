package kpolicar.game.actions;

import kpolicar.Main;
import kpolicar.game.entity.Cell;
import kpolicar.ui.GameFrame;
import kpolicar.ui.GridButton;

import java.awt.*;

public class Paint implements GameAction, IncrementsScore {
    GameFrame gameFrame;
    Cell cell;
    Color color;

    public Paint(GameFrame gameFrame, Cell cell, Color color) {
        this.gameFrame = gameFrame;
        this.cell = cell;
        this.color = color;
    }

    @Override
    public void execute() {
        if (!shouldPaint()) return;

        for (Cell neighbor : cell.neighbors()) {
            colorButton(neighbor.position);
        }
        colorButton(cell.position);
    }

    protected boolean shouldPaint() {
        for (Cell neighbor : cell.neighbors()) {
            if (neighbor.color == Main.preferences.target) {
                return true;
            }
        }
        return false;
    }

    protected void colorButton(Point position) {
        gameFrame.buttonAt(position).setBackground(color);
    }

    @Override
    public boolean shouldIncrementScore() {
        return false;
    }
}
