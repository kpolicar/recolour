package kpolicar.ui;

import kpolicar.Main;

import javax.swing.*;
import java.awt.*;

public class PalettePanel extends JPanel {
    PalettePanel() {
        super();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Available colors"));
        addColors();
    }

    protected void addColors() {
        for (Color color : Main.preferences.palette) {
            JButton button = new JButton();
            button.setMaximumSize(new Dimension(50, 50));
            button.setBackground(color);
            add(button);
        }
    }
}
