package kpolicar;

import kpolicar.core.Game;
import kpolicar.core.Settings;
import kpolicar.game.Preferences;
import kpolicar.ui.GameFrame;

import javax.swing.*;

public class Main {
    protected static Game game;
    protected static GameFrame mainFrame;
    public static Preferences preferences;
    public static Settings settings = new Settings();

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
        game = new Game(mainFrame);
        game.prepare(preferences);
        game.begin();
        mainFrame.setVisible(true);
    }
}
