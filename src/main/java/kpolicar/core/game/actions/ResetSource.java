package kpolicar.core.game.actions;

import kpolicar.Main;
import kpolicar.core.Settings;
import kpolicar.game.Action;
import kpolicar.game.entity.Cell;
import kpolicar.ui.ButtonGrid;

public class ResetSource implements Action {
    ButtonGrid buttons;

    public ResetSource(ButtonGrid buttons) {
        this.buttons = buttons;
    }

    public void execute() {
        buttons.buttonAt(Main.preferences.source).setBorder(Main.settings.border);
        Main.preferences.source = null;
    }
}
