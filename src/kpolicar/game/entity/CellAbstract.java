package kpolicar.game.entity;

import javax.swing.event.EventListenerList;
import javax.xml.bind.annotation.*;
import java.awt.*;

public abstract class CellAbstract {
    @XmlTransient
    public Point position;
    @XmlTransient
    public Color color;
    @XmlTransient
    protected EventListenerList listenerList = new EventListenerList();

    @XmlAttribute(name = "x")
    public int getX() {
        return position.x;
    }

    @XmlAttribute(name = "y")
    public int getY() {
        return position.y;
    }

    @XmlValue
    public String getColor() {
        return color.toString() ;
    }

    protected void fireColorChanged() {
        Object[] listeners = listenerList.getListenerList();
        for (int i = listeners.length-2; i>=0; i-=2) {
            if (listeners[i]== CellListener.class) {
                ((CellListener)listeners[i+1]).colorChanged(this);
            }
        }
    }

    public void addListener(CellListener l) {
        listenerList.add(CellListener.class, l);
    }

    public void removeListener(CellListener l) {
        listenerList.remove(CellListener.class, l);
    }

    public CellListener[] getListeners() {
        return listenerList.getListeners(CellListener.class);
    }
}
