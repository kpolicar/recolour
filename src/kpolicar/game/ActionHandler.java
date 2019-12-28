package kpolicar.game;

import kpolicar.game.entity.Board;
import kpolicar.ui.GameFrame;

import java.awt.*;

public class ActionHandler {
    Board board;
    ActionFactory factory;

    public ActionHandler(Board board, GameFrame frame) {
        this.factory = new ActionFactory(board, frame);
        this.board = board;
    }

    public void assignSource(Point position) {
        factory.assignSource(position).execute();
    }

    public void assignTarget(Point position) {
        factory.assignTarget(position).execute();
    }

    public void paint(Point position, Color color) {
        factory.paint(position, color).execute();

        if (board.isComplete()) {
            factory.victory().execute();
            factory.restart().execute();
        } else {
            factory.save().execute();
        }
    }

    public void randomize() {
        factory.randomize().execute();
    }

    public void restart() {
        factory.restart().execute();
    }

    public void save() {
        factory.save().execute();
    }

    public void load() {
        factory.load().execute();
    }
}
