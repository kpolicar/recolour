package kpolicar.ui;

import kpolicar.Main;
import kpolicar.game.Cell;
import kpolicar.game.Board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.stream.Stream;

public class EventHandler implements ActionListener {
    GameFrame gameFrame;
    Board board;

    public EventHandler(GameFrame gameFrame, Board board) {
        this.gameFrame = gameFrame;
        this.board = board;
        bindButtons();
    }

    private void bindButtons() {
        Stream.of(gameFrame.buttons)
                .flatMap(Arrays::stream)
                .forEach(o -> o.addActionListener(this));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GridButton button = (GridButton) e.getSource();
        Cell cell = board.cellAt(button.position);
        cell.color(Main.preferences.source);
    }
}
