package kpolicar.game;

public class Field {
    Cell[][] cells;

    public Field(int rows, int columns) {
        cells = new Cell[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                cells[row][column] = new Cell(row, column);
            }
        }
    }
}
