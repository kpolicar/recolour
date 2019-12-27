package kpolicar.ui;

import kpolicar.Main;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameMenu menu;
    public ButtonGrid grid;
    public PalettePanel palette;

    public GameFrame() {
        int rows = Main.preferences.rows, columns = Main.preferences.columns;

        setSize(300, 300);
        setLayout(new BorderLayout());
        setExtendedState(Frame.MAXIMIZED_BOTH);

        add(new Label("Heyo"), BorderLayout.PAGE_START);
        add(palette = new PalettePanel(), BorderLayout.LINE_END);
        add(grid = new ButtonGrid(rows, columns), BorderLayout.CENTER);

        setJMenuBar(menu = new GameMenu());
    }

    public GridButton buttonAt(Point position) {
        return grid.buttons[position.x][position.y];
    }
}
