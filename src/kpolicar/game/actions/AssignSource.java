package kpolicar.game.actions;

import kpolicar.Main;
import kpolicar.ui.PalettePanel;

import javax.swing.border.LineBorder;
import java.awt.*;

public class AssignSource implements GameAction {
    final LineBorder border = new LineBorder(Color.GREEN, 5);
    PalettePanel palettePanel;
    Color color;

    public AssignSource(Color color, PalettePanel palettePanel) {
        this.color = color;
        this.palettePanel = palettePanel;
    }

    @Override
    public void execute() {
        Main.preferences.source = color;
        palettePanel.buttons.get(color).setBorder(border);
    }
}
