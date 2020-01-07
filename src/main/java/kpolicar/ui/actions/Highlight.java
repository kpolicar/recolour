package kpolicar.ui.actions;

import kpolicar.Main;
import kpolicar.core.Settings;
import kpolicar.ui.Action;
import kpolicar.ui.GameFrame;
import kpolicar.ui.GridButton;

import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Highlight implements Action, Runnable {
    GameFrame frame;
    Color color;
    List<GridButton> buttons;

    public Highlight(GameFrame frame, Color color) {
        this.frame = frame;
        this.color = color;
    }

    public void run() {
        buttons = Stream.of(frame.grid.buttons)
                .flatMap(Arrays::stream)
                .filter(button -> button.getBackground().equals(color))
                .collect (Collectors.toList());

        try {
            blink();
            Thread.sleep(200);
            blink();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void blink() throws InterruptedException {
        buttons.forEach(b -> b.setBorder(Main.settings.hightlightBorder));
        Thread.sleep(200);
        buttons.forEach(b -> b.setBorder(Main.settings.border));
    }

    public void execute() {
        new Thread(this).start();
    }
}
