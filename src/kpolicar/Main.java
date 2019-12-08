package kpolicar;

import kpolicar.game.Board;
import kpolicar.game.Preferences;
import kpolicar.ui.GameFrame;

import javax.swing.*;

public class Main {
    public static Preferences preferences;
    static GameFrame mainFrame;
    static Board gameBoard;
    static kpolicar.ui.EventHandler uiEventHandler;
    static kpolicar.game.EventHandler gameEventHandler;

    public static void main(String[] args) {
        int rows, columns, variations;
        rows = Integer.parseInt(args[0]);
        columns = Integer.parseInt(args[1]);
        variations = Integer.parseInt(args[2]);

        preferences = new Preferences(rows, columns, variations);

        initGame();
    }

    private static void initGame() {
        mainFrame = new GameFrame();
        gameBoard = new Board();

        uiEventHandler = new kpolicar.ui.EventHandler(mainFrame, gameBoard);
        gameEventHandler = new kpolicar.game.EventHandler(mainFrame, gameBoard);

        gameBoard.randomize();

        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setVisible(true);
    }

}
