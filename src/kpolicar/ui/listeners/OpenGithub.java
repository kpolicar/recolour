package kpolicar.ui.listeners;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;

public class OpenGithub implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Desktop.getDesktop().browse(URI.create("https://github.com/kpolicar/recolour"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
