package kpolicar.core.game.actions;

import kpolicar.Main;
import kpolicar.ui.PalettePanel;

import javax.swing.border.LineBorder;
import java.awt.*;

public class AssignTarget implements Action {
    final LineBorder border = new LineBorder(Color.RED, 5);
    PalettePanel palettePanel;
    Color color;

    public AssignTarget(Color color, PalettePanel palettePanel) {
        this.color = color;
        this.palettePanel = palettePanel;
    }

    public void execute() {
        Main.preferences.target = color;
        palettePanel.buttons.get(color).setBorder(border);
    }
}
