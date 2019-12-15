package kpolicar.ui;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class GameMenu extends JMenuBar {
    public GameMenu() {
        super();

        JMenu play = new JMenu("Play");
        JMenuItem newGame = new JMenuItem("New game");
        JMenuItem loadGame = new JMenuItem("Load game");
        play.add(newGame);
        play.add(loadGame);
        add(play);

        JMenu settings = new JMenu("Settings");
        JMenuItem preferences = new JMenuItem("Preferences");
        JMenuItem autosave = new JCheckBoxMenuItem("Enable autosave");
        JMenuItem save = new JMenuItem("Save");
        KeyStroke keyStrokeToSave = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
        save.setAccelerator(keyStrokeToSave);
        settings.add(preferences);
        settings.add(autosave);
        settings.add(save);
        add(settings);

        JMenu help = new JMenu("Help");
        add(help);
    }
}
