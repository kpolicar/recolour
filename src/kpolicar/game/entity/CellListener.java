package kpolicar.game.entity;

import java.util.EventListener;

public interface CellListener extends EventListener {
    void colorChanged(CellAbstract source);
}
