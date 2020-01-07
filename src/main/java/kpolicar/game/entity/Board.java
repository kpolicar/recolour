package kpolicar.game.entity;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Stream;

public class Board {
    final public Cell[][] cells;

    public Board(Cell[][] cells) {
        this.cells = cells;
    }

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

    public Cell[] connectedTo(Point position) {
        LinkedList<Cell> buffer = new LinkedList<>();
        buffer.add(cellAt(position));

        return connectedTo(position, buffer)
                .toArray(Cell[]::new);
    }

    protected LinkedList<Cell> connectedTo(Point position, LinkedList<Cell> buffer) {
        Cell[] connected = connectedNeighborsOf(position);

        for (Cell neighbor : connected) {
            if (buffer.contains(neighbor)) continue;

            buffer.add(neighbor);
            buffer = connectedTo(neighbor.position, buffer);
        }

        return buffer;
    }

    public Cell[] connectedNeighborsOf(Point position) {
        Cell cell = cellAt(position);
        Cell[] neighbors = neighborsOf(position);

        return Stream.of(neighbors)
                .filter(neighbor -> neighbor.color.equals(cell.color))
                .toArray(Cell[]::new);
    }

    public Cell[] neighborsOf(Point position) {
        Point up = new Point(position.x, position.y+1);
        Point right = new Point(position.x+1, position.y);
        Point down = new Point(position.x, position.y-1);
        Point left = new Point(position.x-1, position.y);

        Point[] points = {up, right, down, left};

        return Stream.of(points)
                .map(this::cellAt)
                .filter(Objects::nonNull)
                .toArray(Cell[]::new);
    }

    public Cell cellAt(Point position) {
        try {
            return cells[position.x][position.y];
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
