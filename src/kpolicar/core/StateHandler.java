package kpolicar.core;

import kpolicar.game.actions.Load;
import kpolicar.game.actions.Save;
import kpolicar.game.entity.Board;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class StateHandler {
    Board board;
    JAXBContext jaxbContext;
    Marshaller marshaller;
    Unmarshaller unmarshaller;

    public StateHandler(Board board) throws JAXBException {
        this.board = board;
        jaxbContext = JAXBContext.newInstance(board.getClass());
        marshaller = jaxbContext.createMarshaller();
        unmarshaller = jaxbContext.createUnmarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    }

    public void onSave() {
        try {
            (new Save(board, "output.xml")).execute(marshaller);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void onLoad() {
        try {
            (new Load(board, "output.xml")).execute(unmarshaller);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
