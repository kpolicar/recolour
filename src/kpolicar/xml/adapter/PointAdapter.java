package kpolicar.xml.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.awt.Point;

public class PointAdapter extends XmlAdapter<kpolicar.xml.adapted.Point, Point> {
    @Override
    public Point unmarshal(kpolicar.xml.adapted.Point domain) throws Exception {
        return new Point(domain.x, domain.y);
    }

    @Override
    public kpolicar.xml.adapted.Point marshal(Point original) throws Exception {
        return new kpolicar.xml.adapted.Point(original);
    }
}
