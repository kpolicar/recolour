package kpolicar.core;

import kpolicar.Main;
import kpolicar.game.ActionHandler;
import kpolicar.game.Score;
import kpolicar.game.events.CellEvent;
import kpolicar.ui.GameFrame;
import kpolicar.ui.GridButton;

import javax.swing.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class UiEventHandler {
    Score score;
    ActionHandler actions;
    GameFrame gameFrame;

    public UiEventHandler(Game game) {
        this.gameFrame = game.frame;
        this.actions = game.match.actions;
        this.score = game.match.score;
        bindButtons();
        bindMenu();
    }

    private void bindButtons() {
        Stream.of(gameFrame.grid.buttons)
                .flatMap(Arrays::stream)
                .forEach(o -> o.addActionListener(e -> {
                    GridButton button = (GridButton) e.getSource();
                    new CellEvent(button.position, actions).handle();
                }));
    }

    private void bindMenu() {
        gameFrame.menu.newGame.addActionListener(e -> actions.restart());
        gameFrame.menu.loadGameDialog.addActionListener(e -> {
            JFileChooser fc = (JFileChooser) e.getSource();
            actions.load(fc.getSelectedFile());
        });
        gameFrame.menu.preferences.addSubmitListener(e -> {
            Main.preferences = e.preferences;
            Main.restartGame();
        });
    }
}
