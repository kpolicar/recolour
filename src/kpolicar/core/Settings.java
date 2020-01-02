package kpolicar.core;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Settings {
    public static Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    public static LineBorder sourceBorder = new LineBorder(Color.GREEN, 5);
    public static LineBorder targetBorder = new LineBorder(Color.RED, 5);
    public static LineBorder hightlightBorder = new LineBorder(Color.YELLOW, 2);
    public static boolean autosave = true;
    public static String savePath = "save.xml";
}
