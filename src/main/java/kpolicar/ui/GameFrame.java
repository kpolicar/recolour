package kpolicar.ui;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameMenu menu;
    public ButtonGrid grid;
    public PalettePanel palette;
    protected ActionHandler actions = new ActionHandler(this);

    public GameFrame() {
        setSize(300, 300);
        setLayout(new BorderLayout());
        setExtendedState(Frame.MAXIMIZED_BOTH);

        setJMenuBar(menu = new GameMenu(actions));
        makeGameFields();
    }

    public void makeGameFields() {
        if (grid != null) {
            remove(grid);
        }
        if (palette != null) {
            remove(palette);
        }

        add(grid = new ButtonGrid(), BorderLayout.CENTER);
        add(palette = new PalettePanel(actions), BorderLayout.LINE_END);
        validate();
    }

    public GridButton buttonAt(Point position) {
        return grid.buttons[position.x][position.y];
    }
}
