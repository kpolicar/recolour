package kpolicar.game;

import kpolicar.Main;
import kpolicar.game.entity.Cell;

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

    public void assignTarget() {
        factory.assignTarget().execute();
    }

    public void paint(Point position) {
        if (!shouldPaint(position)) return;

        Cell source = match.board.cellAt(Main.preferences.source);
        factory.paint(position, source.color, score).execute();

        if (match.board.isComplete()) {
            factory.victory(score).execute();
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
