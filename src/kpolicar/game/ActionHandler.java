package kpolicar.game;

import kpolicar.Main;
import kpolicar.game.actions.AssignSourceColor;
import kpolicar.game.actions.GameAction;
import kpolicar.game.actions.Paint;
import kpolicar.game.actions.Randomize;
import kpolicar.game.entity.Board;
import kpolicar.ui.GameFrame;

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

    public void begin(Point position) {
        execute(new AssignSourceColor(board.cellAt(position).color));
    }

    public void paint(Point position, Color color) {
        execute(new Paint(gameFrame.buttonAt(position), color));
    }

    public void randomize() {
        execute(new Randomize(board, Main.preferences.palette));
    }

    public void execute(GameAction action) {
        action.execute();
    }
}
