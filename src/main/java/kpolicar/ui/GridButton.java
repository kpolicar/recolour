package kpolicar.ui;

import kpolicar.core.Settings;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class GridButton extends JButton {
    public Point position;

    public GridButton(int row, int column) {
        super();
        position = new Point(row, column);

        setBorder(Settings.border);
        setOpaque(true);
        setBackground(Color.BLUE);
        setForeground(Color.WHITE);
    }

    public String formatPosition() {
        return "[" + position.x + "," + position.y + "]";
    }
}