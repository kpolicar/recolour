package kpolicar.xml.adapted;

import javax.xml.bind.annotation.*;
import java.awt.*;

public class Preferences {
    public int columns;
    public int rows;

    @XmlElementWrapper(name = "palette")
    @XmlElement(name = "color")
    public Color[] palette;
    public Color source;
    public Color target;

    public Preferences() {
    }

    public Preferences(kpolicar.game.Preferences original) {
        columns = original.columns;
        rows = original.rows;
        palette = original.palette;
        source = original.source;
        target = original.target;
    }
}
