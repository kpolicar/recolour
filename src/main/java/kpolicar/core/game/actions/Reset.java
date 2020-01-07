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
        frame.palette.buttons.values().forEach(button -> button.setBorder(null));
        frame.buttonAt(Main.preferences.source).setBorder(Settings.border);
        score.reset();
        Main.preferences.source = null;
        Main.preferences.target = null;
    }
}
