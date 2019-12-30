package kpolicar.game.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.awt.*;

public class Cell {
    public Point position = new Point();
    public Color color;

    Cell() {
    }

    Cell(int row, int column) {
        position = new Point(row, column);
    }
}
