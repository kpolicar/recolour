package kpolicar.game;

import javax.xml.bind.annotation.*;
import java.awt.*;
import java.util.Random;

public class Preferences {
    public int columns;
    public int rows;

    @XmlElementWrapper(name = "palette")
    @XmlElement(name = "color")
    public Color[] palette;
    public Color source;
    public Color target;
    @XmlTransient
    public String savePath = "save.xml";

    public Preferences() {
    }

    public Preferences(int rows, int columns, int variations) {
        this.rows = rows;
        this.columns = columns;
        generatePalette(variations);
    }

    public void generatePalette(int number) {
        Random rand = new Random();

        palette = new Color[number];
        for (int i = 0; i < number; i++) {
            palette[i] = new Color(
                    rand.nextInt(255),
                    rand.nextInt(255),
                    rand.nextInt(255));
        }
    }
}
