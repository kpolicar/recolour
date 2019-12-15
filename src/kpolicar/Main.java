package kpolicar;

import kpolicar.core.UiEventHandler;
import kpolicar.core.GameEventHandler;
import kpolicar.core.Game;
import kpolicar.game.entity.Board;
import kpolicar.game.Preferences;
import kpolicar.ui.GameFrame;

import javax.swing.*;

public class Main {
    public static Preferences preferences;
    static GameFrame mainFrame;
    static Board gameBoard;
    static UiEventHandler uiEventHandler;
    static GameEventHandler gameEventHandler;

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
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Game game = new Game(mainFrame);
        game.begin();
    }

}
