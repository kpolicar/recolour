package kpolicar.ui.events;

import kpolicar.game.Preferences;
import kpolicar.ui.PreferencesPanel;

public class PreferencesChanged {
    final public Preferences preferences;

    public PreferencesChanged(PreferencesPanel form) {
        int rows = (int) form.rows.getValue();
        int columns = (int) form.columns.getValue();
        int variations = (int) form.variations.getValue();

        preferences = new Preferences(rows, columns, variations);
    }
}
