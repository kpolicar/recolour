package kpolicar.game;

import kpolicar.game.entity.Board;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Match {
    @XmlTransient
    final public ActionHandler actions;
    final public Board board;
    final public Preferences preferences;
    final public Score score = new Score();

    public Match(Preferences preferences, ActionFactory factory) {
        board = new Board(preferences.rows, preferences.columns);
        this.preferences = preferences;
        actions = new ActionHandler(this, factory, score);
    }

    public void begin() {
        actions.randomize();
    }
}
