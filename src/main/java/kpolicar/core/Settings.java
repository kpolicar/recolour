package kpolicar.core;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Settings {
    public Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    public LineBorder sourceBorder = new LineBorder(Color.GREEN, 5);
    public LineBorder targetBorder = new LineBorder(Color.RED, 5);
    public LineBorder hightlightBorder = new LineBorder(Color.YELLOW, 2);
    public boolean autosave = true;
    public String savePath = "save.xml";
}
