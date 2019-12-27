package kpolicar.core;

import kpolicar.game.ActionHandler;
import kpolicar.game.Score;
import kpolicar.game.entity.Board;
import kpolicar.ui.GameFrame;

import javax.xml.bind.JAXBException;

public class Game {
    public ActionHandler actions;
    public StateHandler state;
    public GameFrame frame;
    public Board board;
    public Score score = new Score();

    public Game(GameFrame frame) {
        this.frame = frame;

        board = new Board();
        try {
            state = new StateHandler(board);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        actions = new ActionHandler(this);

        new UiEventHandler(this);
        new GameEventHandler(this);
    }

    public void begin() {
        actions.randomize();
        frame.setVisible(true);
    }
}
