package kpolicar.ui;

import kpolicar.game.Cell;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GridButton buttons[][];

    public GameFrame(int rows, int columns) {
        setSize(300, 300);
        setLayout(new GridLayout(rows, columns));

        buttons = new GridButton[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                GridButton button = buttons[row][column] = new GridButton(row, column);
                add(button);
            }
        }
    }

    public GridButton buttonAt(Point position) {
        return buttons[position.x][position.y];
    }
}
