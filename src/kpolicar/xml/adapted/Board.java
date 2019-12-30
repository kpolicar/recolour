package kpolicar.xml.adapted;

import kpolicar.game.entity.Cell;

public class Board {
    public Cell[][] cells;

    public Board() {
    }

    public Board(kpolicar.game.entity.Board original) {
        cells = original.cells;
    }
}
