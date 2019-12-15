package kpolicar.core;

import kpolicar.Main;
import kpolicar.core.Game;
import kpolicar.game.ActionHandler;
import kpolicar.game.entity.Cell;
import kpolicar.game.entity.Board;
import kpolicar.ui.GameFrame;
import kpolicar.ui.GridButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.stream.Stream;

public class UiEventHandler implements ActionListener {
    ActionHandler actions;
    GameFrame frame;

    public UiEventHandler(Game game) {
        this.frame = game.frame;
        this.actions = game.actions;
        bindButtons();
    }

    private void bindButtons() {
        Stream.of(frame.buttons)
                .flatMap(Arrays::stream)
                .forEach(o -> o.addActionListener(this));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GridButton button = (GridButton) e.getSource();
        if (Main.preferences.source == null) {
            actions.begin(button.position);
        } else {
            actions.paint(button.position, Main.preferences.source);
        }
    }
}
