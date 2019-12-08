package kpolicar.game;

import kpolicar.Main;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Field {
    public Cell[][] cells;
    Random rand = new Random();

    public Field() {
        int rows = Main.preferences.rows, columns = Main.preferences.columns;

        cells = new Cell[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                cells[row][column] = new Cell(row, column);
            }
        }
    }

    public void randomize() {
        Stream.of(cells)
                .flatMap(Arrays::stream)
                .forEach(cell -> cell.color(variation()));
    }

    public Cell cellAt(Point position) {
        return cells[position.x][position.y];
    }

    public Color variation() {
        Color[] palette = Main.preferences.palette;
        return palette[rand.nextInt(palette.length)];
    }
}
