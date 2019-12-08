package kpolicar.game;

import kpolicar.ui.GameFrame;

import java.util.Arrays;
import java.util.stream.Stream;

public class EventHandler implements CellListener {
    GameFrame gameFrame;
    Field field;

    public EventHandler(GameFrame gameFrame, Field field) {
        this.gameFrame = gameFrame;
        this.field = field;
        bindCells();
    }

    private void bindCells() {
        Stream.of(field.cells)
                .flatMap(Arrays::stream)
                .forEach(o -> o.addListener(this));
    }

    @Override
    public void colorChanged(CellAbstract source) {
        gameFrame.buttonAt(source.position).setBackground(source.color);
    }
}
