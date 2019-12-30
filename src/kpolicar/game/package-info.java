@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(value = ColorAdapter.class, type = Color.class),
        @XmlJavaTypeAdapter(value = PointAdapter.class, type = Point.class)
})
package kpolicar.game;

import kpolicar.utils.adapter.ColorAdapter;
import kpolicar.utils.adapter.PointAdapter;

import javax.xml.bind.annotation.adapters.*;
import java.awt.*;
