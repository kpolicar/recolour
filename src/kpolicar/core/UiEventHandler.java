package kpolicar.core;

import kpolicar.Main;
import kpolicar.game.ActionHandler;
import kpolicar.ui.GameFrame;
import kpolicar.ui.GridButton;

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
        Stream.of(frame.grid.buttons)
                .flatMap(Arrays::stream)
                .forEach(o -> o.addActionListener(this));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GridButton button = (GridButton) e.getSource();
        if (Main.preferences.source == null) {
            actions.assignSource(button.position);
        } else if (Main.preferences.target == null) {
            actions.assignTarget(button.position);
        } else {
            actions.paint(button.position, Main.preferences.source);
        }
    }
}
