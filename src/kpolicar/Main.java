package kpolicar;

import kpolicar.core.Game;
import kpolicar.game.Preferences;
import kpolicar.ui.GameFrame;

import javax.swing.*;

public class Main {
    public static Game game;
    public static Preferences preferences;
    static GameFrame mainFrame;

    public static void main(String[] args) {
        int rows, columns, variations;
        rows = Integer.parseInt(args[0]);
        columns = Integer.parseInt(args[1]);
        variations = Integer.parseInt(args[2]);

        preferences = new Preferences(rows, columns, variations);
        buildFrame();
        startGame();
    }

    protected static void buildFrame() {
        mainFrame = new GameFrame();
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    protected static void startGame() {
        game = new Game(mainFrame, preferences);
        game.begin();
        mainFrame.setVisible(true);
    }

    public static void restartGame() {
        mainFrame.setVisible(false);
        mainFrame.dispose();
        startGame();
    }
}
