package kpolicar.game.actions;

import kpolicar.game.ActionFactory;
import kpolicar.game.Score;
import kpolicar.ui.GameFrame;

import javax.swing.*;

public class Victory implements Action {
    Score score;
    GameFrame gameFrame;

    public Victory(GameFrame gameFrame, Score score) {
        this.gameFrame = gameFrame;
        this.score = score;
    }

    @Override
    public void execute() {
        JOptionPane.showMessageDialog(gameFrame, "Victory! Number of moves: "+score.moves());
    }
}
