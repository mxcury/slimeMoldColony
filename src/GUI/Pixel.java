package GUI;

import javax.swing.*;
import java.awt.*;

public class Pixel extends JLabel {
    Color color;
    public Pixel(Color color){
        this.color = color;
        setPreferredSize(new Dimension(55,55));
        setBackground(color);
    }


}
