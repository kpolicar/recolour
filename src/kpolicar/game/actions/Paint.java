package kpolicar.game.actions;

import kpolicar.Main;
import kpolicar.game.entity.Board;
import kpolicar.game.entity.Cell;
import kpolicar.ui.GameFrame;
import java.awt.*;

public class Paint implements Action, IncrementsScore {
    Cell cell;
    Point position;
    Board board;
    GameFrame gameFrame;
    Color color;

    public Paint(GameFrame gameFrame, Board board, Point position, Color color) {
        this.gameFrame = gameFrame;
        this.board = board;
        this.position = position;
        this.cell = board.cellAt(position);
        this.color = color;
    }

    public void execute() {
        if (!shouldPaint()) return;

        for (Cell neighbor : board.neighborsOf(position)) {
            color(neighbor.position);
        }
        color(cell.position);
    }

    protected boolean shouldPaint() {
        for (Cell neighbor : board.neighborsOf(position)) {
            if (neighbor.color == Main.preferences.target) {
                return true;
            }
        }
        return false;
    }

    protected void color(Point position) {
        gameFrame.buttonAt(position).setBackground(color);
        board.cellAt(position).color = color;
    }

    public boolean shouldIncrementScore() {
        return false;
    }
}
