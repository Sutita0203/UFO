package game;

import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ufo {

    public ImageIcon c = new ImageIcon();
    public int x;
    public int y;
    public int count = 0;
    ufo() {
        c = new ImageIcon(this.getClass().getResource("UFO2.gif"));
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 50, 50));
    }
}
