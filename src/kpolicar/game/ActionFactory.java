package kpolicar.game;

import kpolicar.Main;
import kpolicar.core.game.actions.*;
import kpolicar.core.game.actions.Paint;

import java.awt.*;
import java.io.File;

public interface ActionFactory {
    Action assignSource(Point position);

    Action assignTarget(Point position);

    Action reset(Score score);

    Action paint(Point position, Color color, Score score);

    Action victory(Score score);

    Action randomize();

    Action repaint();

    Action restart(Score score);

    Action save();

    Action load(File file);
}
