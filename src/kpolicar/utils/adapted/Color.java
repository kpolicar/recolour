package kpolicar.utils.adapted;

import javax.xml.bind.annotation.XmlValue;

public class Color {
    @XmlValue
    public int value;

    public Color() {
    }

    public Color(java.awt.Color original) {
        value = original.getRGB();
    }
}
