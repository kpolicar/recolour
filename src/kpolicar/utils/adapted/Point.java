package kpolicar.utils.adapted;

import javax.xml.bind.annotation.XmlAttribute;

public class Point {
    @XmlAttribute
    public int x,y;

    public Point(java.awt.Point original) {
        x = original.x;
        y = original.y;
    }
}
