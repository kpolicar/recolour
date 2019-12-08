package kpolicar;

import kpolicar.game.Field;
import kpolicar.ui.GameFrame;

import javax.swing.*;

public class Main {

    static GameFrame mainFrame;
    static Field gameField;
    static kpolicar.ui.EventHandler uiEventHandler;
    static kpolicar.game.EventHandler gameEventHandler;

    public static void main(String[] args) {
        int rows, columns, variations;
        rows = Integer.parseInt(args[0]);
        columns = Integer.parseInt(args[1]);
        variations = Integer.parseInt(args[2]);

        init(rows, columns, variations);

        mainFrame.setVisible(true);
    }

    private static void init(int rows, int columns, int variations) {
        mainFrame = new GameFrame(rows, columns);
        gameField = new Field(rows, columns, variations);

        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        uiEventHandler = new kpolicar.ui.EventHandler(mainFrame, gameField);
        gameEventHandler = new kpolicar.game.EventHandler(mainFrame, gameField);

        gameField.randomize();
    }

}
