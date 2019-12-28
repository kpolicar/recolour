package kpolicar.game;

import kpolicar.game.entity.Board;
import kpolicar.ui.GameFrame;

import java.awt.*;
import java.io.File;

public class ActionHandler {
    Board board;
    ActionFactory factory;
    Score score;

    public ActionHandler(Board board, GameFrame frame, Score score) {
        this.factory = new ActionFactory(board, frame);
        this.board = board;
        this.score = score;
    }

    public void assignSource(Point position) {
        factory.assignSource(position).execute();
    }

    public void assignTarget(Point position) {
        factory.assignTarget(position).execute();
    }

    public void paint(Point position, Color color) {
        factory.paint(position, color, score).execute();

        if (board.isComplete()) {
            factory.victory(score).execute();
            factory.restart(score).execute();
        } else {
            factory.save().execute();
        }
    }

    public void randomize() {
        factory.randomize().execute();
    }

    public void restart(Score score) {
        factory.restart(score).execute();
    }

    public void save() {
        factory.save().execute();
    }

    public void load(File file) {
        factory.load(file).execute();
    }
}
