package kpolicar.ui;

import javax.swing.*;
import java.awt.*;

public class GridButton extends JButton {
    public Point position;

    public GridButton(int row, int column) {
        super();
        position = new Point(row, column);

        setText(formatPosition());
        setOpaque(true);
        setBackground(Color.BLUE);
        setForeground(Color.WHITE);
    }

    public String formatPosition() {
        return "[" + position.x + "," + position.y + "]";
    }
}
