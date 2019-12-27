package kpolicar.game.entity;

import javax.xml.bind.annotation.*;
import java.awt.*;

public class Cell extends CellAbstract {
    @XmlTransient()
    Board board;

    Cell(Board board, int row, int column) {
        this.board = board;
        position = new Point(row, column);
    }

    public void color(Color color) {
        this.color = color;
        fireColorChanged();
    }

    public Cell[] neighbors() {
        return board.neighborsOf(position);
    }
}
