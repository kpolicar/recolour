package kpolicar.core;

import kpolicar.game.ActionHandler;
import kpolicar.game.Score;
import kpolicar.game.entity.Board;
import kpolicar.ui.GameFrame;

import javax.xml.bind.JAXBException;

public class Game {
    public ActionHandler actions;
    public GameFrame frame;
    public Board board;
    public Score score = new Score();

    public Game(GameFrame frame) {
        this.frame = frame;

        board = new Board();
        actions = new ActionHandler(this);

        new UiEventHandler(this);
    }

    public void begin() {
        actions.randomize();
        frame.setVisible(true);
    }
}
