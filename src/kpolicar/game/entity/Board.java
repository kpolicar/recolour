package kpolicar.game.entity;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Stream;

public class Board {
    final public Cell[][] cells;

    public Board(int rows, int columns) {
        cells = new Cell[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                cells[row][column] = new Cell(row, column);
            }
        }
    }

    public boolean isComplete() {
        Color color = cells[0][0].color;

        return Stream.of(cells)
                .flatMap(Arrays::stream)
                .allMatch(cell -> cell.color == color);
    }

    public Cell[] neighborsOf(Point position) {
        LinkedList<Cell> neighbors = new LinkedList<>();

        int r = position.x, c = position.y;
        for (int nr = Math.max(0, r - 1); nr <= Math.min(r + 1, cells.length - 1); ++nr) {
            for (int nc = Math.max(0, c - 1); nc <= Math.min(c + 1, cells[0].length - 1); ++nc) {
                if (!(nr == r && nc == c)) {
                    neighbors.add(cells[nr][nc]);
                }
            }
        }

        return neighbors.toArray(new Cell[0]);
    }

    public Cell cellAt(Point position) {
        return cells[position.x][position.y];
    }
}
