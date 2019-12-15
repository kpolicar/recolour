package kpolicar.core;

import kpolicar.core.Game;
import kpolicar.game.ActionHandler;
import kpolicar.game.entity.Board;
import kpolicar.game.entity.CellAbstract;
import kpolicar.game.entity.CellListener;
import kpolicar.ui.GameFrame;

import java.util.Arrays;
import java.util.stream.Stream;

public class GameEventHandler implements CellListener {
    ActionHandler actions;
    Board board;

    public GameEventHandler(Game game) {
        this.board = game.board;
        this.actions = game.actions;
        bindCells();
    }

    private void bindCells() {
        Stream.of(board.cells)
                .flatMap(Arrays::stream)
                .forEach(o -> o.addListener(this));
    }

    @Override
    public void colorChanged(CellAbstract source) {
        actions.paint(source.position, source.color);
    }
}
