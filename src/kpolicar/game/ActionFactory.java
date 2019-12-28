package kpolicar.game;

import kpolicar.Main;
import kpolicar.game.actions.*;
import kpolicar.game.actions.Action;
import kpolicar.game.actions.Paint;
import kpolicar.game.entity.Board;
import kpolicar.ui.GameFrame;
import java.awt.*;

public class ActionFactory {
    Board board;
    GameFrame gameFrame;

    public ActionFactory(Board board, GameFrame gameFrame) {
        this.board = board;
        this.gameFrame = gameFrame;
    }

    public Action assignSource(Point position) {
        return new AssignSource(board.cellAt(position).color, gameFrame.palette);
    }

    public Action assignTarget(Point position) {
        return new AssignTarget(board.cellAt(position).color, gameFrame.palette);
    }

    public Action reset() {
        return new Reset(gameFrame.palette);
    }

    public Action paint(Point position, Color color) {
        return new Paint(gameFrame, board, position, color);
    }

    public Action victory() {
        return new Victory(gameFrame);
    }

    public Action randomize() {
        return new Randomize(gameFrame, board, Main.preferences.palette);
    }

    public Action restart() {
        return () -> {
            randomize().execute();
            reset().execute();
        };
    }

    public Action save() {
        return new Save(board, "output.xml");
    }

    public Action load() {
        return new Load(gameFrame, board, "output.xml");
    }
}
