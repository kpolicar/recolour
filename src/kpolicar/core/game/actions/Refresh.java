package kpolicar.core.game.actions;

import kpolicar.Main;
import kpolicar.core.Game;
import kpolicar.game.Match;
import java.awt.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Refresh implements Action {
    Game game;

    public Refresh(Game game) {
        this.game = game;
    }

    public void execute() {
    }
}
