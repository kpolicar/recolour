package kpolicar.game.actions;

import kpolicar.game.ActionFactory;
import kpolicar.ui.GameFrame;

import javax.swing.*;

public class Victory implements Action {
    GameFrame gameFrame;

    public Victory(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    @Override
    public void execute() {
        JOptionPane.showMessageDialog(gameFrame, "Victory!");
    }
}
