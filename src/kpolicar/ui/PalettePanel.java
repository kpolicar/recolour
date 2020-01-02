package kpolicar.ui;

import kpolicar.Main;
import kpolicar.core.Settings;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class PalettePanel extends JPanel {
    public HashMap<Color, JButton> buttons = new HashMap<>();

    PalettePanel() {
        super();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Available colors"));
        addColors();
    }

    protected void addColors() {
        for (Color color : Main.preferences.palette) {
            JButton button = new JButton();
            buttons.put(color, button);

            button.setMaximumSize(new Dimension(50, 50));
            button.setBackground(color);
            if (color.equals(Main.preferences.source)) {
                button.setBorder(Settings.sourceBorder);
            } else if (color.equals(Main.preferences.target)) {
                button.setBorder(Settings.targetBorder);
            }
            add(button);
        }
    }
}
