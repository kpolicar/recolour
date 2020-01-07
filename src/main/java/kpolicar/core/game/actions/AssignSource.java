package kpolicar.core.game.actions;

import kpolicar.Main;
import kpolicar.core.Settings;
import kpolicar.game.Action;
import kpolicar.game.entity.Cell;
import kpolicar.ui.ButtonGrid;

public class AssignSource implements Action {
    ButtonGrid buttons;
    Cell cell;

    public AssignSource(ButtonGrid buttons, Cell cell) {
        this.buttons = buttons;
        this.cell = cell;
    }

    public void execute() {
        Main.preferences.source = cell.position;
        buttons.buttonAt(cell.position).setBorder(Main.settings.sourceBorder);
    }
}
