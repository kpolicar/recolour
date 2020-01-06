package kpolicar.ui.listeners;

import kpolicar.ui.events.PreferencesChanged;

import java.awt.event.ActionEvent;
import java.util.EventListener;

public interface PreferencesListener extends EventListener {
    void preferencesChanged(PreferencesChanged event);
}
