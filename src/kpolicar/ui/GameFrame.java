package kpolicar.ui;

import com.sun.scenario.effect.impl.sw.java.JSWBoxBlurPeer;
import kpolicar.Main;
import kpolicar.game.Cell;
import kpolicar.game.Preferences;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GridButton buttons[][];

    public GameFrame() {
        int rows = Main.preferences.rows, columns = Main.preferences.columns;

        setSize(300, 300);
        setLayout(new BorderLayout());
        setExtendedState(Frame.MAXIMIZED_BOTH);

        add(new Label("Heyo"), BorderLayout.PAGE_START);
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.PAGE_AXIS));
        sidebar.add(new Label("Available colors"));
        add(sidebar, BorderLayout.LINE_END);



        JPanel board = new JPanel(new GridLayout(rows, columns));

        buttons = new GridButton[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                GridButton button = buttons[row][column] = new GridButton(row, column);
                board.add(button);
            }
        }

        add(board, BorderLayout.CENTER);
    }

    public GridButton buttonAt(Point position) {
        return buttons[position.x][position.y];
    }
}
