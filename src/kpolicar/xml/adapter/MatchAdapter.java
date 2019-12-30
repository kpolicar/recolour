package kpolicar.xml.adapter;


import kpolicar.core.Game;
import kpolicar.core.game.ActionFactory;
import kpolicar.game.Match;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MatchAdapter extends XmlAdapter<kpolicar.xml.adapted.Match, kpolicar.game.Match> {
    Game game;

    public MatchAdapter() {
    }

    public MatchAdapter(Game game) {
        this.game = game;
    }

    @Override
    public Match unmarshal(kpolicar.xml.adapted.Match loaded) throws Exception {
        return new kpolicar.game.Match(loaded.board, loaded.preferences, new ActionFactory(game));
    }

    @Override
    public kpolicar.xml.adapted.Match marshal(Match original) throws Exception {
        return new kpolicar.xml.adapted.Match(original);
    }
}
