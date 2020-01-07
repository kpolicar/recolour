package kpolicar.core.game.actions;

import kpolicar.Main;
import kpolicar.core.Settings;
import kpolicar.game.Action;
import kpolicar.game.Score;
import kpolicar.ui.GameFrame;

public class Reset implements Action {
    Score score;
    GameFrame frame;

    public Reset(GameFrame frame, Score score) {
        this.frame = frame;
        this.score = score;
    }

    public void execute() {
        if (Main.preferences.source != null) {
            frame.buttonAt(Main.preferences.source).setBorder(Main.settings.border);
        }
        frame.palette.buttons.values().forEach(button -> button.setBorder(null));
        score.reset();
        Main.preferences.source = null;
        Main.preferences.target = null;
    }
}
