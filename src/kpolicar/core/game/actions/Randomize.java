package kpolicar.core.game.actions;


import kpolicar.game.Action;
import kpolicar.game.entity.Board;
import kpolicar.ui.GameFrame;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Randomize implements Action {
    GameFrame gameFrame;
    Board board;
    Color[] palette;
    Random rand = new Random();

    public Randomize(GameFrame gameFrame, Board board, Color[] palette) {
        this.gameFrame = gameFrame;
        this.board = board;
        this.palette = palette;
    }

    public void execute() {
        Stream.of(board.cells)
                .flatMap(Arrays::stream)
                .forEach(cell -> {
                    Color color = variation();
                    board.cellAt(cell.position).color = color;
                    gameFrame.buttonAt(cell.position).setBackground(color);
                });
    }

    public Color variation() {
        return palette[rand.nextInt(palette.length)];
    }
}
