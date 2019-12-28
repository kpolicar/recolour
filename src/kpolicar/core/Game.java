package kpolicar.core;

import kpolicar.game.ActionFactory;
import kpolicar.game.ActionHandler;
import kpolicar.game.Score;
import kpolicar.game.entity.Board;
import kpolicar.ui.GameFrame;

public class Game {
    final public ActionHandler actions;
    final public GameFrame frame;
    final public Board board;
    public Score score = new Score();

    public Game(GameFrame frame) {
        this.frame = frame;

        board = new Board();
        actions = new ActionHandler(board, frame);

        new UiEventHandler(frame, actions);
    }

    public void begin() {
        actions.randomize();
        frame.setVisible(true);
    }
}
