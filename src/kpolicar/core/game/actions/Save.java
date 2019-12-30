package kpolicar.core.game.actions;

import kpolicar.core.Game;
import kpolicar.xml.adapter.MatchAdapter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Save implements Action {
    String path;
    Game game;

    public Save(Game game, String path) {
        this.game = game;
        this.path = path;
    }

    public void execute() {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(game.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setAdapter(MatchAdapter.class, new MatchAdapter());
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(game, new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
