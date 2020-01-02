@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(value = ColorAdapter.class, type = Color.class),
        @XmlJavaTypeAdapter(value = PointAdapter.class, type = Point.class),
        @XmlJavaTypeAdapter(value = MatchAdapter.class, type = Match.class),
        @XmlJavaTypeAdapter(value = BoardAdapter.class, type = Board.class),
        @XmlJavaTypeAdapter(value = CellAdapter.class, type = Cell.class),
})
package kpolicar.xml.adapted;

import kpolicar.game.Match;
import kpolicar.xml.adapter.CellAdapter;
import kpolicar.xml.adapter.MatchAdapter;
import kpolicar.xml.adapter.BoardAdapter;
import kpolicar.game.entity.Board;
import kpolicar.game.entity.Cell;
import kpolicar.utils.adapter.ColorAdapter;
import kpolicar.utils.adapter.PointAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.awt.*;