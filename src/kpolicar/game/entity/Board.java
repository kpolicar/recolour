package kpolicar.game.entity;

import kpolicar.Main;
import java.awt.*;

public class Board {
    public Cell[][] cells;

    public Board() {
        int rows = Main.preferences.rows, columns = Main.preferences.columns;

        cells = new Cell[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                cells[row][column] = new Cell(row, column);
            }
        }
    }

    public Cell cellAt(Point position) {
        return cells[position.x][position.y];
    }
}
