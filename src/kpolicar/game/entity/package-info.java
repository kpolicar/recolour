@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(value = ColorAdapter.class, type = Color.class),
        @XmlJavaTypeAdapter(value = PointAdapter.class, type = Point.class)
})
package kpolicar.game.entity;

import kpolicar.utils.adapter.ColorAdapter;
import kpolicar.utils.adapter.PointAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.awt.*;
