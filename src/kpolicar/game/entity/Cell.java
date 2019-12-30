package kpolicar.game.entity;

import java.awt.*;

public class Cell {
    final public Point position;
    public Color color;

    Cell(int row, int column) {
        position = new Point(row, column);
    }
}
