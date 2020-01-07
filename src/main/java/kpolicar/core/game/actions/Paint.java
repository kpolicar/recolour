package kpolicar.core.game.actions;

import kpolicar.game.Action;
import kpolicar.game.Score;
import kpolicar.game.entity.Board;
import kpolicar.game.entity.Cell;
import kpolicar.ui.ButtonGrid;
import kpolicar.ui.GameFrame;

import java.awt.*;

public class Paint implements Action {
    Cell cell;
    Point position;
    Board board;
    ButtonGrid buttons;
    Color color;
    Score score;

    public Paint(ButtonGrid buttons, Board board, Point position, Color color, Score score) {
        this.buttons = buttons;
        this.board = board;
        this.position = position;
        this.cell = board.cellAt(position);
        this.color = color;
        this.score = score;
    }

    public void execute() {
        for (Cell connected : board.connectedTo(position)) {
            color(connected.position);
        }
        score.increment();
    }

    protected void color(Point position) {
        buttons.buttonAt(position).setBackground(color);
        board.cellAt(position).color = color;
    }
}
