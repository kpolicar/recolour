package kpolicar.ui;

import kpolicar.Main;

import javax.swing.*;
import java.awt.*;

public class ButtonGrid extends JPanel {
    public GridButton[][] buttons;

    ButtonGrid() {
        super();
        buildGrid();
    }

    public void buildGrid() {
        int rows = Main.preferences.rows, columns = Main.preferences.columns;

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
