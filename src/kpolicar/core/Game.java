package kpolicar.core;

import kpolicar.game.ActionHandler;
import kpolicar.game.Score;
import kpolicar.game.entity.Board;
import kpolicar.ui.GameFrame;

public class Game {
    public ActionHandler actions;
    public GameFrame frame;
    public Board board;
    Score score = new Score();

    public Game(GameFrame frame) {
        this.frame = frame;

        board = new Board();
        actions = new ActionHandler(frame, board, score);

        new UiEventHandler(this);
        new GameEventHandler(this);
    }

    public void begin() {
        actions.randomize();
        frame.setVisible(true);
    }
}
