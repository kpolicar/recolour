package kpolicar.game;

import kpolicar.Main;
import kpolicar.game.actions.*;
import kpolicar.game.actions.Action;
import kpolicar.game.actions.Paint;
import kpolicar.game.entity.Board;
import kpolicar.ui.GameFrame;
import java.awt.*;
import java.io.File;

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

    public Action reset(Score score) {
        return new Reset(gameFrame.palette, score);
    }

    public Action paint(Point position, Color color, Score score) {
        return new Paint(gameFrame, board, position, color, score);
    }

    public Action victory(Score score) {
        return new Victory(gameFrame, score);
    }

    public Action randomize() {
        return new Randomize(gameFrame, board, Main.preferences.palette);
    }

    public Action restart(Score score) {
        return () -> {
            randomize().execute();
            reset(score).execute();
        };
    }

    public Action save() {
        return new Save(board, Main.preferences.savePath);
    }

    public Load load(File file) {
        return new Load(gameFrame, board, file);
    }
}
