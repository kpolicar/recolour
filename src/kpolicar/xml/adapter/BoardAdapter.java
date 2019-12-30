package kpolicar.xml.adapter;

import kpolicar.xml.adapted.Board;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BoardAdapter extends XmlAdapter<Board, kpolicar.game.entity.Board> {
    @Override
    public kpolicar.game.entity.Board unmarshal(Board loaded) throws Exception {
        return new kpolicar.game.entity.Board(loaded.cells);
    }

    @Override
    public Board marshal(kpolicar.game.entity.Board original) throws Exception {
        return new Board(original);
    }
}
