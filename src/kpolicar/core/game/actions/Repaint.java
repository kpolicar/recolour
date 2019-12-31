package kpolicar.core.game.actions;

import kpolicar.game.entity.Board;
import kpolicar.ui.GameFrame;

import java.awt.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Repaint implements Action {
    GameFrame gameFrame;
    Board board;

    public Repaint(GameFrame gameFrame, Board board) {
        this.gameFrame = gameFrame;
        this.board = board;
    }

    public void execute() {
        paintGrid();
    }

    protected void paintGrid() {
        Stream.of(board.cells)
                .flatMap(Arrays::stream)
                .forEach(cell -> {
                    Color color = board.cellAt(cell.position).color;
                    gameFrame.buttonAt(cell.position).setBackground(color);
                });
    }
}
