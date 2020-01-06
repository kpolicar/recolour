package kpolicar.core.game.actions;

import kpolicar.core.Game;
import kpolicar.game.Action;
import kpolicar.xml.adapter.MatchAdapter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBException;
import java.io.File;

public class Load implements Action {
    File file;
    Game game;

    public Load(Game game, File file) {
        this.game = game;
        this.file = file;
    }

    public void execute() {
        Game loaded = null;
        try {
            loaded = readGame();
            game.prepare(loaded.match);
            game.resume();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private Game readGame() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(game.getClass());
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setAdapter(MatchAdapter.class, new MatchAdapter(game));
        return (Game) unmarshaller.unmarshal(file);
    }
}
