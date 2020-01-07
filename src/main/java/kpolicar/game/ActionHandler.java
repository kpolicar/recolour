package kpolicar.game;

import kpolicar.Main;
import kpolicar.game.entity.Cell;

import java.awt.*;
import java.io.File;

public class ActionHandler {
    final protected Match match;
    final protected ActionFactory factory;
    final protected Score score;

    public ActionHandler(Match match, ActionFactory factory, Score score) {
        this.match = match;
        this.factory = factory;
        this.score = score;
    }

    public void assignSource(Point position) {
        factory.assignSource(position).execute();
        factory.save().execute();
    }

    public void assignTarget() {
        factory.assignTarget().execute();
    }

    public void paint(Point position) {
        if (!shouldPaint(position)) return;

        Cell source = match.board.cellAt(Main.preferences.source);
        factory.paint(position, source.color, score).execute();

        if (match.board.isWon()) {
            factory.victory(score).execute();
            remake();
        } else if (match.board.isLost()) {
            factory.lose(score).execute();
            remake();
        } else {
            factory.save().execute();
            factory.resetSource().execute();
        }
    }

    protected boolean shouldPaint(Point position) {
        for (Cell neighbor : match.board.neighborsOf(Main.preferences.source)) {
            if (neighbor.position.equals(position)) {
                return true;
            }
        }
        return false;
    }

    protected void remake() {
        factory.restart().execute();
        match.begin();
    }

    public void randomize() {
        factory.randomize().execute();
    }

    public void refresh() {
        factory.refresh().execute();
    }

    public void save() {
        factory.save().execute();
    }

    public void load(File file) {
        factory.load(file).execute();
    }

    public void restart() {
        factory.restart().execute();
    }
}
