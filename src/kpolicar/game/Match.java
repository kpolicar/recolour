package kpolicar.game;

import kpolicar.xml.adapter.MatchAdapter;
import kpolicar.game.entity.Board;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(MatchAdapter.class)
public class Match {
    @XmlTransient
    final public ActionHandler actions;
    final public Board board;
    final public Preferences preferences;
    final public Score score = new Score();

    public Match(Preferences preferences, ActionFactory factory) {
        this(new Board(preferences.rows, preferences.columns), preferences, factory);
    }

    public Match(Board board, Preferences preferences, ActionFactory factory) {
        this.board = board;
        this.preferences = preferences;
        actions = new ActionHandler(this, factory, score);
    }

    public void begin() {
        actions.randomize();
    }
}
