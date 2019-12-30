package kpolicar.game.actions;

import kpolicar.game.Match;
import kpolicar.game.entity.Board;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Save implements Action {
    String path;
    Match match;

    public Save(Match match, String path) {
        this.match = match;
        this.path = path;
    }

    public void execute() {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(match.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(match, new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
