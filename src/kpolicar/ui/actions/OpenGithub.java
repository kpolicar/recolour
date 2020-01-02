package kpolicar.ui.actions;

import kpolicar.ui.Action;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class OpenGithub implements Action {

    public void execute() {
        try {
            Desktop.getDesktop().browse(URI.create("https://github.com/kpolicar/recolour"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
