package kpolicar.game;

import java.util.EventListener;

public interface CellListener extends EventListener {
    void colorChanged(CellAbstract source);
}
