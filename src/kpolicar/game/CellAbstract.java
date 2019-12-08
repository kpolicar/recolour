package kpolicar.game;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ItemListener;

public abstract class CellAbstract {
    Point position;
    Color color;
    protected EventListenerList listenerList = new EventListenerList();

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
