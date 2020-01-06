package kpolicar.xml.adapted;

import java.awt.Color;

public class Cell {
    public int x, y;
    public Color color;

    public Cell() {
    }

    public Cell(kpolicar.game.entity.Cell original) {
        x = original.position.x;
        y = original.position.y;
        color = original.color;
    }
}
