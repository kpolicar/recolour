package kpolicar.game.entity;

import javax.xml.bind.annotation.XmlTransient;
import java.awt.*;

public class Cell {
    @XmlTransient
    public Color color;
    @XmlTransient
    public Point position = new Point();

    Cell() {}
    Cell(int row, int column) {
        position = new Point(row, column);
    }

    public int getX() {
        return position.x;
    }

    public void setX(int x) {
        position.x = x;
    }

    public int getY() {
        return position.y;
    }

    public void setY(int y) {
        position.y = y;
    }

    public int getColor() {
        return color.getRGB();
    }

    public void setColor(int value) {
        color = new Color(value);
    }
}
