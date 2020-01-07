package kpolicar.core.game;

import kpolicar.Main;
import kpolicar.core.Game;
import kpolicar.core.Settings;
import kpolicar.game.Score;
import kpolicar.core.game.actions.*;
import kpolicar.game.Action;
import kpolicar.core.game.actions.Paint;

import java.awt.*;
import java.io.File;

public class ActionFactory implements kpolicar.game.ActionFactory {
    Game game;

    public ActionFactory(Game game) {
        this.game = game;
    }

    public Action assignSource(Point position) {
        return new AssignSource(game.frame.grid, game.match.board.cellAt(position));
    }

    public Action resetSource() {
        return new ResetSource(game.frame.grid);
    }

    public Action assignTarget() {
        return new AssignTarget(game.frame.palette);
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

    public Action lose(Score score) {
        return new Lose(game.frame, score);
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
        return new Save(game, Settings.savePath);
    }

    public Load load(File file) {
        return new Load(game, file);
    }
}
