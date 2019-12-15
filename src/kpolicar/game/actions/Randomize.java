package kpolicar.game.actions;


import kpolicar.game.entity.Board;
import kpolicar.game.entity.Cell;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Randomize implements GameAction {
    Board board;
    Color[] palette;
    Random rand = new Random();

    public Randomize(Board board, Color[] palette) {
        this.board = board;
        this.palette = palette;
    }

    @Override
    public void execute() {
        Stream.of(board.cells)
                .flatMap(Arrays::stream)
                .forEach(cell -> cell.color(variation()));
    }

    public Color variation() {
        return palette[rand.nextInt(palette.length)];
    }
}
