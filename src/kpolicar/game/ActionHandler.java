package kpolicar.game;

import java.awt.*;
import java.io.File;

public class ActionHandler {
    Match match;
    ActionFactory factory;
    Score score;

    public ActionHandler(Match match, ActionFactory factory, Score score) {
        this.match = match;
        this.factory = factory;
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

        if (match.board.isComplete()) {
            factory.victory(score).execute();
            factory.restart(score).execute();
        } else {
            factory.save().execute();
        }
    }

    public void randomize() {
        factory.randomize().execute();
    }

    public void repaint() {
        factory.repaint().execute();
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
