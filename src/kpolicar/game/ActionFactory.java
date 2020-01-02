package kpolicar.game;

import kpolicar.core.game.actions.*;
import java.awt.*;
import java.io.File;

public interface ActionFactory {
    Action assignSource(Point position);

    Action assignTarget(Point position);

    Action reset();

    Action paint(Point position, Color color, Score score);

    Action victory(Score score);

    Action randomize();

    Action refresh();

    Action restart();

    Action save();

    Action load(File file);
}
