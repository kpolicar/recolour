package kpolicar.game.actions;

import kpolicar.game.entity.Board;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Save implements Action {
    String path;
    Board board;

    public Save(Board board, String path) {
        this.board = board;
        this.path = path;
    }

    public void execute() {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(board.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(board, new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
