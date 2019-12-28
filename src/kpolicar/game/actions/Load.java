package kpolicar.game.actions;

import kpolicar.game.entity.Board;
import kpolicar.game.entity.Cell;
import kpolicar.ui.GameFrame;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBException;
import java.io.File;

public class Load implements Action {
    GameFrame gameFrame;
    String path;
    Board board;

    public Load(GameFrame gameFrame, Board board, String path) {
        this.gameFrame = gameFrame;
        this.board = board;
        this.path = path;
    }

    public void execute() {
        Board loaded = null;
        try {
            loaded = readBoard();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        for (int row = 0; row < loaded.cells.length; row++) {
            for (int column = 0; column < loaded.cells[row].length; column++) {
                Cell cell = loaded.cells[row][column];
                board.cellAt(cell.position).color = cell.color;
                gameFrame.buttonAt(cell.position).setBackground(cell.color);
            }
        }
    }

    private Board readBoard() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(board.getClass());
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File xml = new File(path);
        return (Board) unmarshaller.unmarshal(xml);
    }
}
