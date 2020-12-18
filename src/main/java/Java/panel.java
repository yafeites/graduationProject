package Java;

import javax.swing.*;
import java.awt.*;

public class panel extends JPanel {
    Frame frame;

    public panel(Frame frame) {
        this.frame = frame;
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100,100);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(50,frame.getHeight()/2,10,10);
    }
}
