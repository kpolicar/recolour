package kpolicar.ui.listeners;

import kpolicar.ui.GameMenu;
import kpolicar.ui.PreferencesPanel;
import kpolicar.ui.events.PreferencesChanged;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenPreferences implements ActionListener {
    PreferencesPanel form;
    GameMenu gameMenu;
    protected EventListenerList listenerList = new EventListenerList();

    public OpenPreferences(GameMenu gameMenu) {
        this.gameMenu = gameMenu;
    }

    public void actionPerformed(ActionEvent e) {
        form = new PreferencesPanel();

        int result = JOptionPane.showConfirmDialog(gameMenu,
                form,
                "Preferences",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            firePreferencesChanged();
        }
    }

    protected void firePreferencesChanged() {
      Object[] listeners = listenerList.getListenerList();
      for (int i = listeners.length-2; i>=0; i-=2) {
          if (listeners[i]==PreferencesListener.class) {
              ((PreferencesListener)listeners[i+1]).preferencesChanged(new PreferencesChanged(form));
          }
      }
  }

    public void addApplyListener(PreferencesListener l) {
        listenerList.add(PreferencesListener.class, l);
    }

    public void removeApplyListener(PreferencesListener l) {
        listenerList.remove(PreferencesListener.class, l);
    }
}
