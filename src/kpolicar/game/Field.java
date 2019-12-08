package kpolicar.game;

import java.awt.*;
import java.util.Random;

public class Field {
    Color[] variations;
    public Cell[][] cells;
    Random rand = new Random();

    public Field(int variations) {
        generateVariations(variations);
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

    public void buildCells(int rows, int columns) {
        cells = new Cell[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                initCell(row, column);
            }
        }
    }

    public void initCell(int row, int column) {
        Cell cell = cells[row][column] = new Cell(row, column);
        cell.color(variation());
    }

    public Cell cellAt(Point position) {
        return cells[position.x][position.y];
    }

    public Color variation() {
        return variations[rand.nextInt(variations.length-1)];
    }
}
