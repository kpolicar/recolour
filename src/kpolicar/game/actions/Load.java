package kpolicar.game.actions;

import kpolicar.game.entity.Board;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Load implements GameAction {
    String path;
    Board board;

    public Load(Board board, String path) {
        this.board = board;
        this.path = path;
    }

    public void execute(Unmarshaller unmarshaller) throws JAXBException {
        File xml = new File(path);
        Board config = (Board) unmarshaller.unmarshal(xml);
        System.out.println(config.cells[0][0].color.toString());
    }

    @Override
    public void execute() {
    }
}
