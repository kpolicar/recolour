package kpolicar.core;

import kpolicar.Main;
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

    public Game(GameFrame frame) {
        this.frame = frame;
    }

    public void prepare(Preferences preferences) {
        prepare(new Match(preferences, new ActionFactory(this)));
    }

    public void prepare(Match match) {
        Main.preferences = match.preferences;
        this.match = match;
        new UiEventHandler(this);
    }

    public void begin() {
        match.begin();
    }

    public void resume() {
        match.resume();
    }
}
