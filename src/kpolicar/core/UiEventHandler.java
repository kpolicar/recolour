package kpolicar.core;

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
    GameFrame frame;

    public UiEventHandler(GameFrame gameFrame, ActionHandler actions, Score score) {
        this.frame = gameFrame;
        this.actions = actions;
        this.score = score;
        bindButtons();
        bindMenu();
    }

    private void bindButtons() {
        Stream.of(frame.grid.buttons)
                .flatMap(Arrays::stream)
                .forEach(o -> o.addActionListener(e -> {
                    GridButton button = (GridButton) e.getSource();
                    new CellEvent(button.position, actions).handle();
                }));
    }

    private void bindMenu() {
        frame.menu.newGame.addActionListener(e -> actions.restart(score));
        frame.menu.loadGameDialog.addActionListener(e -> {
            JFileChooser fc = (JFileChooser) e.getSource();
            actions.load(fc.getSelectedFile());
        });
    }
}
