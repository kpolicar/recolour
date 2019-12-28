package kpolicar.game.actions;

import kpolicar.Main;
import kpolicar.ui.PalettePanel;

public class Reset implements Action {
    PalettePanel palettePanel;

    public Reset(PalettePanel palettePanel) {
        this.palettePanel = palettePanel;
    }
    public void execute() {
        Main.preferences.source = Main.preferences.target = null;
        palettePanel.buttons.values().forEach(button -> button.setBorder(null));
    }
}
