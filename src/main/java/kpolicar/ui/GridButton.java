package kpolicar.ui;

import kpolicar.Main;
import kpolicar.core.Settings;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class GridButton extends JButton {
    public Point position;

    public GridButton(int row, int column) {
        super();
        position = new Point(row, column);

        setBorder(Main.settings.border);
        setOpaque(true);
        setBackground(Color.BLUE);
        setForeground(Color.WHITE);

        if (position.equals(Main.preferences.source)) {
            setBorder(Main.settings.sourceBorder);
        }
    }

    public String formatPosition() {
        return "[" + position.x + "," + position.y + "]";
    }
}
