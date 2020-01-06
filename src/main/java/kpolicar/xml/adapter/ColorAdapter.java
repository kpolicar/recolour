package kpolicar.xml.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.awt.Color;

public class ColorAdapter extends XmlAdapter<kpolicar.xml.adapted.Color, Color> {
    @Override
    public Color unmarshal(kpolicar.xml.adapted.Color domain) throws Exception {
        return new Color(domain.value);
    }

    @Override
    public kpolicar.xml.adapted.Color marshal(Color original) throws Exception {
        return new kpolicar.xml.adapted.Color(original);
    }
}
