package kpolicar.utils.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.awt.Color;

public class ColorAdapter extends XmlAdapter<kpolicar.utils.adapted.Color, Color> {
    @Override
    public Color unmarshal(kpolicar.utils.adapted.Color domain) throws Exception {
        return new Color(domain.value);
    }

    @Override
    public kpolicar.utils.adapted.Color marshal(Color original) throws Exception {
        return new kpolicar.utils.adapted.Color(original);
    }
}
