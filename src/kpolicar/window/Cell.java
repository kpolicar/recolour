package kpolicar.window;

import javax.swing.*;
import java.awt.Point;

public class Cell implements HasComponent {
    Point coordinates;
    JButton component;

    public Cell() {
        component = new JButton("Test");
    }

    public JComponent getComponent() {
        return component;
    }
}
