package kpolicar.game.adapter;


import kpolicar.game.Match;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MatchAdapter extends XmlAdapter<kpolicar.game.adapted.Match, kpolicar.game.Match> {
    @Override
    public Match unmarshal(kpolicar.game.adapted.Match v) throws Exception {
        return null;
        //return new kpolicar.game.Match(v.preferences);
    }

    @Override
    public kpolicar.game.adapted.Match marshal(Match v) throws Exception {
        return new kpolicar.game.adapted.Match(v);
    }
}
