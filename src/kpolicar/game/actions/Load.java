package kpolicar.game.actions;

import kpolicar.Main;
import kpolicar.game.entity.Board;
import kpolicar.game.entity.Cell;
import kpolicar.ui.GameFrame;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBException;
import java.io.File;

public class Load implements Action {
    File file;
    GameFrame gameFrame;
    Board board;

    public Load(GameFrame gameFrame, Board board, File file) {
        this.gameFrame = gameFrame;
        this.board = board;
        this.file = file;
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
        Main.preferences.source = Main.preferences.target = null;
        gameFrame.palette.buttons.forEach((color, jButton) -> jButton.setBorder(null));
    }

    private Board readBoard() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(board.getClass());
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Board) unmarshaller.unmarshal(file);
    }
}
