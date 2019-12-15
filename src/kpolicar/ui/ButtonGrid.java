package kpolicar.ui;

import javax.swing.*;
import java.awt.*;

public class ButtonGrid extends JPanel {
    public GridButton[][] buttons;

    ButtonGrid(int rows, int columns) {
        super();
        setLayout(new GridLayout(rows, columns));

        buttons = new GridButton[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                GridButton button = buttons[row][column] = new GridButton(row, column);
                add(button);
            }
        }
    }

}
