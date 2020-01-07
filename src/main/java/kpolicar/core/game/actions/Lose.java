package kpolicar.core.game.actions;

import kpolicar.game.Action;
import kpolicar.game.Score;
import kpolicar.ui.GameFrame;

import javax.swing.*;

public class Lose implements Action {
    Score score;
    GameFrame gameFrame;

    public Lose(GameFrame gameFrame, Score score) {
        this.gameFrame = gameFrame;
        this.score = score;
    }

    public void execute() {
        JOptionPane.showMessageDialog(gameFrame, "You lose! Number of moves: " + score.moves());
    }
}
