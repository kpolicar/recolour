package kpolicar.game;

import kpolicar.Main;
import kpolicar.core.Game;
import kpolicar.game.actions.*;
import kpolicar.game.actions.Paint;

import java.awt.*;

public class ActionHandler {
    Game game;

    public ActionHandler(Game game) {
        this.game = game;
    }

    public void assignSource(Point position) {
        execute(new AssignSource(game.board.cellAt(position).color, game.frame.palette));
    }

    public void assignTarget(Point position) {
        execute(new AssignTarget(game.board.cellAt(position).color, game.frame.palette));
    }

    public void paint(Point position, Color color) {
        execute(new Paint(game.frame, game.board.cellAt(position), color));
        game.state.onSave();
    }

    public void randomize() {
        execute(new Randomize(game.board, Main.preferences.palette));
    }

    public void execute(GameAction action) {
        action.execute();
    }

    public void load() {
        game.state.onLoad();
    }
}
