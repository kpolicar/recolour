package kpolicar.core.game.actions;

import kpolicar.Main;
import kpolicar.game.Action;
import kpolicar.game.Score;
import kpolicar.ui.PalettePanel;

public class Reset implements Action {
    Score score;
    PalettePanel palettePanel;

    public Reset(PalettePanel palettePanel, Score score) {
        this.palettePanel = palettePanel;
        this.score = score;
    }

    public void execute() {
        Main.preferences.source = null;
        Main.preferences.target = null;
        palettePanel.buttons.values().forEach(button -> button.setBorder(null));
        score.reset();
    }
}