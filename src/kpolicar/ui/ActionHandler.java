package kpolicar.ui;

import kpolicar.ui.actions.Highlight;
import kpolicar.ui.actions.OpenGithub;

import java.awt.*;

public class ActionHandler {
    GameFrame frame;

    public ActionHandler(GameFrame frame) {
        this.frame = frame;
    }

    public void highlight(Color color) {
        new Highlight(frame, color).execute();
    }

    public void github() {
        new OpenGithub().execute();
    }
}
