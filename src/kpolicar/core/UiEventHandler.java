package kpolicar.core;

import kpolicar.game.actions.Load;
import kpolicar.game.events.CellEvent;
import kpolicar.game.ActionHandler;
import kpolicar.ui.GameFrame;
import kpolicar.ui.GridButton;

import java.util.Arrays;
import java.util.stream.Stream;

public class UiEventHandler {
    ActionHandler actions;
    GameFrame frame;

    public UiEventHandler(Game game) {
        this.frame = game.frame;
        this.actions = game.actions;
        bindButtons();
        bindMenu();
    }

    private void bindButtons() {
        Stream.of(frame.grid.buttons)
                .flatMap(Arrays::stream)
                .forEach(o -> o.addActionListener(e -> {
                    GridButton button = (GridButton) e.getSource();
                    (new CellEvent(button.position, actions)).handle();
                }));
    }

    private void bindMenu() {
        frame.menu.loadGame.addActionListener(e -> {
            actions.load();
        });
    }
}
