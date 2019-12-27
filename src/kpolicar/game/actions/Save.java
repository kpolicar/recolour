package kpolicar.game.actions;

import kpolicar.game.entity.Board;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Save {
    String path;
    Board board;

    public Save(Board board, String path) {
        this.board = board;
        this.path = path;
    }

    public void execute(Marshaller marshaller) throws JAXBException {
        marshaller.marshal(board, new File(path));
    }
}
