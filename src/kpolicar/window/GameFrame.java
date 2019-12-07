package kpolicar.window;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        setSize(300,300);
        setLayout(new GridLayout(3,3));

        Cell cell = new Cell();
        add(cell);

        setVisible(true);
    }

    public Component add(HasComponent wrapper) {
        return super.add(wrapper.getComponent());
    }
}
