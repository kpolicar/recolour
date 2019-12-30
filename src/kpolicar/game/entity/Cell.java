package kpolicar.game.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import java.awt.*;

public class Cell {
    public Point position;
    @XmlTransient
    public Color color;

    public Cell() {
    }

    public Cell(int row, int column) {
        position = new Point(row, column);
    }

    public Cell(int row, int column, Color color) {
        this(row, column);
        this.color = color;
    }

    public int getColor() {
        return color.getRGB();
    }

    public void setColor(int rgb) {
        color = new Color(rgb);
    }
}
