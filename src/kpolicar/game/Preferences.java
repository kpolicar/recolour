package kpolicar.game;

import java.awt.*;
import java.util.Random;

public class Preferences {
    public int columns;
    public int rows;

    Color[] palette;
    public Color source = Color.RED;
    Color target;

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
