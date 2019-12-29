package kpolicar.ui;

import kpolicar.Main;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameMenu menu;
    public ButtonGrid grid;
    public PalettePanel palette;

    public GameFrame() {
        setSize(300, 300);
        setLayout(new BorderLayout());
        setExtendedState(Frame.MAXIMIZED_BOTH);

        add(new Label("Heyo"), BorderLayout.PAGE_START);
        add(palette = new PalettePanel(), BorderLayout.LINE_END);
        add(grid = new ButtonGrid(), BorderLayout.CENTER);

        setJMenuBar(menu = new GameMenu());
    }

    public GridButton buttonAt(Point position) {
        return grid.buttons[position.x][position.y];
    }
}
