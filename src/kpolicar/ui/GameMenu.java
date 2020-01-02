package kpolicar.ui;

import kpolicar.core.Settings;
import kpolicar.ui.listeners.OpenPreferences;
import kpolicar.ui.listeners.OpenGithub;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class GameMenu extends JMenuBar {
    public JMenuItem newGame;
    public JMenuItem loadGame;
    public JFileChooser loadGameDialog;
    public OpenPreferences preferences;

    public GameMenu() {
        super();

        JMenu play = new JMenu("Play");
        newGame = new JMenuItem("New game");
        loadGame = new JMenuItem("Load game");
        loadGameDialog = new JFileChooser();
        loadGame.addActionListener(e -> loadGameDialog.showOpenDialog(this));
        play.add(newGame);
        play.add(loadGame);
        add(play);

        JMenu settings = new JMenu("Settings");
        JMenuItem preferences = new JMenuItem("Preferences");
        JMenuItem autosave = new JCheckBoxMenuItem("Enable autosave", Settings.autosave);
        autosave.setEnabled(false);
        JMenuItem save = new JMenuItem("Save");
        save.setEnabled(false);
        KeyStroke keyStrokeToSave = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
        save.setAccelerator(keyStrokeToSave);

        KeyStroke keyStrokeToPreferences = KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK);
        preferences.addActionListener(this.preferences = new OpenPreferences(this));
        preferences.setAccelerator(keyStrokeToPreferences);

        settings.add(preferences);
        settings.add(autosave);
        settings.add(save);
        add(settings);

        JMenu help = new JMenu("Help");
        JMenuItem repository = new JMenuItem("Github");
        repository.addActionListener(new OpenGithub());
        help.add(repository);
        add(help);
    }
}
