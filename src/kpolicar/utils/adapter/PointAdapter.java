package kpolicar.utils.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.awt.Point;

public class PointAdapter extends XmlAdapter<kpolicar.utils.adapted.Point, Point> {
    @Override
    public Point unmarshal(kpolicar.utils.adapted.Point domain) throws Exception {
        return new Point(domain.x, domain.y);
    }

    @Override
    public kpolicar.utils.adapted.Point marshal(Point original) throws Exception {
        return new kpolicar.utils.adapted.Point(original);
    }
}
