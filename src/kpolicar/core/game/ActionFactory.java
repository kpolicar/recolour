package kpolicar.core.game;

import kpolicar.Main;
import kpolicar.core.Game;
import kpolicar.game.Match;
import kpolicar.game.Score;
import kpolicar.core.game.actions.*;
import kpolicar.core.game.actions.Action;
import kpolicar.core.game.actions.Paint;

import java.awt.*;
import java.io.File;

public class ActionFactory implements kpolicar.game.ActionFactory {
    Game game;

    public ActionFactory(Game game) {
        this.game = game;
    }

    public Action assignSource(Point position) {
        return new AssignSource(game.match.board.cellAt(position).color, game.frame.palette);
    }

    public Action assignTarget(Point position) {
        return new AssignTarget(game.match.board.cellAt(position).color, game.frame.palette);
    }

    public Action reset() {
        return new Reset(game.frame.palette, game.match.score);
    }

    public Action paint(Point position, Color color, Score score) {
        return new Paint(game.frame, game.match.board, position, color, score);
    }

    public Action victory(Score score) {
        return new Victory(game.frame, score);
    }

    public Action randomize() {
        return new Randomize(game.frame, game.match.board, Main.preferences.palette);
    }

    public Action refresh() {
        return new Refresh(game);
    }

    public Action restart() {
        return () -> {
            randomize().execute();
            reset().execute();
        };
    }

    public Action save() {
        return new Save(game, Main.preferences.savePath);
    }

    public Load load(File file) {
        return new Load(game, file);
    }
}
