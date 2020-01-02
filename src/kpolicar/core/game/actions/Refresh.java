package kpolicar.core.game.actions;

import kpolicar.Main;
import kpolicar.core.Game;
import kpolicar.ui.PalettePanel;

import java.awt.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Refresh implements Action {
    Game game;

    public Refresh(Game game) {
        this.game = game;
    }

    public void execute() {
        game.frame.makeGameFields();
        game.ui.bindButtons();
        Stream.of(game.match.board.cells)
                .flatMap(Arrays::stream)
                .forEach(cell -> {
                    Color color = game.match.board.cellAt(cell.position).color;
                    game.frame.buttonAt(cell.position).setBackground(color);
                });
    }
}
