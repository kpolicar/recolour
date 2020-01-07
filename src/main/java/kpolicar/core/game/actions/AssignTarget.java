package kpolicar.core.game.actions;

import kpolicar.Main;
import kpolicar.core.Settings;
import kpolicar.game.Action;
import kpolicar.ui.PalettePanel;

import java.awt.*;
import java.util.Random;

public class AssignTarget implements Action {
    PalettePanel palettePanel;
    Random random = new Random();

    public AssignTarget(PalettePanel palettePanel) {
        this.palettePanel = palettePanel;
    }

    public void execute() {
        int index = random.nextInt(Main.preferences.palette.length);
        Color color = Main.preferences.palette[index];
        Main.preferences.target = color;
        palettePanel.buttons.get(color).setBorder(Main.settings.targetBorder);
    }
}
