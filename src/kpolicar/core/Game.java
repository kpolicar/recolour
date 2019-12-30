package kpolicar.core;

import kpolicar.core.game.ActionFactory;
import kpolicar.game.Match;
import kpolicar.game.Preferences;
import kpolicar.ui.GameFrame;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Game {
    @XmlTransient
    public GameFrame frame;
    public Match match;

    public Game() {
    }

    public Game(GameFrame frame, Preferences preferences) {
        this.frame = frame;
        match = new Match(preferences, new ActionFactory(this));

        new UiEventHandler(this);
    }

    public void begin() {
        match.begin();
    }
}
