package kpolicar.ui;

import kpolicar.game.Field;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class EventHandler implements ActionListener {
    GameFrame gameFrame;
    Field field;

    public EventHandler(GameFrame gameFrame, Field field) {
        this.gameFrame = gameFrame;
        this.field = field;
        bindButtons();
    }

    private void bindButtons() {
        Arrays.stream(gameFrame.buttons).forEach(o -> o.addActionListener(this));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GridButton button = (GridButton) e.getSource();
        System.out.println(button.position);
    }
}
