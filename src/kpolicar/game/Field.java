package kpolicar.game;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Field {
    Color[] variations;
    public Cell[][] cells;
    Random rand = new Random();

    public Field(int rows, int columns, int variations) {
        generateVariations(variations);

        cells = new Cell[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                cells[row][column] = new Cell(row, column);
            }
        }
    }

    public void generateVariations(int number) {
        variations = new Color[number];
        for (int i = 0; i < number; i++) {
            variations[i] = new Color(
                    rand.nextInt(255),
                    rand.nextInt(255),
                    rand.nextInt(255));
        }
    }

    public void randomize() {
        Stream.of(cells)
                .flatMap(Arrays::stream)
                .forEach(o -> o.color(variation()));
    }

    public Cell cellAt(Point position) {
        return cells[position.x][position.y];
    }

    public Color variation() {
        return variations[rand.nextInt(variations.length)];
    }
}
