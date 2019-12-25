package kpolicar.game;

import kpolicar.Main;
import kpolicar.game.actions.*;
import kpolicar.game.actions.Paint;
import kpolicar.game.entity.Board;
import kpolicar.game.entity.Cell;
import kpolicar.ui.GameFrame;
import kpolicar.ui.GridButton;

import java.awt.*;

public class ActionHandler {
    Score playerScore;
    GameFrame gameFrame;
    Board board;

    public ActionHandler(GameFrame gameFrame, Board board, Score score) {
        this.gameFrame = gameFrame;
        this.board = board;
        this.playerScore = score;
    }

    public void assignSource(Point position) {
        execute(new AssignSource(board.cellAt(position).color, gameFrame.palette));
    }

    public void assignTarget(Point position) {
        execute(new AssignTarget(board.cellAt(position).color, gameFrame.palette));
    }

    public void paint(Point position, Color color) {
        execute(new Paint(gameFrame, board.cellAt(position), color));
    }

    public void randomize() {
        execute(new Randomize(board, Main.preferences.palette));
    }

    public void execute(GameAction action) {
        action.execute();
    }
}
