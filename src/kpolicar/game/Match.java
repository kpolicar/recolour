package kpolicar.game;

import kpolicar.game.entity.Board;
import kpolicar.ui.GameFrame;

import javax.xml.bind.annotation.*;
import java.awt.*;

@XmlRootElement
public class Match {
    @XmlTransient
    public ActionHandler actions;
    public Board board;
    public Score score = new Score();
    public Preferences preferences;

    Match() {

    }

    public Match(Preferences preferences, GameFrame gameFrame) {
        board = new Board();
        actions = new ActionHandler(this, gameFrame);
        this.preferences = preferences;
    }

    public void begin() {
        actions.randomize();
    }
}
