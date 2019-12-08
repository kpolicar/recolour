package kpolicar.game;

import javax.swing.event.EventListenerList;
import java.awt.*;

public class Cell extends CellAbstract {

    Cell(int row, int column) {
        position = new Point(row, column);
    }

    public void color(Color color) {
        this.color = color;
        fireColorChanged();
    }
}
