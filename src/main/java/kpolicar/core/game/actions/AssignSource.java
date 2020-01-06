package kpolicar.core.game.actions;

import kpolicar.Main;
import kpolicar.core.Settings;
import kpolicar.game.Action;
import kpolicar.ui.PalettePanel;

import java.awt.*;

public class AssignSource implements Action {
    PalettePanel palettePanel;
    Color color;

    public AssignSource(Color color, PalettePanel palettePanel) {
        this.color = color;
        this.palettePanel = palettePanel;
    }

    public void execute() {
        Main.preferences.source = color;
        palettePanel.buttons.get(color).setBorder(Settings.sourceBorder);
    }
}
