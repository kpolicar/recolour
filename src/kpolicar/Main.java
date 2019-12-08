package kpolicar;

import kpolicar.game.Field;
import kpolicar.ui.EventHandler;
import kpolicar.ui.GameFrame;

import javax.swing.*;

public class Main {

    static GameFrame mainFrame;
    static Field gameField;
    static EventHandler uxEventHandler;

    public static void main(String[] args) {
        int rows, columns;
        rows = Integer.parseInt(args[0]);
        columns = Integer.parseInt(args[1]);

        init(rows, columns);

        mainFrame.setVisible(true);
    }

    private static void init(int rows, int columns) {
        mainFrame = new GameFrame(rows, columns);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        gameField = new Field(rows, columns);

        uxEventHandler = new EventHandler(mainFrame, gameField);
    }

}
