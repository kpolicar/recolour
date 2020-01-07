package kpolicar.xml.adapter;

import kpolicar.game.entity.Cell;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CellAdapter extends XmlAdapter<kpolicar.xml.adapted.Cell, Cell> {
    public Cell unmarshal(kpolicar.xml.adapted.Cell loaded) throws Exception {
        Cell cell = new Cell(loaded.x, loaded.y);
        cell.color = loaded.color;
        return cell;
    }

    public kpolicar.xml.adapted.Cell marshal(Cell original) throws Exception {
        return new kpolicar.xml.adapted.Cell(original);
    }
}
