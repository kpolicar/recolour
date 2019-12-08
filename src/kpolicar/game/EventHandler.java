package kpolicar.game;

import kpolicar.ui.GameFrame;

import java.util.Arrays;
import java.util.stream.Stream;

public class EventHandler implements CellListener {
    GameFrame gameFrame;
    Board board;

    public EventHandler(GameFrame gameFrame, Board board) {
        this.gameFrame = gameFrame;
        this.board = board;
        bindCells();
    }

    private void bindCells() {
        Stream.of(board.cells)
                .flatMap(Arrays::stream)
                .forEach(o -> o.addListener(this));
    }

    @Override
    public void colorChanged(CellAbstract source) {
        gameFrame.buttonAt(source.position).setBackground(source.color);
    }
}
