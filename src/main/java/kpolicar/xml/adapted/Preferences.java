package kpolicar.xml.adapted;

import javax.xml.bind.annotation.*;
import java.awt.Point;

public class Preferences {
    public int columns;
    public int rows;

    @XmlElementWrapper(name = "palette")
    @XmlElement(name = "color")
    public java.awt.Color[] palette;
    public Point source;
    public java.awt.Color target;

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
